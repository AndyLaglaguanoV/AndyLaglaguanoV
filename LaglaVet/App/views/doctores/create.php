<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<h3 class="mb-4">Nuevo Doctor</h3>

<div class="card shadow">
    <div class="card-body">

        <form method="POST" action="index.php?url=doctor/store">

            <!-- DATOS DE USUARIO -->
            <h5 class="mb-3 text-success">Datos de acceso</h5>

            <div class="mb-3">
                <label class="form-label">Nombre completo</label>
                <input type="text" name="nombre" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Correo electrónico</label>
                <input type="email" name="email" class="form-control" required>
            </div>

            <div class="mb-4">
                <label class="form-label">Contraseña</label>
                <input type="password" name="password" class="form-control" required>
            </div>

            <hr>

            <!-- DATOS PROFESIONALES -->
            <h5 class="mb-3 text-success">Datos profesionales</h5>

            <div class="mb-3">
                <label class="form-label">Especialidad</label>
                <select name="especialidad" class="form-select" required>
                    <option value="">Seleccione</option>
                    <option value="Cirugía">Cirugía</option>
                    <option value="Medicina General">Medicina General</option>
                    <option value="Dermatología">Dermatología</option>
                    <option value="Cardiología">Cardiología</option>
                    <option value="Traumatología">Traumatología</option>
                </select>
            </div>

            <div class="mb-4">
                <label class="form-label">Licencia</label>
                <select name="licencia" class="form-select" required>
                    <option value="">Seleccione</option>
                    <option value="MVZ">MVZ</option>
                    <option value="SENESCYT">SENESCYT</option>
                    <option value="Internacional">Internacional</option>
                </select>
            </div>

            <button class="btn btn-success w-100">
                <i class="bi bi-save"></i> Guardar Doctor
            </button>
        </form>

    </div>
</div>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
