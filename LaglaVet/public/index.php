<?php
session_start();

/*
|--------------------------------------------------------------------------
| FRONT CONTROLLER - LAGLAVET
|--------------------------------------------------------------------------
| URL esperada:
|   index.php?url=controlador/accion
|
| Ejemplos:
|   ?url=auth/login
|   ?url=auth/doLogin
|   ?url=doctor/dashboard
|   ?url=doctor/citas
|   ?url=paciente/dashboard
|   ?url=cita/create
|--------------------------------------------------------------------------
*/

// URL por defecto
$url = $_GET['url'] ?? 'auth/login';

// Limpiar la URL
$url = trim($url, '/');
$segments = explode('/', $url);

// Resolver controlador y acción
$controllerName = ucfirst($segments[0]) . 'Controller';
$action = $segments[1] ?? 'index';

// Ruta del controlador
$controllerFile = __DIR__ . '/../app/controllers/' . $controllerName . '.php';

// Verificar controlador
if (!file_exists($controllerFile)) {
    http_response_code(404);
    die("Controlador no encontrado: $controllerName");
}

// Cargar controlador
require_once $controllerFile;

// Verificar clase
if (!class_exists($controllerName)) {
    http_response_code(500);
    die("La clase $controllerName no existe");
}

// Instanciar controlador
$controller = new $controllerName();

// Verificar acción
if (!method_exists($controller, $action)) {
    http_response_code(404);
    die("Acción no encontrada: $action");
}

// Ejecutar acción
call_user_func([$controller, $action]);
