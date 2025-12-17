<?php
require_once __DIR__ . '/../config/database.php';

class Cita {

    /* ========= CREAR CITA ========= */
public static function crear(array $data) {
    $db = Database::connectByRoleName('paciente');

    $stmt = $db->prepare("
        INSERT INTO citas (doctor_id, mascota_id, `fecha`, motivo, estado)
        VALUES (?, ?, ?, ?, 'pendiente')
    ");

    if (!$stmt) {
        throw new Exception("Error prepare Cita::crear");
    }

    $stmt->bind_param(
        "iiss",
        $data['doctor_id'],
        $data['mascota_id'],
        $data['fecha'],
        $data['motivo']
    );


    // Ejecutamos la consulta
    $stmt->execute();

    if ($stmt->error) {
        throw new Exception("Error al ejecutar la consulta: " . $stmt->error);
    }

}

    /* ========= CITAS POR DOCTOR ========= */
     public static function citasPorDoctor(int $doctorId) {
        $db = Database::connectByRoleName('doctor');

        $stmt = $db->prepare("
            SELECT c.id, c.fecha, c.motivo, c.estado,
                   m.nombre AS mascota
            FROM citas c
            JOIN mascotas m ON m.id = c.mascota_id
            WHERE c.doctor_id = ? AND c.estado = 'pendiente'
            ORDER BY c.fecha
        ");

        if (!$stmt) {
            throw new Exception("Error prepare Cita::citasPorDoctor");
        }

        $stmt->bind_param("i", $doctorId);
        $stmt->execute();

        return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
    }

    /* ========= CITAS POR PACIENTE ========= */
public static function citasPorPaciente(int $pacienteId) {
    $db = Database::connectByRoleName('paciente');

    $stmt = $db->prepare("
        SELECT 
            c.id,
            c.fecha,
            c.motivo,
            c.estado,
            m.nombre AS mascota,
            u.nombre AS doctor
        FROM citas c
        JOIN mascotas m ON m.id = c.mascota_id
        JOIN doctores d ON d.id = c.doctor_id
        JOIN usuarios u ON u.id = d.usuario_id
        WHERE m.paciente_id = ?
        ORDER BY c.fecha DESC
    ");

    if (!$stmt) {
        throw new Exception("Error prepare Cita::citasPorPaciente");
    }

    $stmt->bind_param("i", $pacienteId);
    $stmt->execute();

    return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
}


    /* ========= ACEPTAR CITA ========= */
    public static function aceptar(int $id) {
        $db = Database::connectByRoleName('doctor');

        $stmt = $db->prepare("
            UPDATE citas
            SET estado = 'atendida'
            WHERE id = ?
        ");

        $stmt->bind_param("i", $id);
        $stmt->execute();
    }
}
