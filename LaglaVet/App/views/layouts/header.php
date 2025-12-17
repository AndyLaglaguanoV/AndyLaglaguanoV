<?php
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}

/* ========= URL DE INICIO DINÁMICA ========= */
$homeUrl = "index.php?url=auth/login";

if (isset($_SESSION['user'])) {
    switch ($_SESSION['user']['rol']) {
        case 'administrador':
            $homeUrl = "index.php?url=admin/dashboard";
            break;
        case 'doctor':
            $homeUrl = "index.php?url=doctor/dashboard";
            break;
        case 'paciente':
            $homeUrl = "index.php?url=paciente/dashboard";
            break;
    }
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>LaglaVet</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        html, body {
            height: 100%;
        }
        body {
            display: flex;
            flex-direction: column;
            background-color: #f8f9fa;
        }
        main {
            flex: 1;
        }
        .navbar-brand {
            font-weight: bold;
            font-size: 1.3rem;
        }
    </style>
</head>
<body>

<!-- ================= NAVBAR ================= -->
<nav class="navbar navbar-expand-lg navbar-dark bg-success shadow-sm">
    <div class="container-fluid">

        <!-- LOGO -->
        <a class="navbar-brand" href="<?= $homeUrl ?>">
            🐾 LaglaVet
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="menu">

        <?php if (isset($_SESSION['user'])): ?>

            <!-- ===== MENÚ IZQUIERDO ===== -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <?php if ($_SESSION['user']['rol'] === 'administrador'): ?>
                    <li class="nav-item">
                        <a class="nav-link" href="index.php?url=admin/dashboard">
                            <i class="bi bi-speedometer2"></i> Dashboard
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.php?url=paciente/index">
                            <i class="bi bi-people"></i> Pacientes
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.php?url=doctor/index">
                            <i class="bi bi-person-badge"></i> Doctores
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.php?url=mascota/index">
                            <i class="bi bi-heart-pulse"></i> Mascotas
                        </a>
                    </li>
                <?php endif; ?>

                <?php if ($_SESSION['user']['rol'] === 'doctor'): ?>
                    <li class="nav-item">
                        <a class="nav-link" href="index.php?url=doctor/dashboard">
                            <i class="bi bi-speedometer2"></i> Dashboard
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.php?url=paciente/index">
                            <i class="bi bi-people"></i> Pacientes
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.php?url=mascota/index">
                            <i class="bi bi-heart-pulse"></i> Mascotas
                        </a>
                    </li>
                <?php endif; ?>

                <?php if ($_SESSION['user']['rol'] === 'paciente'): ?>
                    <li class="nav-item">
                        <a class="nav-link" href="index.php?url=paciente/dashboard">
                            <i class="bi bi-house"></i> Inicio
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.php?url=mascota/index">
                            <i class="bi bi-heart-pulse"></i> Mis Mascotas
                        </a>
                    </li>
                <?php endif; ?>

            </ul>

            <!-- ===== MENÚ DERECHO ===== -->
            <ul class="navbar-nav ms-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">
                        <i class="bi bi-person-circle"></i>
                        <?= htmlspecialchars($_SESSION['user']['nombre']) ?>
                    </a>

                    <ul class="dropdown-menu dropdown-menu-end">

                        <li>
                            <span class="dropdown-item-text text-muted">
                                Rol: <?= $_SESSION['user']['rol'] ?>
                            </span>
                        </li>

                        <!-- 👨‍⚕️ PERFIL DOCTOR -->
                        <?php if ($_SESSION['user']['rol'] === 'doctor'): ?>
                            <li>
                                <a class="dropdown-item" href="index.php?url=doctor/profile">
                                    <i class="bi bi-person-lines-fill"></i> Mi Perfil
                                </a>
                            </li>
                        <?php endif; ?>

                        <li><hr class="dropdown-divider"></li>

                        <li>
                            <a class="dropdown-item text-danger" href="index.php?url=auth/logout">
                                <i class="bi bi-box-arrow-right"></i> Cerrar sesión
                            </a>
                        </li>

                    </ul>
                </li>
            </ul>

        <?php else: ?>

            <!-- SIN SESIÓN -->
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.php?url=auth/login">
                        <i class="bi bi-box-arrow-in-right"></i> Iniciar sesión
                    </a>
                </li>
            </ul>

        <?php endif; ?>

        </div>
    </div>
</nav>

<!-- ===== CONTENIDO ===== -->
<main class="container my-4">
