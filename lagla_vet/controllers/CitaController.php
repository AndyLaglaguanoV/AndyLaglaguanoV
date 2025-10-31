<?php
require_once __DIR__ . '/../core/Controller.php';
require_once __DIR__ . '/../models/Cita.php';
require_once __DIR__ . '/../models/Doctor.php';

class CitaController extends Controller {

    public function listar() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireLogin();

        $citaModel = new Cita();
        $citas = $citaModel->getCitas();

        $this->render('citas/listar', [
            'citas' => $citas
        ]);
    }

    public function nueva() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireRole(['RECEP','ADMIN']);

        $citaModel   = new Cita();
        $doctorModel = new Doctor();

        $mascotas = $citaModel->getMascotasParaCita();
        $doctores = $doctorModel->getDoctoresDisponibles();

        $this->render('citas/nueva', [
            'mascotas'              => $mascotas,
            'doctores_disponibles'  => $doctores
        ]);
    }

    public function guardarNueva() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireRole(['RECEP','ADMIN']);

        // En versión mock solo mostramos mensaje.
        // En versión SQL Server: INSERT INTO Cita (...)
        $this->render('citas/listar', [
            'citas' => (new Cita())->getCitas(),
            'msg'   => 'Cita guardada (demo). Aquí irá el INSERT real en SQL Server.'
        ]);
    }
}
?>
