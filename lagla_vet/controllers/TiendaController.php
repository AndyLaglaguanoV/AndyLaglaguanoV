<?php
require_once __DIR__ . '/../core/Controller.php';
require_once __DIR__ . '/../models/Producto.php';

class TiendaController extends Controller {

    public function catalogo() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireLogin();

        $prodModel = new Producto();
        $productos = $prodModel->getProductos();

        $this->render('tienda/catalogo', [
            'productos' => $productos
        ]);
    }

    public function carrito() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireLogin();

        // Carrito en sesión más adelante
        $this->render('tienda/carrito', [
            'items' => [
                // vacío por ahora
            ]
        ]);
    }

    public function agregarCarrito() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        $this->requireLogin();

        // Aquí en versión real:
        // $_SESSION['carrito'][] = $_GET['id'];
        header("Location: index.php?controller=tienda&action=carrito");
        exit;
    }
}
?>
