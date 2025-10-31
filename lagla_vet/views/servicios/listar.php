<div class="d-flex justify-content-between align-items-center mb-3">
    <h2 class="h5 mb-0">Servicios y Cirugías</h2>
    <button class="btn btn-sm btn-primary" disabled>
        + Nuevo servicio (ADMIN)
    </button>
</div>

<table class="table table-hover table-sm align-middle shadow-sm bg-white">
    <thead class="table-primary">
        <tr>
            <th>Servicio</th>
            <th>Tipo</th>
            <th>Doctor responsable</th>
            <th>Precio (USD)</th>
            <th>Duración estimada</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($servicios as $s) { ?>
        <tr>
            <td><?php echo htmlspecialchars($s['nombre_servicio']); ?></td>
            <td><?php echo htmlspecialchars($s['categoria']); ?></td>
            <td><?php echo htmlspecialchars($s['doctor_responsable']); ?></td>
            <td>$<?php echo number_format($s['precio'], 2); ?></td>
            <td><?php echo htmlspecialchars($s['duracion_estim']); ?></td>
        </tr>
        <?php } ?>
    </tbody>
</table>
