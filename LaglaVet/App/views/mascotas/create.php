<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-7 col-lg-6">

            <div class="card shadow-sm">
                <div class="card-header bg-success text-white text-center">
                    <h5 class="mb-0">
                        <i class="bi bi-heart-fill me-2"></i>
                        Nueva Mascota
                    </h5>
                </div>

                <div class="card-body">
                    <form action="index.php?url=mascota/store" method="POST">

                        <!-- SOLO ADMIN SELECCIONA PACIENTE -->
                        <?php if ($_SESSION['user']['rol'] === 'administrador'): ?>
                            <div class="mb-3">
                                <label class="form-label">Paciente</label>
                                <select name="paciente_id" class="form-select" required>
                                    <option value="">-- Seleccione un paciente --</option>
                                    <?php foreach ($pacientes as $p): ?>
                                        <option value="<?= $p['id'] ?>">
                                            <?= htmlspecialchars($p['nombre']) ?> (<?= htmlspecialchars($p['email']) ?>)
                                        </option>
                                    <?php endforeach; ?>
                                </select>
                            </div>
                        <?php endif; ?>

                        <div class="mb-3">
                            <label class="form-label">Nombre de la mascota</label>
                            <input type="text" name="nombre" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Especie</label>
                            <input type="text" name="especie" class="form-control" placeholder="Ej: Perro, Gato" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Raza</label>
                            <input type="text" name="raza" class="form-control">
                        </div>

                        <div class="mb-4">
                            <label class="form-label">Edad (años)</label>
                            <input type="number" name="edad" class="form-control" min="0">
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-success">
                                <i class="bi bi-save me-1"></i>
                                Guardar mascota
                            </button>
                        </div>

                    </form>
                </div>
            </div>

            <div class="text-center mt-3">
                <a href="index.php?url=mascota/index" class="text-decoration-none">
                    ← Volver
                </a>
            </div>

        </div>
    </div>
</div>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
