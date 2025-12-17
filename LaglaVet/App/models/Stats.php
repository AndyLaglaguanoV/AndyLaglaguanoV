<?php
require_once __DIR__ . '/../config/database.php';

class Stats {

    public static function counts() {
        $db = Database::connectByRoleName('administrador');

        $data = [];
       $data['usuarios']  = $db->query("SELECT COUNT(*) c FROM usuarios")->fetch_assoc()['c'];
$data['pacientes'] = $db->query("SELECT COUNT(*) c FROM pacientes")->fetch_assoc()['c'];
$data['doctores']  = $db->query("SELECT COUNT(*) c FROM doctores")->fetch_assoc()['c']; // ✅ ESTA LÍNEA
$data['mascotas']  = $db->query("SELECT COUNT(*) c FROM mascotas")->fetch_assoc()['c'];
$data['auditoria'] = $db->query("SELECT COUNT(*) c FROM auditoria")->fetch_assoc()['c'];

        return $data;
    }

    public static function lastLogs($limit = 5) {
        $db = Database::connectByRoleName('administrador');

        $stmt = $db->prepare("
            SELECT a.fecha, u.nombre, a.accion, a.tabla_afectada
            FROM auditoria a
            LEFT JOIN usuarios u ON u.id = a.usuario_id
            ORDER BY a.fecha DESC
            LIMIT ?
        ");
        $stmt->bind_param("i", $limit);
        $stmt->execute();
        return $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
    }
}
