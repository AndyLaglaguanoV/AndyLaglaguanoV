<h1 class="h4 mb-4">Panel general - Lagla Vet</h1>

<div class="row g-3">

  <div class="col-md-3">
    <div class="card border-0 shadow-sm">
      <div class="card-body">
        <div class="text-muted small">Citas registradas</div>
        <div class="fs-4 fw-bold"><?php echo $stats['citas_hoy']; ?></div>
        <a href="index.php?controller=cita&action=listar" class="small text-decoration-none">
            Ver agenda →
        </a>
      </div>
    </div>
  </div>

  <div class="col-md-3">
    <div class="card border-0 shadow-sm">
      <div class="card-body">
        <div class="text-muted small">Doctores disponibles</div>
        <div class="fs-4 fw-bold"><?php echo $stats['doctores_disponibles']; ?></div>
        <a href="index.php?controller=doctor&action=listar" class="small text-decoration-none">
            Ver doctores →
        </a>
      </div>
    </div>
  </div>

  <div class="col-md-3">
    <div class="card border-0 shadow-sm">
      <div class="card-body">
        <div class="text-muted small">Servicios / Cirugías</div>
        <div class="fs-4 fw-bold"><?php echo $stats['servicios_totales']; ?></div>
        <a href="index.php?controller=servicio&action=listar" class="small text-decoration-none">
            Ver lista →
        </a>
      </div>
    </div>
  </div>

  <div class="col-md-3">
    <div class="card border-0 shadow-sm">
      <div class="card-body">
        <div class="text-muted small">Stock bajo</div>
        <div class="fs-4 fw-bold text-danger"><?php echo $stats['productos_bajos']; ?></div>
        <a href="index.php?controller=tienda&action=catalogo" class="small text-decoration-none">
            Ver tienda →
        </a>
      </div>
    </div>
  </div>

</div>
