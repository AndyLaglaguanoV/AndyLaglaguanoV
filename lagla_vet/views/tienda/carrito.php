<h2 class="h5 mb-3">Carrito</h2>

<?php if (empty($items)) { ?>
    <div class="alert alert-info">No hay productos en el carrito todavía.</div>
<?php } else { ?>
    <table class="table table-striped table-sm align-middle bg-white shadow-sm">
        <thead class="table-primary">
            <tr>
                <th>Producto</th>
                <th>Cant.</th>
                <th>Precio U.</th>
                <th>Total</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($items as $it) { ?>
            <tr>
                <td><?php echo htmlspecialchars($it['nombre']); ?></td>
                <td><?php echo $it['cantidad']; ?></td>
                <td><?php echo $it['precio']; ?></td>
                <td><?php echo $it['total']; ?></td>
            </tr>
            <?php } ?>
        </tbody>
    </table>
<?php } ?>
