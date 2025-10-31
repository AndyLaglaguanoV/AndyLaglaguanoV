<?php
require_once __DIR__ . '/../core/Controller.php';
require_once __DIR__ . '/../models/Doctor.php';

class DoctorController extends Controller {

    public function listar() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireLogin();

        $docModel = new Doctor();
        $doctores = $docModel->getDoctores();

        $this->render('doctores/listar', [
            'doctores' => $doctores
        ]);
    }

    public function disponibilidad() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireLogin();

        $docModel   = new Doctor();
        $doctores   = $docModel->getDoctores();
        $disponibles= $docModel->getDoctoresDisponibles();

        $this->render('doctores/disponibilidad', [
            'doctores'    => $doctores,
            'disponibles' => $disponibles
        ]);
    }
}
?>
