<h2 class="h5 mb-3">Pacientes (Dueños y Mascotas)</h2>

<table class="table table-hover table-sm align-middle shadow-sm bg-white">
    <thead class="table-primary">
        <tr>
            <th>ID</th>
            <th>Mascota</th>
            <th>Especie</th>
            <th>Raza</th>
            <th>Dueño</th>
            <th>Teléfono</th>
            <th>Ficha</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($pacientes as $p) { ?>
        <tr>
            <td><?php echo $p['id_mascota']; ?></td>
            <td><?php echo htmlspecialchars($p['nombre_mascota']); ?></td>
            <td><?php echo htmlspecialchars($p['especie']); ?></td>
            <td><?php echo htmlspecialchars($p['raza']); ?></td>
            <td><?php echo htmlspecialchars($p['dueno']); ?></td>
            <td><?php echo htmlspecialchars($p['telefono']); ?></td>
            <td>
                <a class="btn btn-sm btn-outline-primary"
                   href="index.php?controller=paciente&action=ficha&id=<?php echo $p['id_mascota']; ?>">
                   Ver ficha
                </a>
            </td>
        </tr>
        <?php } ?>
    </tbody>
</table>
