<?php
require_once __DIR__ . '/../models/Cita.php';
require_once __DIR__ . '/../models/Doctor.php';
require_once __DIR__ . '/../models/Mascota.php';
require_once __DIR__ . '/../models/Paciente.php';

class CitaController {

    /* ================== AUTH ================== */

    private function authPaciente() {
        if (!isset($_SESSION['user']) || $_SESSION['user']['rol'] !== 'paciente') {
            die("Acceso denegado");
        }
    }

    private function authDoctor() {
        if (!isset($_SESSION['user']) || $_SESSION['user']['rol'] !== 'doctor') {
            die("Acceso denegado");
        }
    }

    /* ================== PACIENTE ================== */

    // Formulario nueva cita
   public function create() {
        $this->authPaciente();

        // 🔹 obtener paciente
        $paciente = Paciente::findByUser($_SESSION['user']['id'], 'paciente');
        if (!$paciente) {
            die("Debe completar su perfil de paciente primero");
        }

        // 🔹 mascotas del paciente
        $mascotas = Mascota::porPaciente($paciente['id'], 'paciente');

        // 🔹 doctores disponibles
        $doctores = Doctor::all('paciente');

        require_once __DIR__ . '/../views/cita/create.php';
    }

    /* ========= GUARDAR ========= */
   public function store() {
    $this->authPaciente();

    // Obtener el paciente
    $paciente = Paciente::findByUser($_SESSION['user']['id'], 'paciente');
    if (!$paciente) {
        die("Paciente no encontrado");
    }

    // Recibir los datos del formulario
    $data = [
        'paciente_id' => $paciente['id'],
        'doctor_id'   => $_POST['doctor_id'],
        'mascota_id'  => $_POST['mascota_id'],
        'fecha'       => $_POST['fecha'],
        'motivo'      => $_POST['motivo']
    ];

    // Llamar a Cita::crear() para guardar la cita
    try {
        Cita::crear($data);
        $_SESSION['success'] = "Cita solicitada correctamente";
        header("Location: index.php?url=paciente/dashboard");
    } catch (Exception $e) {
        $_SESSION['error'] = $e->getMessage();
        header("Location: index.php?url=cita/create");
    }
}

public function misCitas() {
    // Solo pacientes
    if (!isset($_SESSION['user']) || $_SESSION['user']['rol'] !== 'paciente') {
        die("Acceso denegado");
    }

    // Buscar el paciente real
    $paciente = Paciente::findByUser($_SESSION['user']['id'], 'paciente');

    if (!$paciente) {
        die("Paciente no encontrado");
    }

    $citas = Cita::citasPorPaciente((int)$paciente['id']);

    require_once __DIR__ . '/../views/cita/mis_citas.php';
}


    /* ================== DOCTOR ================== */

    // Ver citas del doctor
    public function doctorCitas() {
        $this->authDoctor();

        $doctor = Doctor::findByUser($_SESSION['user']['id']);

        if (!$doctor) {
            die("Doctor no encontrado");
        }

        $citas = Cita::citasPorDoctor($doctor['id']);

        require_once __DIR__ . '/../views/doctor/citas.php';
    }

    // Aceptar cita
    public function aceptar() {
        $this->authDoctor();

        if (!isset($_GET['id'])) {
            die("ID de cita no recibido");
        }

        Cita::aceptar((int)$_GET['id']);

        $_SESSION['success'] = "Cita atendida correctamente";
        header("Location: index.php?url=doctor/citas");
    }
}
