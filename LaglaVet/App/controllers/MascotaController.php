<?php
require_once __DIR__ . '/../models/Mascota.php';
require_once __DIR__ . '/../models/Paciente.php';
require_once __DIR__ . '/../models/Auditoria.php';

class MascotaController {

    private function auth(array $roles) {
        if (!isset($_SESSION['user']) || !in_array($_SESSION['user']['rol'], $roles)) {
            die("Acceso denegado");
        }
    }

    /* ================== LISTAR ================== */
    public function index() {
        $this->auth(['administrador', 'doctor', 'paciente']);
        $rol = $_SESSION['user']['rol'];

        if ($rol === 'paciente') {
            $paciente = Paciente::findByUser($_SESSION['user']['id'], 'paciente');
            if (!$paciente) {
                die("Paciente no encontrado");
            }
            $mascotas = Mascota::porPaciente($paciente['id'], 'paciente');
        } else {
            $mascotas = Mascota::all($rol);
        }

        require_once __DIR__ . '/../views/mascotas/index.php';
    }

    /* ================== CREATE ================== */
  public function create() {
    $this->auth(['administrador','paciente']);

    $rol = $_SESSION['user']['rol'];
    $pacientes = [];

    if ($rol === 'administrador') {
        $pacientes = Paciente::all('administrador'); // admin elige dueño
    }

    if ($rol === 'paciente') {
        $p = Paciente::findByUser($_SESSION['user']['id'], 'paciente');
        if (!$p) {
            header("Location: index.php?url=paciente/profile");
            exit;
        }
    }

    require_once __DIR__ . '/../views/mascotas/create.php';
}

    /* ================== STORE ================== */
public function store() {
    $this->auth(['administrador','paciente']);
    $rol = $_SESSION['user']['rol'];

    if ($rol === 'administrador') {
        if (empty($_POST['paciente_id'])) die("Debe seleccionar un paciente");
        $pacienteId = (int)$_POST['paciente_id'];
    } else {
        $p = Paciente::findByUser($_SESSION['user']['id'], 'paciente');
        if (!$p) {
            header("Location: index.php?url=paciente/profile");
            exit;
        }
        $pacienteId = (int)$p['id'];
    }

   Mascota::create([
    'paciente_id' => $pacienteId,
    'nombre'      => $_POST['nombre'],
    'especie'     => $_POST['especie'],
    'raza'        => $_POST['raza'] ?? null,
    'edad'        => $_POST['edad'] ?? null
], $rol);

    header("Location: index.php?url=mascota/index");
}

public function edit() {
    // Admin y doctor pueden editar
    $this->auth(['administrador', 'doctor']);

    $rol = $_SESSION['user']['rol'];
    $id  = (int)($_GET['id'] ?? 0);

    if ($id <= 0) {
        die("ID de mascota no recibido");
    }

    // Buscar mascota
    $mascota = Mascota::find($id, $rol);

    if (!$mascota) {
        die("Mascota no encontrada");
    }

    // Para admin: cargar pacientes (por si quieres cambiar dueño)
    $pacientes = [];
    if ($rol === 'administrador') {
        $pacientes = Paciente::all('administrador');
    }

    require_once __DIR__ . '/../views/mascotas/edit.php';
}
public function update() {
    // Admin y paciente pueden actualizar
    if (!isset($_SESSION['user'])) {
        die("Acceso denegado");
    }

    $rol = $_SESSION['user']['rol'];

    if (!in_array($rol, ['administrador', 'paciente'])) {
        die("Acceso denegado");
    }

    // Validar ID
    $id = (int)($_POST['id'] ?? 0);
    if ($id <= 0) {
        die("ID inválido");
    }

    // Obtener la mascota
    $mascota = Mascota::find($id, $rol);
    if (!$mascota) {
        die("Mascota no encontrada");
    }

    // 🔐 Si es paciente, verificar que la mascota sea suya
    if ($rol === 'paciente') {
        $paciente = Paciente::findByUser($_SESSION['user']['id'], 'paciente');
        if (!$paciente || $mascota['paciente_id'] != $paciente['id']) {
            die("No puedes editar mascotas que no son tuyas");
        }
    }

    // Actualizar
    Mascota::update($id, [
        'nombre'  => $_POST['nombre'],
        'especie' => $_POST['especie'],
        'raza'    => $_POST['raza'] ?? null,
        'edad'    => $_POST['edad'] ?? null
    ], $rol);

    // Auditoría
    Auditoria::registrar(
        $_SESSION['user']['id'],
        'UPDATE',
        'mascotas',
        $id,
        'Actualizó mascota'
    );

    // Volver al listado
    header("Location: index.php?url=mascota/index");
    exit;
}



    /* ================== DELETE ================== */
   public function delete() {
    if (!isset($_SESSION['user'])) {
        die("Acceso denegado");
    }

    $rol = $_SESSION['user']['rol'];
    $mascotaId = (int)($_GET['id'] ?? 0);

    if ($mascotaId <= 0) {
        die("ID inválido");
    }

    // Buscar mascota (con paciente_id)
    $mascota = Mascota::find($mascotaId, $rol);
    if (!$mascota) {
        die("Mascota no encontrada");
    }
    
    

    // 🔐 VALIDACIÓN CLAVE PARA PACIENTE
    if ($rol === 'paciente') {
        $paciente = Paciente::findByUser($_SESSION['user']['id'], 'paciente');
        if (!$paciente) {
            die("Paciente no encontrado");
        }

        if ((int)$mascota['paciente_id'] !== (int)$paciente['id']) {
            die("No puedes eliminar mascotas que no son tuyas");
        }
    }

    Mascota::delete($mascotaId);

    $_SESSION['success'] = "Mascota eliminada correctamente";
    header("Location: index.php?url=mascota/index");
}

}