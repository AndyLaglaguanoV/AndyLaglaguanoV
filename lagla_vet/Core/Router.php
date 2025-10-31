<?php
class Router {
    public function run() {
        $controllerName = $_GET['controller'] ?? 'auth';
        $actionName     = $_GET['action'] ?? 'login';

        $controllerClass = ucfirst($controllerName) . 'Controller';
        $controllerFile  = __DIR__ . '/../controllers/' . $controllerClass . '.php';

        if (!file_exists($controllerFile)) {
            die("Controlador no encontrado: " . htmlspecialchars($controllerClass));
        }
        require_once $controllerFile;

        if (!class_exists($controllerClass)) {
            die("Clase controlador no válida: " . htmlspecialchars($controllerClass));
        }

        $controllerObj = new $controllerClass();

        if (!method_exists($controllerObj, $actionName)) {
            die("Acción no encontrada: " . htmlspecialchars($actionName));
        }

        $controllerObj->$actionName();
    }
}
?>
