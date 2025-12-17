<?php
require_once __DIR__ . '/../config/database.php';

class Auditoria {

  public static function registrar(?int $usuarioId, string $accion, ?string $tabla, ?int $registroId, ?string $descripcion): void {
    // Importante: la auditoría debe poder insertarse. Normalmente la hace admin.
    // Para simplificar, usamos conexión admin aquí.
    $db = Database::connectByRoleName("administrador");

    $ip = $_SERVER['REMOTE_ADDR'] ?? null;

    $stmt = $db->prepare("INSERT INTO auditoria (usuario_id, accion, tabla_afectada, registro_id, descripcion, ip) VALUES (?,?,?,?,?,?)");
    $stmt->bind_param("ississ", $usuarioId, $accion, $tabla, $registroId, $descripcion, $ip);
    $stmt->execute();
    $stmt->close();
    $db->close();
  }
public static function all() {
    $db = Database::connectByRoleName('administrador');

    $sql = "
        SELECT 
            a.id,
            a.fecha,
            u.nombre AS usuario,
            a.accion,
            a.tabla_afectada,
            a.registro_id,
            a.descripcion,
            a.ip
        FROM auditoria a
        LEFT JOIN usuarios u ON u.id = a.usuario_id
        ORDER BY a.fecha DESC
    ";

    return $db->query($sql)->fetch_all(MYSQLI_ASSOC);
}
}
