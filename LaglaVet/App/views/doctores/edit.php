<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<h3 class="mb-4">Editar Doctor Veterinario</h3>

<form action="index.php?url=doctor/update" method="POST" class="card shadow p-4">

    <input type="hidden" name="id" value="<?= $doctor['id'] ?>">
    <input type="hidden" name="usuario_id" value="<?= $doctor['usuario_id'] ?>">

    <div class="mb-3">
        <label class="form-label">Nombre completo</label>
        <input type="text" name="nombre" class="form-control"
               value="<?= htmlspecialchars($doctor['nombre']) ?>" required>
    </div>

    <div class="mb-3">
        <label class="form-label">Correo electrónico</label>
        <input type="email" name="email" class="form-control"
               value="<?= htmlspecialchars($doctor['email']) ?>" required>
    </div>

    <div class="mb-3">
        <label class="form-label">Especialidad veterinaria</label>
        <select name="especialidad" class="form-select" required>
            <?php
            $especialidades = [
                'Medicina General',
                'Cirugía Veterinaria',
                'Dermatología',
                'Cardiología',
                'Animales Exóticos'
            ];
            foreach ($especialidades as $e):
            ?>
                <option value="<?= $e ?>"
                    <?= $doctor['especialidad'] === $e ? 'selected' : '' ?>>
                    <?= $e ?>
                </option>
            <?php endforeach; ?>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label">Licencia profesional</label>
        <select name="licencia" class="form-select" required>
            <option value="Activo" <?= $doctor['licencia']=='Activo'?'selected':'' ?>>Activo</option>
            <option value="En trámite" <?= $doctor['licencia']=='En trámite'?'selected':'' ?>>En trámite</option>
            <option value="Suspendido" <?= $doctor['licencia']=='Suspendido'?'selected':'' ?>>Suspendido</option>
        </select>
    </div>

    <button class="btn btn-success w-100">
        <i class="bi bi-save"></i> Guardar cambios
    </button>

</form>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
