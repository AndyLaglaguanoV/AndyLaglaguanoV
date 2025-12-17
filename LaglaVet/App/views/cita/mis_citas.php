<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<div class="container mt-4">
    <h3 class="mb-3">📅 Mis Citas</h3>

    <?php if (empty($citas)): ?>
        <div class="alert alert-info">
            No tienes citas registradas.
        </div>
    <?php else: ?>
        <div class="card shadow-sm">
            <div class="card-body p-0">
                <table class="table table-hover mb-0">
                    <thead class="table-success">
                        <tr>
                            <th>Mascota</th>
                            <th>Doctor</th>
                            <th>Fecha</th>
                            <th>Motivo</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach ($citas as $c): ?>
                            <tr>
                                <td><?= htmlspecialchars($c['mascota']) ?></td>
                                <td><?= htmlspecialchars($c['doctor']) ?></td>
                                <td><?= date('d/m/Y H:i', strtotime($c['fecha'])) ?></td>
                                <td><?= htmlspecialchars($c['motivo']) ?></td>
                                <td>
                                    <span class="badge 
                                        <?= $c['estado'] === 'pendiente' ? 'bg-warning' : 'bg-success' ?>">
                                        <?= ucfirst($c['estado']) ?>
                                    </span>
                                </td>
                            </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>
            </div>
        </div>
    <?php endif; ?>

    <a href="index.php?url=paciente/dashboard" class="btn btn-link mt-3">
        ← Volver
    </a>
</div>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
