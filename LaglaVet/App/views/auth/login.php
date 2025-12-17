<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<div class="row justify-content-center">
    <div class="col-md-5">
        <div class="card shadow">
            <div class="card-header bg-success text-white text-center">
                <h4>🐾 LaglaVet</h4>
                <small>Sistema Veterinario</small>
            </div>

            <div class="card-body">
                <form method="POST" action="index.php?url=auth/doLogin">
                    <div class="mb-3">
                        <label class="form-label">Correo</label>
                        <input type="email" name="email" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Contraseña</label>
                        <input type="password" name="password" class="form-control" required>
                    </div>

                    <button class="btn btn-success w-100">
                        <i class="bi bi-box-arrow-in-right"></i> Ingresar
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
