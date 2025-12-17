<?php
require_once __DIR__ . '/../app/config/database.php';

try {
    $db = Database::connectByRoleName("administrador");
    echo "✅ Conectado a la base de datos como ADMIN<br>";

    $res = $db->query("SHOW TABLES");
    echo "Tablas encontradas:<br>";
    while ($row = $res->fetch_array()) {
        echo "- " . $row[0] . "<br>";
    }

} catch (Throwable $e) {
    echo "❌ Error de conexión: " . $e->getMessage();
}
