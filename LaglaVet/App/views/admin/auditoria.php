<h2>Auditoría del Sistema</h2>

<table border="1">
<tr>
    <th>Fecha</th>
    <th>Usuario</th>
    <th>Acción</th>
    <th>Tabla</th>
    <th>ID Registro</th>
    <th>Descripción</th>
    <th>IP</th>
</tr>

<?php foreach ($logs as $log): ?>
<tr>
    <td><?= $log['fecha'] ?></td>
    <td><?= $log['usuario'] ?? 'Sistema' ?></td>
    <td><?= $log['accion'] ?></td>
    <td><?= $log['tabla_afectada'] ?></td>
    <td><?= $log['registro_id'] ?></td>
    <td><?= $log['descripcion'] ?></td>
    <td><?= $log['ip'] ?></td>
</tr>
<?php endforeach; ?>
</table>

<br>
<a href="index.php?url=admin/dashboard">Volver al panel</a>
