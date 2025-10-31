<?php
require_once __DIR__ . '/../core/Controller.php';
require_once __DIR__ . '/../models/Usuario.php';
require_once __DIR__ . '/../models/Doctor.php';
require_once __DIR__ . '/../models/Servicio.php';
require_once __DIR__ . '/../models/Producto.php';
require_once __DIR__ . '/../models/Cita.php';

class DashboardController extends Controller {

    public function home() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireLogin();

        $doctorModel   = new Doctor();
        $servicioModel = new Servicio();
        $productoModel = new Producto();
        $citaModel     = new Cita();

        $citasHoy = $citaModel->getCitas(); // mock: usamos todo el arreglo
        $stats = [
            "citas_hoy"             => count($citasHoy),
            "doctores_disponibles"  => $doctorModel->contarDisponibles(),
            "servicios_totales"     => $servicioModel->contarServicios(),
            "productos_bajos"       => $productoModel->contarProductosBajoStock(),
        ];

        $this->render('dashboard/home', [
            'stats' => $stats
        ]);
    }
}
?>
