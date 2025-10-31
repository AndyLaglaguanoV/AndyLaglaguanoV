<?php
class Controller {

    protected function render($viewPath, $data = []) {
        // Convierte ['nombre'=>'Andy'] en $nombre = 'Andy'
        extract($data);

        include __DIR__ . '/../views/layouts/header.php';
        include __DIR__ . '/../views/' . $viewPath . '.php';
        include __DIR__ . '/../views/layouts/footer.php';
    }

    protected function requireLogin() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        if (!isset($_SESSION['rol'])) {
            header("Location: index.php?controller=auth&action=login");
            exit;
        }
    }

    protected function requireRole($rolesPermitidos = []) {
        $this->requireLogin();
        if (!in_array($_SESSION['rol'], $rolesPermitidos)) {
            header("Location: index.php?controller=auth&action=denied");
            exit;
        }
    }
}
?>
