<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-7">

            <div class="card shadow">
                <div class="card-header bg-success text-white">
                    <h5 class="mb-0">
                        <i class="bi bi-pencil-square"></i> Editar Mascota
                    </h5>
                </div>

                <div class="card-body">
                    <form method="POST" action="index.php?url=mascota/update">

                        <!-- ID OCULTO -->
                        <input type="hidden" name="id" value="<?= htmlspecialchars($mascota['id']) ?>">

                        <!-- NOMBRE -->
                        <div class="mb-3">
                            <label class="form-label">Nombre de la mascota</label>
                            <input type="text"
                                   name="nombre"
                                   class="form-control"
                                   value="<?= htmlspecialchars($mascota['nombre']) ?>"
                                   required>
                        </div>

                        <!-- ESPECIE -->
                        <div class="mb-3">
                            <label class="form-label">Especie</label>
                            <input type="text"
                                   name="especie"
                                   class="form-control"
                                   value="<?= htmlspecialchars($mascota['especie']) ?>"
                                   required>
                        </div>

                        <!-- RAZA -->
                        <div class="mb-3">
                            <label class="form-label">Raza</label>
                            <input type="text"
                                   name="raza"
                                   class="form-control"
                                   value="<?= htmlspecialchars($mascota['raza']) ?>">
                        </div>

                        <!-- EDAD -->
                        <div class="mb-3">
                            <label class="form-label">Edad</label>
                            <input type="number"
                                   name="edad"
                                   class="form-control"
                                   value="<?= htmlspecialchars($mascota['edad']) ?>"
                                   min="0">
                        </div>

                        <!-- BOTONES -->
                        <div class="d-flex justify-content-between">
                            <a href="index.php?url=mascota/index" class="btn btn-secondary">
                                <i class="bi bi-arrow-left"></i> Volver
                            </a>

                            <button type="submit" class="btn btn-success">
                                <i class="bi bi-save"></i> Actualizar
                            </button>
                        </div>

                    </form>
                </div>
            </div>

        </div>
    </div>
</div>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
