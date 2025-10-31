<h2 class="h5 mb-3">Doctores Veterinarios</h2>

<table class="table table-hover table-sm align-middle shadow-sm bg-white">
    <thead class="table-primary">
        <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Especialidad</th>
            <th>Disponible</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($doctores as $d) { ?>
        <tr>
            <td><?php echo $d['id_doctor']; ?></td>
            <td><?php echo htmlspecialchars($d['nombre_doctor']); ?></td>
            <td><?php echo htmlspecialchars($d['especialidad']); ?></td>
            <td>
                <?php if ($d['disponible']) { ?>
                    <span class="badge bg-success">Sí</span>
                <?php } else { ?>
                    <span class="badge bg-danger">No</span>
                <?php } ?>
            </td>
        </tr>
        <?php } ?>
    </tbody>
</table>
