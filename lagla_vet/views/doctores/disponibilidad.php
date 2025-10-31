<h2 class="h5 mb-3">Disponibilidad de doctores</h2>

<div class="row g-3">
  <div class="col-md-6">
    <div class="card shadow-sm">
      <div class="card-header bg-primary text-white">
        Doctores disponibles ahora
      </div>
      <div class="card-body">
        <?php if (count($disponibles) === 0) { ?>
          <div class="text-muted">Ningún doctor marcado como disponible.</div>
        <?php } else { ?>
          <ul class="list-group">
          <?php foreach ($disponibles as $d) { ?>
            <li class="list-group-item">
              <strong><?php echo $d['nombre_doctor']; ?></strong><br>
              <small><?php echo $d['especialidad']; ?></small>
            </li>
          <?php } ?>
          </ul>
        <?php } ?>
      </div>
    </div>
  </div>

  <div class="col-md-6">
    <div class="card shadow-sm">
      <div class="card-header bg-light">
        Todos los doctores
      </div>
      <div class="card-body p-0">
        <table class="table mb-0 table-sm align-middle">
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Especialidad</th>
              <th>Disponible</th>
            </tr>
          </thead>
          <tbody>
          <?php foreach ($doctores as $d) { ?>
            <tr>
              <td><?php echo htmlspecialchars($d['nombre_doctor']); ?></td>
              <td><?php echo htmlspecialchars($d['especialidad']); ?></td>
              <td><?php echo $d['disponible'] ? '✅' : '❌'; ?></td>
            </tr>
          <?php } ?>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
