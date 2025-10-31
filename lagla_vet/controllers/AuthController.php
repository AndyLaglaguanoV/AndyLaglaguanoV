<?php
require_once __DIR__ . '/../core/Controller.php';
require_once __DIR__ . '/../models/Usuario.php';

class AuthController extends Controller {

    public function login() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        if (isset($_SESSION['rol'])) {
            header("Location: index.php?controller=dashboard&action=home");
            exit;
        }
        $this->render('auth/login');
    }

    public function doLogin() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }

        $username = $_POST['username'] ?? '';
        $password = $_POST['password'] ?? '';

        $userModel = new Usuario();
        $user = $userModel->autenticar($username, $password);

        if ($user) {
            $_SESSION['id_usuario'] = $user['id_usuario'];
            $_SESSION['username']   = $user['username'];
            $_SESSION['nombre']     = $user['nombre_completo'];
            $_SESSION['rol']        = $user['rol'];

            header("Location: index.php?controller=dashboard&action=home");
            exit;
        } else {
            $this->render('auth/login', [
                'error' => 'Usuario o contraseña incorrectos.'
            ]);
        }
    }

    public function logout() {
        if (session_status() === PHP_SESSION_NONE) {
            session_start();
        }
        session_unset();
        session_destroy();
        header("Location: index.php?controller=auth&action=login");
        exit;
    }

    public function denied() {
        $this->render('auth/login', [
            'error' => 'Acceso denegado. Inicia sesión con un rol válido.'
        ]);
    }
}
?>
