<section class="lv-card">
    <h2>Panel Administrativo - Lagla Vet</h2>
    <p>Hola <?php echo htmlspecialchars($nombre); ?> (ADMIN)</p>

    <h3>Usuarios del sistema</h3>
    <table class="lv-table">
        <tr>
            <th>ID</th>
            <th>Usuario</th>
            <th>Nombre completo</th>
            <th>Rol</th>
            <th>Activo</th>
        </tr>

        <?php foreach ($usuarios as $u) { ?>
        <tr>
            <td><?php echo $u['id_usuario']; ?></td>
            <td><?php echo htmlspecialchars($u['username']); ?></td>
            <td><?php echo htmlspecialchars($u['nombre_completo']); ?></td>
            <td><?php echo htmlspecialchars($u['rol']); ?></td>
            <td><?php echo $u['activo'] ? 'Sí' : 'No'; ?></td>
        </tr>
        <?php } ?>
    </table>
</section>
