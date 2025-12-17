<?php
require_once __DIR__ . '/../config/database.php';

class Usuario {

    /* =====================================
       🔐 LOGIN - BUSCAR USUARIO POR EMAIL
       Usa connectAuth()
       ===================================== */
    public static function findByEmail(string $email): ?array {
        $db = Database::connectAuth();

        $stmt = $db->prepare("
            SELECT u.*, r.nombre AS rol
            FROM usuarios u
            INNER JOIN roles r ON r.id = u.rol_id
            WHERE u.email = ?
        ");

        if (!$stmt) {
            throw new Exception("Prepare error: " . $db->error);
        }

        $stmt->bind_param("s", $email);
        $stmt->execute();

        return $stmt->get_result()->fetch_assoc() ?: null;
    }
/* ========= CREAR USUARIO DOCTOR ========= */
public static function createDoctor(array $data) {
    $db = Database::connectAuth();

    // Verificar si el email ya existe
    $check = $db->prepare("SELECT id FROM usuarios WHERE email = ?");
    $check->bind_param("s", $data['email']);
    $check->execute();
    if ($check->get_result()->num_rows > 0) {
        throw new Exception("El correo ya está registrado");
    }

    $passwordHash = password_hash($data['password'], PASSWORD_DEFAULT);

    // Rol doctor = id 2 (ajusta si tu ID es distinto)
    $rolId = 2;

    $stmt = $db->prepare("
        INSERT INTO usuarios (nombre, email, password, rol_id, activo)
        VALUES (?, ?, ?, ?, 1)
    ");

    if (!$stmt) {
        throw new Exception("Prepare error: " . $db->error);
    }

    $stmt->bind_param(
        "sssi",
        $data['nombre'],
        $data['email'],
        $passwordHash,
        $rolId
    );

    if (!$stmt->execute()) {
        throw new Exception("Execute error: " . $stmt->error);
    }

    return $db->insert_id;
}

    /* =====================================
       👤 CREAR USUARIO CON ROL PACIENTE
       Usa connectByRoleName('administrador')
       ===================================== */
   public static function createPaciente(array $data): int {
    $db = Database::connectByRoleName('administrador');

    // 🔍 Verificar si el email ya existe
    $check = $db->prepare("SELECT id FROM usuarios WHERE email = ?");
    $check->bind_param("s", $data['email']);
    $check->execute();
    $result = $check->get_result();

    if ($result->num_rows > 0) {
        throw new Exception("El correo ya está registrado");
    }

    // Obtener ID del rol paciente
    $rol = $db->query("SELECT id FROM roles WHERE nombre='paciente'")->fetch_assoc();
    if (!$rol) {
        throw new Exception("Rol paciente no existe");
    }

    $passwordHash = password_hash($data['password'], PASSWORD_DEFAULT);

    $stmt = $db->prepare("
        INSERT INTO usuarios (nombre, email, password, rol_id)
        VALUES (?, ?, ?, ?)
    ");

    if (!$stmt) {
        throw new Exception("Prepare error: " . $db->error);
    }

    $stmt->bind_param(
        "sssi",
        $data['nombre'],
        $data['email'],
        $passwordHash,
        $rol['id']
    );

    if (!$stmt->execute()) {
        throw new Exception("Execute error: " . $stmt->error);
    }

    return $db->insert_id;
}
public static function updateUser(int $id, string $nombre, string $email) {
    $db = Database::connectByRoleName($_SESSION['user']['rol']);

    $stmt = $db->prepare("
        UPDATE usuarios
        SET nombre = ?, email = ?
        WHERE id = ?
    ");

    $stmt->bind_param("ssi", $nombre, $email, $id);

    if (!$stmt->execute()) {
        throw new Exception("Error al actualizar el usuario");
    }
}

}