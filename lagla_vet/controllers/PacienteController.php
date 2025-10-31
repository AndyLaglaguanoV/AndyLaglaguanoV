<?php
require_once __DIR__ . '/../core/Controller.php';
require_once __DIR__ . '/../models/Paciente.php';

class PacienteController extends Controller {

    public function listar() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireLogin();

        $pacModel = new Paciente();
        $pacientes = $pacModel->getPacientes();

        $this->render('pacientes/listar', [
            'pacientes' => $pacientes
        ]);
    }

    public function ficha() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireLogin();

        $id_mascota = $_GET['id'] ?? 0;
        $pacModel = new Paciente();
        $ficha = $pacModel->getFichaMascota($id_mascota);

        $this->render('pacientes/ficha', [
            'ficha' => $ficha
        ]);
    }
}
?>
