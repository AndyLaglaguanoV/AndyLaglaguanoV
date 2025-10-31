<?php
require_once __DIR__ . '/../core/Controller.php';
require_once __DIR__ . '/../models/Servicio.php';

class ServicioController extends Controller {

    public function listar() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireLogin();

        $servicioModel = new Servicio();
        $servicios = $servicioModel->getServicios();

        $this->render('servicios/listar', [
            'servicios' => $servicios
        ]);
    }
}
?>
