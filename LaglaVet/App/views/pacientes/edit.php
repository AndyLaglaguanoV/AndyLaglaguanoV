<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<h3 class="mb-4">Editar Paciente</h3>

<form method="POST"
      action="index.php?url=paciente/update"
      class="card shadow p-4">

    <!-- 🔴 CAMPOS OCULTOS OBLIGATORIOS -->
    <input type="hidden" name="id" value="<?= $paciente['id'] ?>">
    <input type="hidden" name="usuario_id" value="<?= $paciente['usuario_id'] ?>">

    <h5 class="text-success mb-3">Datos del Usuario</h5>

    <div class="mb-3">
        <label class="form-label">Nombre completo</label>
        <input
            type="text"
            name="nombre"
            class="form-control"
            value="<?= htmlspecialchars($paciente['nombre']) ?>"
            required>
    </div>

    <div class="mb-3">
        <label class="form-label">Correo electrónico</label>
        <input
            type="email"
            name="email"
            class="form-control"
            value="<?= htmlspecialchars($paciente['email']) ?>"
            required>
    </div>

    <hr>

    <h5 class="text-success mb-3">Datos del Paciente</h5>

    <div class="mb-3">
        <label class="form-label">Cédula</label>
        <input
            type="text"
            name="cedula"
            class="form-control"
            value="<?= htmlspecialchars($paciente['cedula']) ?>"
            required>
    </div>

    <div class="mb-3">
        <label class="form-label">Teléfono</label>
        <input
            type="text"
            name="telefono"
            class="form-control"
            value="<?= htmlspecialchars($paciente['telefono']) ?>">
    </div>

    <div class="mb-3">
        <label class="form-label">Dirección</label>
        <input
            type="text"
            name="direccion"
            class="form-control"
            value="<?= htmlspecialchars($paciente['direccion']) ?>">
    </div>

    <button class="btn btn-success w-100">
        <i class="bi bi-save"></i> Actualizar
    </button>

</form>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
