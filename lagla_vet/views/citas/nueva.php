<h2 class="h5 mb-3">Agendar nueva cita</h2>

<div class="card shadow-sm bg-white p-3">
<form action="index.php?controller=cita&action=guardarNueva" method="POST">

  <div class="mb-3">
    <label class="form-label">Mascota</label>
    <select class="form-select" name="id_mascota" required>
      <?php foreach ($mascotas as $m) { ?>
        <option value="<?php echo $m['id_mascota']; ?>">
          <?php echo $m['nombre_mascota']; ?> (Dueño: <?php echo $m['dueno']; ?>)
        </option>
      <?php } ?>
    </select>
  </div>

  <div class="mb-3">
    <label class="form-label">Doctor disponible</label>
    <select class="form-select" name="id_doctor" required>
      <?php foreach ($doctores_disponibles as $d) { ?>
        <option value="<?php echo $d['id_doctor']; ?>">
          Dr. <?php echo $d['nombre_doctor']; ?> (<?php echo $d['especialidad']; ?>)
        </option>
      <?php } ?>
    </select>
  </div>

  <div class="mb-3">
    <label class="form-label">Fecha y hora</label>
    <input type="datetime-local" class="form-control" name="fecha_hora" required>
  </div>

  <div class="mb-3">
    <label class="form-label">Motivo</label>
    <input type="text" class="form-control" name="motivo" required
           placeholder="Vacuna, control post cirugía, etc.">
  </div>

  <button type="submit" class="btn btn-success">Guardar cita</button>
  <a href="index.php?controller=cita&action=listar" class="btn btn-secondary">Cancelar</a>

</form>
</div>
