<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<div class="row justify-content-center">
  <div class="col-12 col-md-7 col-lg-5">

    <div class="card shadow-sm border-0">
      <div class="card-header bg-success text-white text-center py-3">
        <div class="d-flex align-items-center justify-content-center gap-2">
          <i class="bi bi-calendar2-plus fs-4"></i>
          <h5 class="mb-0">Solicitar Cita Veterinaria</h5>
        </div>
      </div>

      <div class="card-body p-4">

        <?php if (!empty($_SESSION['error'])): ?>
          <div class="alert alert-danger">
            <i class="bi bi-x-circle"></i>
            <?= htmlspecialchars($_SESSION['error']); unset($_SESSION['error']); ?>
          </div>
        <?php endif; ?>

        <?php if (!empty($_SESSION['success'])): ?>
          <div class="alert alert-success">
            <i class="bi bi-check-circle"></i>
            <?= htmlspecialchars($_SESSION['success']); unset($_SESSION['success']); ?>
          </div>
        <?php endif; ?>

        <?php if (empty($mascotas)): ?>
          <div class="alert alert-warning text-center mb-0">
            <i class="bi bi-exclamation-triangle fs-4"></i>
            <div class="mt-2">
              Primero debes <b>registrar una mascota</b> para poder solicitar una cita.
            </div>
            <div class="mt-3">
              <a href="index.php?url=mascota/create" class="btn btn-warning">
                <i class="bi bi-plus-circle"></i> Registrar mascota
              </a>
            </div>
          </div>

        <?php else: ?>

          <form action="index.php?url=cita/store" method="POST" class="needs-validation" novalidate>

            <!-- Mascota -->
            <div class="mb-3">
              <label class="form-label">
                <i class="bi bi-paw-fill text-success"></i> Mascota
              </label>
              <select name="mascota_id" class="form-select" required>
                <option value="" selected disabled>Seleccione su mascota</option>
                <?php foreach ($mascotas as $m): ?>
                  <option value="<?= (int)$m['id'] ?>">
                    <?= htmlspecialchars($m['nombre'] ?? ('Mascota #' . $m['id'])) ?>
                  </option>
                <?php endforeach; ?>
              </select>
              <div class="invalid-feedback">Selecciona una mascota.</div>
            </div>

            <!-- Doctor -->
            <div class="mb-3">
              <label class="form-label">
                <i class="bi bi-person-badge text-success"></i> Doctor
              </label>
              <select name="doctor_id" class="form-select" required>
                <option value="" selected disabled>Seleccione un doctor</option>
                <?php foreach ($doctores as $d): ?>
                  <option value="<?= (int)$d['id'] ?>">
                    <?= htmlspecialchars($d['nombre']) ?> — <?= htmlspecialchars($d['especialidad'] ?? 'General') ?>
                  </option>
                <?php endforeach; ?>
              </select>
              <div class="invalid-feedback">Selecciona un doctor.</div>
            </div>

            <!-- Fecha y hora -->
            <div class="mb-3">
              <label class="form-label">
                <i class="bi bi-clock text-success"></i> Fecha y hora
              </label>
              <input type="datetime-local" name="fecha" class="form-control" required>
              <div class="invalid-feedback">Ingresa una fecha y hora.</div>
            </div>

            <!-- Motivo -->
            <div class="mb-3">
              <label class="form-label">
                <i class="bi bi-chat-left-text text-success"></i> Motivo de la cita
              </label>
              <textarea name="motivo" class="form-control" rows="3" placeholder="Ej: Vacuna, control, vómitos, dolor..." required></textarea>
              <div class="invalid-feedback">Escribe el motivo.</div>
            </div>

            <button class="btn btn-success w-100">
              <i class="bi bi-check2-circle"></i> Solicitar cita
            </button>

            <a href="index.php?url=paciente/dashboard" class="btn btn-outline-secondary w-100 mt-2">
              <i class="bi bi-arrow-left"></i> Volver
            </a>

          </form>

          <script>
            // Validación Bootstrap
            (() => {
              'use strict';
              const forms = document.querySelectorAll('.needs-validation');
              Array.from(forms).forEach(form => {
                form.addEventListener('submit', event => {
                  if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                  }
                  form.classList.add('was-validated');
                }, false);
              });
            })();
          </script>

        <?php endif; ?>

      </div>
    </div>

  </div>
</div>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
