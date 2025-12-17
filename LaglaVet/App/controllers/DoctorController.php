<?php
require_once __DIR__ . '/../models/Doctor.php';
require_once __DIR__ . '/../models/Usuario.php';
require_once __DIR__ . '/../models/Auditoria.php';
require_once __DIR__ . '/../models/Cita.php';

class DoctorController {

    /* ================== AUTH ================== */

    private function authAdmin() {
        if (!isset($_SESSION['user']) || $_SESSION['user']['rol'] !== 'administrador') {
            die("Acceso denegado");
        }
    }

    private function authDoctor() {
        if (!isset($_SESSION['user']) || $_SESSION['user']['rol'] !== 'doctor') {
            die("Acceso denegado");
        }
    }

    private function authAdminOrDoctor() {
        if (
            !isset($_SESSION['user']) ||
            !in_array($_SESSION['user']['rol'], ['administrador', 'doctor'])
        ) {
            die("Acceso denegado");
        }
    }

    /* ================== DASHBOARD DOCTOR ================== */

    public function dashboard() {
        $this->authDoctor();
        require_once __DIR__ . '/../views/doctor/dashboard.php';
    }

    /* ================== LISTAR DOCTORES (ADMIN) ================== */

    public function index() {
        $this->authAdmin();
        $doctores = Doctor::all('administrador');
        require_once __DIR__ . '/../views/doctores/index.php';
    }

    /* ================== CREAR DOCTOR (ADMIN) ================== */

    public function create() {
        $this->authAdmin();
        require_once __DIR__ . '/../views/doctores/create.php';
    }

    public function store() {
        $this->authAdmin();

        try {
            $usuarioId = Usuario::createDoctor([
                'nombre'   => $_POST['nombre'],
                'email'    => $_POST['email'],
                'password' => $_POST['password']
            ]);

            $doctorId = Doctor::create([
                'usuario_id'   => $usuarioId,
                'especialidad' => $_POST['especialidad'],
                'licencia'     => $_POST['licencia']
            ], 'administrador');

            Auditoria::registrar(
                $_SESSION['user']['id'],
                'INSERT',
                'doctores',
                $doctorId,
                'Administrador creó doctor'
            );

            header("Location: index.php?url=doctor/index");

        } catch (Exception $e) {
            $_SESSION['error'] = $e->getMessage();
            header("Location: index.php?url=doctor/create");
        }
    }

    /* ================== EDITAR PERFIL ================== */

    public function edit() {
        $this->authAdminOrDoctor();

        // 👨‍⚕️ DOCTOR: edita SU perfil
        if ($_SESSION['user']['rol'] === 'doctor') {

            $doctor = Doctor::findByUser($_SESSION['user']['id']);

            if (!$doctor) {
                die("Perfil de doctor no encontrado");
            }

        } 
        // 👨‍💼 ADMIN: edita cualquier doctor
        else {

            if (!isset($_GET['id'])) {
                die("ID de doctor no recibido");
            }

            $doctor = Doctor::find($_GET['id'], 'administrador');

            if (!$doctor) {
                die("Doctor no encontrado");
            }
        }

        require_once __DIR__ . '/../views/doctores/edit.php';
    }

    /* ================== ACTUALIZAR PERFIL ================== */

    public function update() {
        $this->authAdminOrDoctor();

        if (
            $_SESSION['user']['rol'] === 'doctor' &&
            $_POST['usuario_id'] != $_SESSION['user']['id']
        ) {
            die("Acceso denegado");
        }

        try {
            Usuario::updateUser(
                $_POST['usuario_id'],
                $_POST['nombre'],
                $_POST['email']
            );

            Doctor::update(
                $_POST['id'],
                [
                    'especialidad' => $_POST['especialidad'],
                    'licencia'     => $_POST['licencia']
                ],
                $_SESSION['user']['rol'] === 'doctor' ? 'doctor' : 'administrador'
            );

            Auditoria::registrar(
                $_SESSION['user']['id'],
                'UPDATE',
                'doctores',
                $_POST['id'],
                'Actualizó perfil doctor'
            );

            $_SESSION['success'] = "Perfil actualizado correctamente";

        } catch (Exception $e) {
            $_SESSION['error'] = $e->getMessage();
        }

        header(
            $_SESSION['user']['rol'] === 'doctor'
            ? "Location: index.php?url=doctor/dashboard"
            : "Location: index.php?url=doctor/index"
        );
    }

    /* ================== PACIENTES ================== */

    public function pacientes() {
        $this->authDoctor();

        $doctor = Doctor::findByUser($_SESSION['user']['id']);
        if (!$doctor) {
            die("Doctor no encontrado");
        }

        $pacientes = Doctor::pacientesAsignados($doctor['id']);
        require_once __DIR__ . '/../views/doctor/pacientes.php';
    }

    /* ================== CITAS ================== */

    public function citas() {
        $this->authDoctor();

        $doctor = Doctor::findByUser($_SESSION['user']['id']);
        if (!$doctor) {
            die("Doctor no encontrado");
        }

        $citas = Cita::citasPorDoctor($doctor['id']);
        require_once __DIR__ . '/../views/doctor/citas.php';
    }

    public function aceptarCita() {
        $this->authDoctor();

        if (!isset($_GET['id'])) {
            die("ID de cita no recibido");
        }

        Cita::aceptar((int)$_GET['id']);

        $_SESSION['success'] = "Cita atendida correctamente";
        header("Location: index.php?url=doctor/citas");
    }

    /* ================== ELIMINAR DOCTOR ================== */

    public function delete() {
        $this->authAdmin();

        Doctor::delete($_GET['id'], 'administrador');

        Auditoria::registrar(
            $_SESSION['user']['id'],
            'DELETE',
            'doctores',
            $_GET['id'],
            'Administrador eliminó doctor'
        );

        header("Location: index.php?url=doctor/index");
    }
}
