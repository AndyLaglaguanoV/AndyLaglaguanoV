<section class="lv-card">
    <h2>Panel Recepción - Lagla Vet</h2>
    <p>Hola <?php echo htmlspecialchars($nombre); ?> (RECEP)</p>

    <h3>Mascotas registradas</h3>
    <table class="lv-table">
        <tr>
            <th>ID</th>
            <th>Mascota</th>
            <th>Especie</th>
            <th>Raza</th>
            <th>Dueño</th>
            <th>Teléfono</th>
        </tr>

        <?php foreach ($mascotas as $m) { ?>
        <tr>
            <td><?php echo $m['id_mascota']; ?></td>
            <td><?php echo htmlspecialchars($m['nombre_mascota']); ?></td>
            <td><?php echo htmlspecialchars($m['especie']); ?></td>
            <td><?php echo htmlspecialchars($m['raza']); ?></td>
            <td><?php echo htmlspecialchars($m['nombre_dueno']); ?></td>
            <td><?php echo htmlspecialchars($m['telefono']); ?></td>
        </tr>
        <?php } ?>
    </table>
</section>
