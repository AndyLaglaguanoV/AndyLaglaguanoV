<h2 class="h5 mb-3">Ficha de mascota</h2>

<div class="card shadow-sm mb-3">
  <div class="card-body">
    <div class="fw-bold">Mascota:</div>
    <div><?php echo htmlspecialchars($ficha['nombre_mascota']); ?></div>

    <div class="fw-bold mt-2">Dueño:</div>
    <div><?php echo htmlspecialchars($ficha['dueno']); ?></div>
  </div>
</div>

<div class="card shadow-sm">
  <div class="card-header bg-primary text-white">
    Historial clínico
  </div>
  <div class="card-body">
    <?php if (empty($ficha['historial'])) { ?>
        <div class="text-muted">Sin historial registrado.</div>
    <?php } else { ?>
        <ul class="list-group">
        <?php foreach ($ficha['historial'] as $h) { ?>
            <li class="list-group-item">
                <div><strong>Fecha:</strong> <?php echo $h['fecha']; ?></div>
                <div><strong>Detalle:</strong> <?php echo htmlspecialchars($h['detalle']); ?></div>
                <div><strong>Doctor:</strong> <?php echo htmlspecialchars($h['doctor']); ?></div>
            </li>
        <?php } ?>
        </ul>
    <?php } ?>
  </div>
</div>
