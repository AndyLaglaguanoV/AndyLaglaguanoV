<?php
require_once __DIR__ . '/../models/Usuario.php';
require_once __DIR__ . '/../models/Auditoria.php';

class AuthController {

    public function login() {
        require_once __DIR__ . '/../views/auth/login.php';
    }

    public function doLogin() {
        $email = $_POST['email'] ?? '';
        $password = $_POST['password'] ?? '';

        if ($email === '' || $password === '') {
            die("Datos incompletos");
        }

        // 🔐 Buscar usuario (usa connectAuth)
        $user = Usuario::findByEmail($email);

        // Verificar si las credenciales son correctas
        if (!$user || !password_verify($password, $user['password_hash'])) { // Usar password_hash
            Auditoria::registrar(
                null,
                'LOGIN_FAIL',
                'usuarios',
                null,
                'Intento de login fallido'
            );
            die("Credenciales incorrectas");
        }

        // ✅ SESIÓN CORRECTA
        $_SESSION['user'] = [
            'id'     => $user['id'],
            'nombre' => $user['nombre'],
            'rol'    => $user['rol']   // Aquí está la clave
        ];

        Auditoria::registrar(
            $user['id'],
            'LOGIN_OK',
            'usuarios',
            $user['id'],
            'Inicio de sesión'
        );

        // 🔁 REDIRECCIÓN SEGÚN ROL
        switch ($user['rol']) {
            case 'administrador':
                header("Location: index.php?url=admin/dashboard");
                break;

            case 'doctor':
                header("Location: index.php?url=doctor/dashboard");
                break;

            case 'paciente':
                header("Location: index.php?url=paciente/dashboard");
                break;

            default:
                die("Rol no reconocido");
        }
    }

    public function logout() {
        if (isset($_SESSION['user'])) {
            Auditoria::registrar(
                $_SESSION['user']['id'],
                'LOGOUT',
                'usuarios',
                null,
                'Cierre de sesión'
            );
        }

        session_destroy();
        header("Location: index.php");
    }
}
