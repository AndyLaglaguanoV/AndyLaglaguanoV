<?php require_once __DIR__ . '/../layouts/header.php'; ?>

<h3 class="mb-4">Gestión de Pacientes</h3>

<!-- ===== TABS ===== -->
<ul class="nav nav-tabs mb-4">
  <li class="nav-item">
    <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#nuevo">
      Crear paciente nuevo
    </button>
  </li>
  <li class="nav-item">
    <button class="nav-link" data-bs-toggle="tab" data-bs-target="#buscar">
      Buscar paciente existente
    </button>
  </li>
</ul>

<div class="tab-content">

<!-- ======================================================
     TAB 1: CREAR PACIENTE NUEVO
     ====================================================== -->
<div class="tab-pane fade show active" id="nuevo">

<form method="POST"
      action="index.php?url=paciente/storeNuevo"
      class="card shadow p-4 needs-validation"
      novalidate>

  <h5 class="text-success mb-3">Datos del Usuario</h5>

  <div class="mb-3">
    <label class="form-label">Nombre completo</label>
    <input name="nombre" class="form-control" required>
    <div class="invalid-feedback">El nombre es obligatorio</div>
  </div>

  <div class="mb-3">
    <label class="form-label">Correo electrónico</label>
    <input name="email" type="email" class="form-control" required>
    <div class="invalid-feedback">Correo válido obligatorio</div>
  </div>

  <div class="mb-3">
    <label class="form-label">Contraseña</label>
    <input name="password" type="password" class="form-control" required>
    <div class="invalid-feedback">Contraseña obligatoria</div>
  </div>

  <hr>

  <h5 class="text-success mb-3">Datos del Paciente</h5>

  <div class="mb-3">
    <label class="form-label">Cédula</label>
    <input name="cedula" class="form-control" required>
  </div>

  <div class="mb-3">
    <label class="form-label">Teléfono</label>
    <input name="telefono" class="form-control">
  </div>

  <div class="mb-3">
    <label class="form-label">Dirección</label>
    <input name="direccion" class="form-control">
  </div>

  <button class="btn btn-success w-100">
    <i class="bi bi-person-plus"></i> Crear paciente
  </button>

</form>
</div>

<!-- ======================================================
     TAB 2: BUSCAR Y EDITAR PACIENTE
     ====================================================== -->
<div class="tab-pane fade" id="buscar">

  <div class="card shadow p-4">
    <div class="mb-3 position-relative">
      <label class="form-label">Buscar paciente por nombre</label>

      <input type="text"
             id="buscarPaciente"
             class="form-control"
             placeholder="Escribe al menos 2 letras"
             autocomplete="off">

      <div id="listaPacientes"
           class="list-group position-absolute w-100"
           style="z-index:1000;"></div>
    </div>

    <div class="alert alert-info mb-0">
      Selecciona un paciente de la lista para editar sus datos.
    </div>
  </div>

</div>
</div>

<!-- ======================================================
     VALIDACIÓN BOOTSTRAP + BUSCADOR
     ====================================================== -->
<script>
/* ===== VALIDACIÓN ===== */
(() => {
  const forms = document.querySelectorAll('.needs-validation');
  forms.forEach(form => {
    form.addEventListener('submit', e => {
      if (!form.checkValidity()) {
        e.preventDefault();
        e.stopPropagation();
      }
      form.classList.add('was-validated');
    });
  });
})();

/* ===== BUSCAR Y EDITAR ===== */
const input = document.getElementById('buscarPaciente');
const lista = document.getElementById('listaPacientes');

input?.addEventListener('input', () => {
  if (input.value.length < 2) {
    lista.innerHTML = '';
    return;
  }

  fetch(`index.php?url=paciente/search&term=${input.value}`)
    .then(r => r.json())
    .then(data => {
      lista.innerHTML = '';

      if (data.length === 0) {
        lista.innerHTML =
          `<div class="list-group-item">No encontrado</div>`;
        return;
      }

      data.forEach(p => {
        const btn = document.createElement('button');
        btn.type = 'button';
        btn.className = 'list-group-item list-group-item-action';
        btn.textContent = p.nombre;

        btn.onclick = () => {
          window.location.href =
            `index.php?url=paciente/edit&id=${p.id}`;
        };

        lista.appendChild(btn);
      });
    });
});
</script>

<?php require_once __DIR__ . '/../layouts/footer.php'; ?>
