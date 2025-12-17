<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<h3 class="mb-4">Mis Pacientes</h3>

<?php if (empty($pacientes)): ?>
    <div class="alert alert-info">
        No tienes pacientes asignados todavía.
    </div>
<?php else: ?>
<table class="table table-striped shadow">
    <thead class="table-success">
        <tr>
            <th>Nombre</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($pacientes as $p): ?>
        <tr>
            <td><?= $p['nombre'] ?></td>
            <td><?= $p['email'] ?></td>
        </tr>
        <?php endforeach; ?>
    </tbody>
</table>
<?php endif; ?>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
