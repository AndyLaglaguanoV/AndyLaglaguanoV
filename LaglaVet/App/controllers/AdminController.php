<?php
require_once __DIR__ . '/../models/Stats.php';
require_once __DIR__ . '/../models/Auditoria.php';

class AdminController {

    private function auth() {
        if (!isset($_SESSION['user']) || $_SESSION['user']['rol'] !== 'administrador') {
            die("Acceso denegado");
        }
    }

    public function dashboard() {
        $this->auth();

        $stats = Stats::counts();
        $logs  = Stats::lastLogs(5);

        require_once __DIR__ . '/../views/admin/dashboard.php';
    }

    public function auditoria() {
        $this->auth();
        $logs = Auditoria::all();
        require_once __DIR__ . '/../views/admin/auditoria.php';
    }
}
