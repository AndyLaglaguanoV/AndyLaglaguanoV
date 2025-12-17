<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<div class="d-flex justify-content-between align-items-center mb-3">
    <h3 class="mb-0">Mascotas</h3>

    <?php if ($_SESSION['user']['rol'] === 'administrador'): ?>
        <a href="index.php?url=mascota/create" class="btn btn-success">
            <i class="bi bi-plus-circle"></i> Nueva Mascota
        </a>
    <?php endif; ?>
</div>

<div class="card shadow-sm">
    <div class="card-body p-0">
        <table class="table table-hover mb-0">
            <thead class="table-success">
                <tr>
                    <th>Nombre</th>
                    <th>Especie</th>
                    <th>Raza</th>
                    <th>Edad</th>
                    <th class="text-center">Acciones</th>
                </tr>
            </thead>

            <tbody>
            <?php if (empty($mascotas)): ?>
                <tr>
                    <td colspan="5" class="text-center text-muted py-4">
                        No hay mascotas registradas
                    </td>
                </tr>
            <?php else: ?>
                <?php foreach ($mascotas as $m): ?>
                    <tr>
                        <td><?= htmlspecialchars($m['nombre']) ?></td>
                        <td><?= htmlspecialchars($m['especie']) ?></td>
                        <td><?= htmlspecialchars($m['raza'] ?? 'No especificada') ?></td>
                        <td><?= isset($m['edad']) && $m['edad'] > 0 ? htmlspecialchars($m['edad']) : 'N/A' ?></td>

                        <td class="text-center">
                            <!-- EDITAR (admin y doctor si quieres) -->
                            <?php if ($_SESSION['user']['rol'] !== 'paciente'): ?>
                                <a href="index.php?url=mascota/edit&id=<?= $m['id'] ?>"
                                   class="btn btn-warning btn-sm">
                                    <i class="bi bi-pencil"></i>
                                </a>
                            <?php endif; ?>

                            <!-- ELIMINAR (admin y paciente) -->
                            <?php if (in_array($_SESSION['user']['rol'], ['administrador', 'paciente'])): ?>
                                <a href="index.php?url=mascota/delete&id=<?= $m['id'] ?>"
                                   class="btn btn-danger btn-sm"
                                   onclick="return confirm('¿Eliminar la mascota <?= htmlspecialchars($m['nombre']) ?>?')">
                                    <i class="bi bi-trash"></i>
                                </a>
                            <?php endif; ?>
                        </td>
                    </tr>
                <?php endforeach; ?>
            <?php endif; ?>
            </tbody>
        </table>
    </div>
</div>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
