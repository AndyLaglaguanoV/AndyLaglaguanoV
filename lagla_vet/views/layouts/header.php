<?php if (session_status() === PHP_SESSION_NONE) { session_start(); } ?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lagla Vet</title>

    <link rel="stylesheet" href="public/assets/bootstrap.min.css">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
  <div class="container-fluid">
    <a class="navbar-brand fw-bold" href="index.php?controller=dashboard&action=home">
      🐾 Lagla Vet
    </a>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNav">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="mainNav">
      <?php if (isset($_SESSION['rol'])) { ?>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">

        <li class="nav-item">
          <a class="nav-link" href="index.php?controller=cita&action=listar">Citas</a>
        </li>

        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#">Doctores</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="index.php?controller=doctor&action=listar">Lista de doctores</a></li>
            <li><a class="dropdown-item" href="index.php?controller=doctor&action=disponibilidad">Disponibilidad</a></li>
          </ul>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="index.php?controller=servicio&action=listar">Servicios / Cirugías</a>
        </li>

        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#">Tienda</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="index.php?controller=tienda&action=catalogo">Catálogo</a></li>
            <li><a class="dropdown-item" href="index.php?controller=tienda&action=carrito">Carrito</a></li>
          </ul>
        </li>

        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#">Pacientes</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="index.php?controller=paciente&action=listar">Dueños y Mascotas</a></li>
          </ul>
        </li>

      </ul>

      <div class="d-flex align-items-center text-white">
        <div class="me-3 small">
          <div class="fw-semibold">
            <?php echo htmlspecialchars($_SESSION['nombre'] ?? ''); ?>
          </div>
          <div class="text-capitalize">
            Rol: <?php echo htmlspecialchars(strtolower($_SESSION['rol'] ?? '')); ?>
          </div>
        </div>
        <a class="btn btn-sm btn-outline-light" href="index.php?controller=auth&action=logout">Cerrar sesión</a>
      </div>
      <?php } ?>
    </div>
  </div>
</nav>

<div class="container mb-5">
