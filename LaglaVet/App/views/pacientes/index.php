<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<h3 class="mb-3">Pacientes</h3>

<?php if ($_SESSION['user']['rol'] === 'administrador'): ?>
<a href="index.php?url=paciente/create" class="btn btn-success mb-3">
    <i class="bi bi-plus-circle"></i> Nuevo Paciente
</a>
<?php endif; ?>

<table class="table table-bordered table-hover shadow">
    <thead class="table-success">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($pacientes as $p): ?>
        <tr>
            <td><?= $p['id'] ?></td>
            <td><?= $p['nombre'] ?></td>
            <td><?= $p['email'] ?></td>
            <td>
                <a class="btn btn-warning btn-sm"
                   href="index.php?url=paciente/edit&id=<?= $p['id'] ?>">
                   Editar
                </a>

                <?php if ($_SESSION['user']['rol'] === 'administrador'): ?>
                <a class="btn btn-danger btn-sm"
                   href="index.php?url=paciente/delete&id=<?= $p['id'] ?>">
                   Eliminar
                </a>
                <?php endif; ?>
            </td>
        </tr>
        <?php endforeach; ?>
    </tbody>
</table>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
