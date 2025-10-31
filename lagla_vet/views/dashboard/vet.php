<section class="lv-card">
    <h2>Panel Veterinario - Lagla Vet</h2>
    <p>Dr./Dra. <?php echo htmlspecialchars($nombre); ?> (VET)</p>

    <h3>Mis citas</h3>
    <table class="lv-table">
        <tr>
            <th>ID Cita</th>
            <th>Fecha/Hora</th>
            <th>Mascota</th>
            <th>Dueño</th>
            <th>Motivo</th>
            <th>Estado</th>
        </tr>

        <?php foreach ($citas as $c) { ?>
        <tr>
            <td><?php echo $c['id_cita']; ?></td>
            <td><?php echo htmlspecialchars($c['fecha_cita']); ?></td>
            <td><?php echo htmlspecialchars($c['nombre_mascota']); ?></td>
            <td><?php echo htmlspecialchars($c['nombre_dueno']); ?></td>
            <td><?php echo htmlspecialchars($c['motivo']); ?></td>
            <td><?php echo htmlspecialchars($c['estado']); ?></td>
        </tr>
        <?php } ?>
    </table>
</section>
