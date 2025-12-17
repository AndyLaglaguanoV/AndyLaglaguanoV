<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<h3 class="mb-4">
    <i class="bi bi-person-badge text-success"></i>
    Panel del Doctor
</h3>

<!-- TARJETAS -->
<div class="row g-4 mb-4">

    <!-- MI PERFIL -->
    <div class="col-md-3">
        <div class="card shadow-sm text-center h-100">
            <div class="card-body">
                <i class="bi bi-person-vcard fs-1 text-success"></i>
                <h5 class="mt-3">Mi Perfil</h5>
                <p class="text-muted">Información profesional</p>
                <a href="index.php?url=doctor/edit"
                   class="btn btn-outline-success btn-sm">
                    Ver / Editar perfil
                </a>
            </div>
        </div>
    </div>

    <!-- PACIENTES -->
    <div class="col-md-3">
        <div class="card shadow-sm text-center h-100">
            <div class="card-body">
                <i class="bi bi-people fs-1 text-success"></i>
                <h5 class="mt-3">Pacientes</h5>
                <p class="text-muted">Pacientes asignados</p>
                <a href="index.php?url=doctor/pacientes"
                   class="btn btn-outline-success btn-sm">
                    Ver pacientes
                </a>
            </div>
        </div>
    </div>

    <!-- MASCOTAS -->
    <div class="col-md-3">
        <div class="card shadow-sm text-center h-100">
            <div class="card-body">
                <i class="bi bi-heart-pulse fs-1 text-success"></i>
                <h5 class="mt-3">Mascotas</h5>
                <p class="text-muted">Gestión de mascotas</p>
                <a href="index.php?url=mascota/index"
                   class="btn btn-outline-success btn-sm">
                    Ver mascotas
                </a>
            </div>
        </div>
    </div>

    <!-- CITAS -->
    <div class="col-md-3">
        <div class="card shadow-sm text-center h-100">
            <div class="card-body">
                <i class="bi bi-calendar-check fs-1 text-success"></i>
                <h5 class="mt-3">Citas</h5>
                <p class="text-muted">Citas pendientes</p>
                <a href="index.php?url=doctor/citas"
                   class="btn btn-outline-success btn-sm">
                    Ver citas
                </a>
            </div>
        </div>
    </div>

</div>

<!-- INFO -->
<div class="card shadow-sm">
    <div class="card-body text-center">
        <i class="bi bi-info-circle fs-1 text-success"></i>
        <h5 class="mt-3">Sistema LaglaVet</h5>
        <p class="text-muted mb-0">
            Gestiona tu perfil profesional, revisa pacientes asignados
            y administra citas y mascotas bajo tu cuidado.
        </p>
    </div>
</div>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
