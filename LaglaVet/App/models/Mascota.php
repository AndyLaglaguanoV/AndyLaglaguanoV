<?php
require_once __DIR__ . '/../config/database.php';

class Mascota {

    /* ========= LISTAR =========
       - Admin / Doctor: todas las mascotas
       - Paciente: solo sus mascotas
    */
public static function all(string $rol, int $userId = null) {
    $db = Database::connectByRoleName($rol);

    if ($rol === 'paciente') {
        $stmt = $db->prepare("
            SELECT 
                m.id,
                m.paciente_id,
                m.nombre,
                m.especie,
                m.raza,
                m.edad
            FROM mascotas m
            JOIN pacientes p ON p.id = m.paciente_id
            WHERE p.usuario_id = ?
        ");

        $stmt->bind_param("i", $userId);
        $stmt->execute();
        return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
    }

    // admin / doctor
    $result = $db->query("
        SELECT id, paciente_id, nombre, especie, raza, edad
        FROM mascotas
    ");

    return $result->fetch_all(MYSQLI_ASSOC);





        // 👑 ADMIN / 🧑‍⚕️ DOCTOR → todas
        $sql = "
            SELECT 
                m.id,
                m.nombre AS mascota,
                m.especie,
                m.raza,
                m.edad
            FROM mascotas m
            ORDER BY m.id DESC
        ";

        return $db->query($sql)->fetch_all(MYSQLI_ASSOC);
    }

    /* ========= CREAR ========= */
    public static function create(array $data, string $rol) {
    $db = Database::connectByRoleName($rol);

    $stmt = $db->prepare("
        INSERT INTO mascotas (paciente_id, nombre, especie, raza, edad)
        VALUES (?, ?, ?, ?, ?)
    ");

    if (!$stmt) {
        throw new Exception("Error prepare Mascota::create");
    }

    $stmt->bind_param(
        "isssi",
        $data['paciente_id'],
        $data['nombre'],
        $data['especie'],
        $data['raza'],
        $data['edad']
    );

    if (!$stmt->execute()) {
        throw new Exception("Error execute Mascota::create");
    }

    return $db->insert_id;
}


    /* ========= BUSCAR POR ID ========= */
   public static function find(int $id, string $rol) {
    $db = Database::connectByRoleName($rol);

    $stmt = $db->prepare("
        SELECT 
            id,
            paciente_id,
            nombre,
            especie,
            raza,
            edad
        FROM mascotas
        WHERE id = ?
        LIMIT 1
    ");

    if (!$stmt) {
        throw new Exception("Error prepare Mascota::find");
    }

    $stmt->bind_param("i", $id);
    $stmt->execute();

    return $stmt->get_result()->fetch_assoc();
}

   public static function porPaciente(int $usuarioId) {
    $db = Database::connectByRoleName('paciente');

    $stmt = $db->prepare("
        SELECT m.id, m.nombre, m.especie
        FROM mascotas m
        WHERE m.paciente_id = ?
    ");

    if (!$stmt) {
        throw new Exception("Error prepare Mascota::porPaciente");
    }

    $stmt->bind_param("i", $usuarioId);
    $stmt->execute();

    return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
}



    /* ========= ACTUALIZAR ========= */
    public static function update(int $id, array $data, string $rol) {
        $db = Database::connectByRoleName($rol);

        $stmt = $db->prepare("
            UPDATE mascotas
            SET nombre = ?, especie = ?, raza = ?, edad = ?
            WHERE id = ?
        ");

        if (!$stmt) {
            throw new Exception("Prepare error: " . $db->error);
        }

        $stmt->bind_param(
            "sssii",
            $data['nombre'],
            $data['especie'],
            $data['raza'],
            $data['edad'],
            $id
        );

        $stmt->execute();
    }

    /* ========= ELIMINAR ========= */
public static function delete(int $id) {
    // SIEMPRE usar admin para borrar
    $db = Database::connectByRoleName('administrador');

    $stmt = $db->prepare("
        DELETE FROM mascotas 
        WHERE id = ?
    ");

    if (!$stmt) {
        throw new Exception("Error prepare Mascota::delete");
    }

    $stmt->bind_param("i", $id);
    $stmt->execute();
}
}