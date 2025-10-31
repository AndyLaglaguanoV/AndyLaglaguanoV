<div class="row justify-content-center">
  <div class="col-md-4">

    <div class="card shadow-sm">
      <div class="card-header bg-primary text-white">
        <strong>Ingreso Lagla Vet</strong>
      </div>
      <div class="card-body">

        <?php if (!empty($error)) { ?>
          <div class="alert alert-danger">
            <?php echo htmlspecialchars($error); ?>
          </div>
        <?php } ?>

        <form action="index.php?controller=auth&action=doLogin" method="POST">
          <div class="mb-3">
            <label class="form-label">Usuario</label>
            <input type="text" class="form-control" name="username" required
                   placeholder="admin1 / vet1 / recep1">
          </div>

          <div class="mb-3">
            <label class="form-label">Contraseña</label>
            <input type="password" class="form-control" name="password" required
                   placeholder="admin123 / vet123 / recep123">
          </div>

          <button type="submit" class="btn btn-primary w-100">Entrar</button>
        </form>

      </div>
    </div>

  </div>
</div>
