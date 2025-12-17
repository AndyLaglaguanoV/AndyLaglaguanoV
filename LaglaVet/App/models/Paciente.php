<?php
require_once __DIR__ . '/../config/database.php';

class Paciente {

    /* ========= LISTAR ========= */
    public static function all(string $rol) {
        $db = Database::connectByRoleName($rol);

        $sql = "
            SELECT p.*, u.nombre, u.email
            FROM pacientes p
            JOIN usuarios u ON u.id = p.usuario_id
            ORDER BY p.id DESC
        ";

        return $db->query($sql)->fetch_all(MYSQLI_ASSOC);
    }
public static function findByUser(int $usuarioId, string $rol) {
    $db = Database::connectByRoleName($rol);

    $stmt = $db->prepare("SELECT * FROM pacientes WHERE usuario_id = ? LIMIT 1");
    if (!$stmt) {
        throw new Exception("Error prepare Paciente::findByUser: " . $db->error);
    }

    $stmt->bind_param("i", $usuarioId);
    $stmt->execute();
    return $stmt->get_result()->fetch_assoc();
}


    /* ========= BUSCAR POR ID ========= */
    public static function find(int $id, string $rol) {
        $db = Database::connectByRoleName($rol);

        $stmt = $db->prepare("
            SELECT p.*, u.nombre, u.email
            FROM pacientes p
            JOIN usuarios u ON u.id = p.usuario_id
            WHERE p.id = ?
        ");

        $stmt->bind_param("i", $id);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }

    /* ========= CREAR ========= */
   public static function create(array $data, string $rol) {
    $db = Database::connectByRoleName($rol);

    $sql = "INSERT INTO pacientes (usuario_id, cedula, telefono, direccion)
            VALUES (?, ?, ?, ?)";

    $stmt = $db->prepare($sql);

    if (!$stmt) {
        throw new Exception("Error prepare Paciente::create: " . $db->error);
    }

    $stmt->bind_param(
        "isss",
        $data['usuario_id'],
        $data['cedula'],
        $data['telefono'],
        $data['direccion']
    );

    if (!$stmt->execute()) {
        throw new Exception("Error execute Paciente::create: " . $stmt->error);
    }

    return $db->insert_id;
}


    /* ========= ACTUALIZAR ========= */
   public static function update(int $id, array $data, string $rol) {
    $db = Database::connectByRoleName($rol);

    $sql = "UPDATE pacientes
            SET cedula = ?, telefono = ?, direccion = ?
            WHERE id = ?";

    $stmt = $db->prepare($sql);

    if (!$stmt) {
        throw new Exception("Error prepare Paciente::update: " . $db->error);
    }

    $stmt->bind_param(
        "sssi",
        $data['cedula'],
        $data['telefono'],
        $data['direccion'],
        $id
    );

    if (!$stmt->execute()) {
        throw new Exception("Error execute Paciente::update: " . $stmt->error);
    }

    return true;
}

public static function deleteCompleto(int $pacienteId) {
    $db = Database::connectByRoleName('administrador');

    // 1. Eliminar citas del paciente (por mascotas)
    $db->query("
        DELETE c FROM citas c
        JOIN mascotas m ON m.id = c.mascota_id
        WHERE m.paciente_id = $pacienteId
    ");

    // 2. Eliminar mascotas
    $db->query("DELETE FROM mascotas WHERE paciente_id = $pacienteId");

    // 3. Obtener usuario_id
    $res = $db->query("SELECT usuario_id FROM pacientes WHERE id = $pacienteId");
    $usuario = $res->fetch_assoc();

    // 4. Eliminar paciente
    $db->query("DELETE FROM pacientes WHERE id = $pacienteId");

    // 5. Eliminar usuario
    if ($usuario) {
        $db->query("DELETE FROM usuarios WHERE id = " . (int)$usuario['usuario_id']);
    }
}


    /* ========= ELIMINAR ========= */
    public static function delete(int $id, string $rol) {
        $db = Database::connectByRoleName($rol);

        $stmt = $db->prepare("DELETE FROM pacientes WHERE id = ?");
        $stmt->bind_param("i", $id);
        $stmt->execute();
    }
    

    /* ========= BUSCAR POR NOMBRE ========= */
    public static function searchByName(string $term) {
        $db = Database::connectByRoleName($_SESSION['user']['rol']);

        $stmt = $db->prepare("
            SELECT p.id, u.nombre
            FROM pacientes p
            JOIN usuarios u ON u.id = p.usuario_id
            WHERE u.nombre LIKE CONCAT('%', ?, '%')
            ORDER BY u.nombre
            LIMIT 10
        ");

        $stmt->bind_param("s", $term);
        $stmt->execute();

        return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
    }
    
}
