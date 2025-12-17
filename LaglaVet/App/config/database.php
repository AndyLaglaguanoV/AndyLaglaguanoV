<?php
class Database {

  public static function connectByRoleName(string $roleName): mysqli {
    $host = "localhost";
    $db   = "laglavet";

    // Usuarios del MOTOR MySQL (lo que pide el inge)
    $map = [
      "administrador" => ["laglavet_admin", "Admin123!"],
      "doctor"        => ["laglavet_doctor", "Doctor123!"],
      "paciente"      => ["laglavet_paciente", "Paciente123!"],
    ];

    if (!isset($map[$roleName])) {
      throw new Exception("Rol inválido para conexión BD: " . $roleName);
    }

    [$user, $pass] = $map[$roleName];

    $mysqli = new mysqli($host, $user, $pass, $db);
    if ($mysqli->connect_error) {
      throw new Exception("Error DB: " . $mysqli->connect_error);
    }

    $mysqli->set_charset("utf8mb4");
    return $mysqli;
  }

  // Conexión “neutral” solo para LOGIN (leer usuarios por email)
  // OJO: para esto, lo más correcto sería un usuario MySQL con solo SELECT en usuarios/roles.
  public static function connectAuth(): mysqli {
    $host = "localhost";
    $db   = "laglavet";
    // Usamos admin por simplicidad (si el inge es estricto, luego lo cambiamos por laglavet_auth)
    $mysqli = new mysqli($host, "laglavet_admin", "Admin123!", $db);
    if ($mysqli->connect_error) {
      throw new Exception("Error DB: " . $mysqli->connect_error);
    }
    $mysqli->set_charset("utf8mb4");
    return $mysqli;
  }
}
