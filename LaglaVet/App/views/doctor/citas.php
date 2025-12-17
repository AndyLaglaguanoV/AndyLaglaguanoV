<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<h3 class="mb-4">📅 Mis Citas</h3>

<?php if (empty($citas)): ?>
    <div class="alert alert-info">
        No tienes citas pendientes.
    </div>
<?php else: ?>
<table class="table table-bordered">
    <thead class="table-success">
        <tr>
            <th>Mascota</th>
            <th>Fecha</th>
            <th>Motivo</th>
            <th>Acción</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($citas as $c): ?>
        <tr>
            <td><?= htmlspecialchars($c['mascota']) ?></td>
            <td><?= $c['fecha'] ?></td>
            <td><?= htmlspecialchars($c['motivo']) ?></td>
            <td>
                <a href="index.php?url=doctor/aceptarCita&id=<?= $c['id'] ?>"
                   class="btn btn-success btn-sm">
                    Aceptar
                </a>
            </td>
        </tr>
        <?php endforeach; ?>
    </tbody>
</table>
<?php endif; ?>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
