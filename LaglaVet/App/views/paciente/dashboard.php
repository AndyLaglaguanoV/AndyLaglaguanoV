<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<div class="container mt-4">

    <!-- TÍTULO -->
    <div class="d-flex align-items-center mb-4">
        <i class="bi bi-person-badge text-success fs-2 me-2"></i>
        <h3 class="mb-0">Panel del Paciente</h3>
    </div>

    <!-- ALERTA PERFIL INCOMPLETO -->
    <?php if (empty($paciente)): ?>
        <div class="alert alert-warning d-flex align-items-center">
            <i class="bi bi-exclamation-triangle-fill me-2 fs-5"></i>
            <div>
                <strong>Perfil incompleto.</strong>
                Completa tus datos (cédula, teléfono y dirección) para registrar mascotas y solicitar citas.
            </div>
        </div>
    <?php endif; ?>

    <!-- TARJETAS -->
    <div class="row g-4">

        <!-- MI PERFIL -->
        <div class="col-md-6 col-lg-4">
            <div class="card shadow-sm h-100 text-center">
                <div class="card-body d-flex flex-column justify-content-center py-4">
                    <i class="bi bi-clipboard-check text-success mb-3" style="font-size: 3rem;"></i>
                    <h5 class="fw-semibold">Mi Perfil</h5>
                    <p class="text-muted small mb-3">Datos del dueño</p>
                    <a href="index.php?url=paciente/profile"
                       class="btn btn-outline-success btn-sm">
                        <?= empty($paciente) ? "Completar perfil" : "Ver / Editar perfil" ?>
                    </a>
                </div>
            </div>
        </div>

        <!-- MIS MASCOTAS -->
        <div class="col-md-6 col-lg-4">
            <div class="card shadow-sm h-100 text-center">
                <div class="card-body d-flex flex-column justify-content-center py-4">
                    <i class="bi bi-heart-pulse text-success mb-3" style="font-size: 3rem;"></i>
                    <h5 class="fw-semibold">Mis Mascotas</h5>
                    <p class="text-muted small mb-3">Gestiona tus mascotas</p>
                    <a href="index.php?url=mascota/index"
                       class="btn btn-outline-success btn-sm">
                        Ver mascotas
                    </a>
                </div>
            </div>
        </div>

        <!-- SOLICITAR CITA -->
        <div class="col-md-6 col-lg-4">
            <div class="card shadow-sm h-100 text-center">
                <div class="card-body d-flex flex-column justify-content-center py-4">
                    <i class="bi bi-calendar2-plus text-success mb-3" style="font-size: 3rem;"></i>
                    <h5 class="fw-semibold">Solicitar Cita</h5>
                    <p class="text-muted small mb-3">Agenda una cita veterinaria</p>
                    <a href="index.php?url=cita/create"
                       class="btn btn-outline-success btn-sm">
                        Nueva cita
                    </a>
                </div>
            </div>
        </div>

        <!-- MIS CITAS -->
        <div class="col-md-6 col-lg-4">
            <div class="card shadow-sm h-100 text-center border-success">
                <div class="card-body d-flex flex-column justify-content-center py-4">
                    <i class="bi bi-calendar-check text-success mb-3" style="font-size: 3rem;"></i>
                    <h5 class="fw-semibold">Mis Citas</h5>
                    <p class="text-muted small mb-3">Consulta tus citas registradas</p>
                    <a href="index.php?url=cita/misCitas"
                       class="btn btn-success btn-sm">
                        Ver citas
                    </a>
                </div>
            </div>
        </div>

    </div>
</div>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
