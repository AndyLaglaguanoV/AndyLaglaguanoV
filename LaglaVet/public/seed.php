<?php
require_once __DIR__ . '/../app/config/database.php';

$db = Database::connectByRoleName("administrador");

function createUser(mysqli $db, string $nombre, string $email, string $password, int $rolId) {
  $hash = password_hash($password, PASSWORD_DEFAULT);

  $stmt = $db->prepare("INSERT INTO usuarios (nombre, email, password_hash, rol_id) VALUES (?,?,?,?)");
  $stmt->bind_param("sssi", $nombre, $email, $hash, $rolId);
  $stmt->execute();
  $stmt->close();
}

createUser($db, "Admin LaglaVet",   "admin@laglavet.com",   "1234", 1);
createUser($db, "Dr. LaglaVet",     "doctor@laglavet.com",  "1234", 2);
createUser($db, "Paciente LaglaVet","paciente@laglavet.com","1234", 3);

echo "Usuarios creados. (admin/doctor/paciente) password=1234";
$db->close();
