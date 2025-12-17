<?php require_once __DIR__ . '/../layouts/header.php'; ?>
<?php if (isset($_SESSION['success'])): ?>
    <div class="alert alert-success text-center">
        <i class="bi bi-check-circle me-1"></i>
        <?= $_SESSION['success']; ?>
    </div>
    <?php unset($_SESSION['success']); ?>
<?php endif; ?>

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-7 col-lg-6">

      <div class="card shadow-sm">
        <div class="card-header bg-success text-white text-center">
          <h5 class="mb-0"><i class="bi bi-person-vcard me-2"></i>Mi Perfil de Paciente</h5>
        </div>

        <div class="card-body">
          <form method="POST" action="index.php?url=paciente/saveProfile">
            <div class="mb-3">
              <label class="form-label">Cédula</label>
              <input type="text" name="cedula" class="form-control"
                     value="<?= htmlspecialchars($paciente['cedula'] ?? '') ?>" required>
            </div>

            <div class="mb-3">
              <label class="form-label">Teléfono</label>
              <input type="text" name="telefono" class="form-control"
                     value="<?= htmlspecialchars($paciente['telefono'] ?? '') ?>">
            </div>

            <div class="mb-4">
              <label class="form-label">Dirección</label>
              <input type="text" name="direccion" class="form-control"
                     value="<?= htmlspecialchars($paciente['direccion'] ?? '') ?>">
            </div>

            <div class="d-grid">
              <button class="btn btn-success">
                <i class="bi bi-save me-1"></i> Guardar
              </button>
            </div>
          </form>
        </div>
      </div>

      <div class="text-center mt-3">
        <a href="index.php?url=paciente/dashboard" class="text-decoration-none">← Volver</a>
      </div>

    </div>
  </div>
</div>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
