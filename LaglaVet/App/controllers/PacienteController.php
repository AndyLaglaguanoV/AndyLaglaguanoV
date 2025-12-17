<?php
require_once __DIR__ . '/../models/Paciente.php';
require_once __DIR__ . '/../models/Usuario.php';
require_once __DIR__ . '/../models/Auditoria.php';

class PacienteController {

    /* ========= VALIDACIONES ========= */
    private function authAdmin() {
        if (!isset($_SESSION['user']) || $_SESSION['user']['rol'] !== 'administrador') {
            die("Acceso denegado");
        }
    }
private function authPaciente() {
    if (!isset($_SESSION['user']) || $_SESSION['user']['rol'] !== 'paciente') {
        die("Acceso denegado");
    }
}



// ✅ Formulario para completar/editar el perfil
public function profile() {
    $this->authPaciente();

    $paciente = Paciente::findByUser($_SESSION['user']['id'], 'paciente');

    require_once __DIR__ . '/../views/paciente/profile.php';
}

    private function authAdminOrDoctor() {
        if (!isset($_SESSION['user']) ||
            !in_array($_SESSION['user']['rol'], ['administrador', 'doctor'])) {
            die("Acceso denegado");
        }
    }

    // ✅ Guardar perfil (crear si no existe / actualizar si existe)
public function saveProfile() {
    $this->authPaciente();

    // Buscar perfil de paciente por usuario_id
    $paciente = Paciente::findByUser($_SESSION['user']['id'], 'administrador');

    // 🔹 SI NO EXISTE → CREARLO AUTOMÁTICAMENTE
    if (!$paciente) {

        // Crear perfil base usando conexión de ADMIN
        $pacienteId = Paciente::create([
            'usuario_id' => $_SESSION['user']['id'],
            'cedula'     => $_POST['cedula'] ?? '',
            'telefono'   => $_POST['telefono'] ?? '',
            'direccion'  => $_POST['direccion'] ?? ''
        ], 'administrador');

        Auditoria::registrar(
            $_SESSION['user']['id'],
            'INSERT',
            'pacientes',
            $pacienteId,
            'Paciente creó su perfil inicial'
        );

        $_SESSION['success'] = "Perfil creado correctamente";
        header("Location: index.php?url=paciente/profile");
        exit;
    }

    // 🔹 SI YA EXISTE → SOLO ACTUALIZAR
    Paciente::update(
        (int)$paciente['id'],
        [
            'cedula'     => $_POST['cedula'] ?? '',
            'telefono'   => $_POST['telefono'] ?? '',
            'direccion'  => $_POST['direccion'] ?? ''
        ],
        'administrador'
    );

    Auditoria::registrar(
        $_SESSION['user']['id'],
        'UPDATE',
        'pacientes',
        $paciente['id'],
        'Paciente actualizó su perfil'
    );

    $_SESSION['success'] = "Perfil actualizado correctamente";
    header("Location: index.php?url=paciente/profile");
}


/* ========= DASHBOARD PACIENTE ========= */
// ✅ Dashboard del paciente
public function dashboard() {
    $this->authPaciente();

    // Traer el perfil si ya existe
    $paciente = Paciente::findByUser($_SESSION['user']['id'], 'paciente');

    require_once __DIR__ . '/../views/paciente/dashboard.php';
}

    /* ========= LISTAR ========= */
    public function index() {
        $this->authAdminOrDoctor();
        $pacientes = Paciente::all($_SESSION['user']['rol']);
        require_once __DIR__ . '/../views/pacientes/index.php';
    }

    /* ========= FORM ========= */
    public function create() {
        $this->authAdmin();
        require_once __DIR__ . '/../views/pacientes/create.php';
    }

    /* ========= CREAR PACIENTE NUEVO ========= */
    public function storeNuevo() {
        $this->authAdmin();

        try {
            $usuarioId = Usuario::createPaciente([
                'nombre'   => $_POST['nombre'],
                'email'    => $_POST['email'],
                'password' => $_POST['password']
            ]);

            $pacienteId = Paciente::create([
                'usuario_id' => $usuarioId,
                'cedula'     => $_POST['cedula'] ?? '',
                'telefono'   => $_POST['telefono'] ?? '',
                'direccion'  => $_POST['direccion'] ?? ''
            ], 'administrador');

            Auditoria::registrar(
                $_SESSION['user']['id'],
                'INSERT',
                'pacientes',
                $pacienteId,
                'Administrador creó paciente'
            );

            header("Location: index.php?url=paciente/index");
        } catch (Exception $e) {
            die($e->getMessage());
        }
    }

    /* ========= BUSCADOR ========= */
    public function search() {
        $this->authAdminOrDoctor();
        $term = $_GET['term'] ?? '';
        echo json_encode(Paciente::searchByName($term));
    }

    /* ========= EDITAR ========= */
    public function edit() {
        $this->authAdminOrDoctor();

        $pacienteId = $_GET['id'] ?? 0;
        if (!$pacienteId) {
            die("ID de paciente no recibido");
        }

        $paciente = Paciente::find(
            (int)$pacienteId,
            $_SESSION['user']['rol']
        );

        if (!$paciente) {
            die("Paciente no encontrado");
        }

        require_once __DIR__ . '/../views/pacientes/edit.php';
    }

    /* ========= ACTUALIZAR ========= */
   public function update() {
    $this->authAdminOrDoctor();

    $pacienteId = $_POST['id'] ?? 0;
    $usuarioId  = $_POST['usuario_id'] ?? 0;

    if (!$pacienteId || !$usuarioId) {
        die("Datos incompletos");
    }

    try {
        // 1️⃣ Actualizar datos del paciente
        Paciente::update(
            (int)$pacienteId,
            $_POST,
            $_SESSION['user']['rol']
        );

        // 2️⃣ Actualizar nombre y correo del usuario
        Usuario::updateUser(
            (int)$usuarioId,
            $_POST['nombre'],
            $_POST['email']
        );

        // 3️⃣ Auditoría
        Auditoria::registrar(
            $_SESSION['user']['id'],
            'UPDATE',
            'usuarios / pacientes',
            $pacienteId,
            'Administrador actualizó datos del paciente'
        );

        // 4️⃣ Volver al listado (refresca la tabla)
        header("Location: index.php?url=paciente/index");

    } catch (Exception $e) {
        die($e->getMessage());
    }
}




    /* ========= DELETE ========= */
  public function delete() {
    $this->authAdmin();

    $id = (int)($_GET['id'] ?? 0);
    if ($id <= 0) {
        die("ID inválido");
    }

    Paciente::deleteCompleto($id);

    Auditoria::registrar(
        $_SESSION['user']['id'],
        'DELETE',
        'pacientes',
        $id,
        'Administrador eliminó paciente y dependencias'
    );

    header("Location: index.php?url=paciente/index");
    exit;
}

}
