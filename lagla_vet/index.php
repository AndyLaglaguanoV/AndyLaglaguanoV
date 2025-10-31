<?php
// index.php
// Punto de entrada del sistema Lagla Vet (Front Controller)

require_once __DIR__ . '/core/Router.php';

$router = new Router();
$router->run();
?>
