<h2 class="h5 mb-3">Tienda / Inventario</h2>

<div class="row g-3">
<?php foreach ($productos as $p) { ?>
  <div class="col-md-4">
    <div class="card h-100 shadow-sm">
      <div class="card-body">
        <h5 class="card-title"><?php echo htmlspecialchars($p['nombre_producto']); ?></h5>
        <p class="card-text small text-muted">
          Tipo: <?php echo htmlspecialchars($p['categoria']); ?><br>
          Stock: <?php echo $p['stock']; ?> unidad(es)
        </p>
        <div class="fw-bold mb-2">$<?php echo number_format($p['precio'], 2); ?></div>
        <a href="index.php?controller=tienda&action=agregarCarrito&id=<?php echo $p['id_producto']; ?>"
           class="btn btn-sm btn-primary w-100">
          Agregar al carrito
        </a>
      </div>
    </div>
  </div>
<?php } ?>
</div>
