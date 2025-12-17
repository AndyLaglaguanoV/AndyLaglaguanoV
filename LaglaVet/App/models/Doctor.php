<?php
require_once __DIR__ . '/../config/database.php';

class Doctor {

    /* ========= LISTAR DOCTORES (ADMIN) ========= */
    public static function all(string $rol) {
        $db = Database::connectByRoleName($rol);

        $sql = "
            SELECT d.id, u.nombre, u.email, d.especialidad, d.licencia
            FROM doctores d
            INNER JOIN usuarios u ON u.id = d.usuario_id
        ";

        return $db->query($sql)->fetch_all(MYSQLI_ASSOC);
    }

    /* ========= BUSCAR DOCTOR POR USUARIO (DOCTOR LOGUEADO) ========= */
 public static function findByUser(int $usuarioId) {
    $db = Database::connectByRoleName('administrador'); // 👈 importante

    $stmt = $db->prepare("
        SELECT d.id, d.usuario_id, d.especialidad, d.licencia,
               u.nombre, u.email
        FROM doctores d
        INNER JOIN usuarios u ON u.id = d.usuario_id
        WHERE u.id = ?
        LIMIT 1
    ");

    if (!$stmt) {
        throw new Exception("Error prepare Doctor::findByUser");
    }

    $stmt->bind_param("i", $usuarioId);
    $stmt->execute();

    return $stmt->get_result()->fetch_assoc();
}

    /* ========= BUSCAR DOCTOR POR ID (ADMIN) ========= */
    public static function find(int $id, string $rol) {
        $db = Database::connectByRoleName($rol);

        $stmt = $db->prepare("
            SELECT d.id, d.usuario_id, d.especialidad, d.licencia,
                   u.nombre, u.email
            FROM doctores d
            INNER JOIN usuarios u ON u.id = d.usuario_id
            WHERE d.id = ?
        ");

        $stmt->bind_param("i", $id);
        $stmt->execute();

        return $stmt->get_result()->fetch_assoc();
    }

    /* ========= CREAR DOCTOR ========= */
    public static function create(array $data, string $rol) {
        $db = Database::connectByRoleName($rol);

        $stmt = $db->prepare("
            INSERT INTO doctores (usuario_id, especialidad, licencia)
            VALUES (?, ?, ?)
        ");

        $stmt->bind_param(
            "iss",
            $data['usuario_id'],
            $data['especialidad'],
            $data['licencia']
        );

        $stmt->execute();
        return $db->insert_id;
    }

    /* ========= ACTUALIZAR DOCTOR ========= */
    public static function update(int $id, array $data, string $rol) {
        $db = Database::connectByRoleName($rol);

        $stmt = $db->prepare("
            UPDATE doctores
            SET especialidad = ?, licencia = ?
            WHERE id = ?
        ");

        $stmt->bind_param(
            "ssi",
            $data['especialidad'],
            $data['licencia'],
            $id
        );

        if (!$stmt->execute()) {
            throw new Exception("Error al actualizar doctor");
        }
    }

    /* ========= ELIMINAR DOCTOR ========= */
    public static function delete(int $id, string $rol) {
        $db = Database::connectByRoleName($rol);

        $stmt = $db->prepare("DELETE FROM doctores WHERE id = ?");
        $stmt->bind_param("i", $id);
        $stmt->execute();
    }

/* ========= PACIENTES ASIGNADOS ========= */
public static function pacientesAsignados(int $doctorId) {
    $db = Database::connectByRoleName('doctor');

    $sql = "
        SELECT DISTINCT
            p.id,
            u.nombre,
            u.email
        FROM doctor_paciente dp
        INNER JOIN pacientes p ON p.id = dp.paciente_id
        INNER JOIN usuarios u ON u.id = p.usuario_id
        WHERE dp.doctor_id = ?
    ";

    $stmt = $db->prepare($sql);

    if (!$stmt) {
        throw new Exception("Error SQL pacientesAsignados");
    }

    $stmt->bind_param("i", $doctorId);
    $stmt->execute();

    return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
}
}