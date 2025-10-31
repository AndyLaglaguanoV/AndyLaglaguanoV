<div class="d-flex justify-content-between align-items-center mb-3">
    <h2 class="h5 mb-0">Agenda de Citas</h2>
    <a href="index.php?controller=cita&action=nueva" class="btn btn-sm btn-success">
        + Nueva cita
    </a>
</div>

<?php if (!empty($msg)) { ?>
<div class="alert alert-success"><?php echo htmlspecialchars($msg); ?></div>
<?php } ?>

<table class="table table-striped table-hover table-sm align-middle shadow-sm bg-white">
    <thead class="table-primary">
        <tr>
            <th>#</th>
            <th>Fecha / Hora</th>
            <th>Mascota</th>
            <th>Dueño</th>
            <th>Doctor</th>
            <th>Motivo</th>
            <th>Estado</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($citas as $c) { ?>
        <tr>
            <td><?php echo $c['id_cita']; ?></td>
            <td><?php echo $c['fecha_hora']; ?></td>
            <td><?php echo htmlspecialchars($c['mascota']); ?></td>
            <td><?php echo htmlspecialchars($c['dueno']); ?></td>
            <td><?php echo htmlspecialchars($c['doctor']); ?></td>
            <td><?php echo htmlspecialchars($c['motivo']); ?></td>
            <td>
                <span class="badge
                    <?php
                        echo $c['estado'] === 'PENDIENTE' ? 'bg-warning text-dark'
                        : ($c['estado'] === 'ATENDIDA' ? 'bg-success'
                        : 'bg-danger');
                    ?>">
                    <?php echo $c['estado']; ?>
                </span>
            </td>
        </tr>
        <?php } ?>
    </tbody>
</table>
