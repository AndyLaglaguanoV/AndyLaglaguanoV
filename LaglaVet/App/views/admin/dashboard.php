<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<h3 class="mb-4 fw-bold">
    <i class="bi bi-speedometer2"></i> Panel Administrador
</h3>

<!-- ================== MÉTRICAS ================== -->
<div class="row g-4 mb-4">

    <!-- USUARIOS -->
    <div class="col-md-3">
        <div class="card shadow-sm border-0 text-center">
            <div class="card-body">
                <i class="bi bi-people fs-1 text-success"></i>
                <h3 class="fw-bold"><?= $stats['usuarios'] ?></h3>
                <p class="text-muted mb-0">Usuarios</p>
            </div>
        </div>
    </div>

    <!-- PACIENTES -->
    <div class="col-md-3">
        <div class="card shadow-sm border-0 text-center">
            <div class="card-body">
                <i class="bi bi-person fs-1 text-success"></i>
                <h3 class="fw-bold"><?= $stats['pacientes'] ?></h3>
                <p class="text-muted mb-0">Pacientes</p>
            </div>
        </div>
    </div>

    <!-- DOCTORES -->
    <div class="col-md-3">
        <div class="card shadow-sm border-0 text-center">
            <div class="card-body">
                <i class="bi bi-person-badge fs-1 text-success"></i>
                <h3 class="fw-bold"><?= $stats['doctores'] ?></h3>
                <p class="text-muted mb-0">Doctores</p>
            </div>
        </div>
    </div>

    <!-- MASCOTAS -->
    <div class="col-md-3">
        <div class="card shadow-sm border-0 text-center">
            <div class="card-body">
                <i class="bi bi-heart-pulse fs-1 text-success"></i>
                <h3 class="fw-bold"><?= $stats['mascotas'] ?></h3>
                <p class="text-muted mb-0">Mascotas</p>
            </div>
        </div>
    </div>

</div>

<!-- ================== ACCESOS RÁPIDOS ================== -->
<div class="row g-3 mb-4">

    <div class="col-md-4">
        <a href="index.php?url=paciente/index" class="btn btn-outline-success w-100 py-3">
            <i class="bi bi-people"></i> Gestión de Pacientes
        </a>
    </div>

    <div class="col-md-4">
        <a href="index.php?url=mascota/index" class="btn btn-outline-success w-100 py-3">
            <i class="bi bi-heart-pulse"></i> Gestión de Mascotas
        </a>
    </div>

    <div class="col-md-4">
        <a href="index.php?url=doctor/index" class="btn btn-outline-success w-100 py-3">
            <i class="bi bi-person-badge"></i> Gestión de Doctores
        </a>
    </div>

</div>

<!-- ================== AUDITORÍA ================== -->
<div class="card shadow-sm border-0">
    <div class="card-header bg-success text-white fw-bold">
        <i class="bi bi-shield-check"></i> Últimos eventos de auditoría
    </div>

    <div class="table-responsive">
        <table class="table table-hover mb-0 align-middle">
            <thead class="table-light">
                <tr>
                    <th>Fecha</th>
                    <th>Usuario</th>
                    <th>Acción</th>
                    <th>Tabla</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($logs as $l): ?>
                <tr>
                    <td><?= $l['fecha'] ?></td>
                    <td><?= $l['nombre'] ?? 'Sistema' ?></td>
                    <td>
                       <?php
$accion = $l['accion'];
$badge  = 'secondary';
$texto  = $accion;

switch ($accion) {
    case 'INSERT':
        $badge = 'success';
        $texto = 'Creación';
        break;
    case 'UPDATE':
        $badge = 'warning';
        $texto = 'Actualización';
        break;
    case 'DELETE':
        $badge = 'danger';
        $texto = 'Eliminación';
        break;
    case 'LOGIN':
        $badge = 'primary';
        $texto = 'Inicio de sesión';
        break;
    case 'LOGOUT':
        $badge = 'dark';
        $texto = 'Cierre de sesión';
        break;
}
?>

<span class="badge bg-<?= $badge ?>">
    <?= $texto ?>
</span>

                    </td>
                    <td><?= $l['tabla_afectada'] ?></td>
                </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>
</div>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
