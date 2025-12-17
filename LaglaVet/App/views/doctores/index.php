<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<h3>Doctores</h3>

<a href="index.php?url=doctor/create" class="btn btn-success mb-3">
    <i class="bi bi-plus-circle"></i> Nuevo Doctor
</a>

<table class="table table-hover shadow">
<thead class="table-success">
<tr>
    <th>Nombre</th>
    <th>Email</th>
    <th>Especialidad</th>
    <th>Acciones</th>
</tr>
</thead>
<tbody>
<?php foreach ($doctores as $d): ?>
<tr>
    <td><?= $d['nombre'] ?></td>
    <td><?= $d['email'] ?></td>
    <td><?= $d['especialidad'] ?></td>
    <td>
        <a class="btn btn-warning btn-sm" href="index.php?url=doctor/edit&id=<?= $d['id'] ?>">Editar</a>
        <a class="btn btn-danger btn-sm" href="index.php?url=doctor/delete&id=<?= $d['id'] ?>">Eliminar</a>
    </td>
</tr>
<?php endforeach; ?>
</tbody>
</table>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
