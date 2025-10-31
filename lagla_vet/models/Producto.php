<?php
class Producto {
    public function getProductos() {
        return [
            [
                "id_producto"     => 101,
                "nombre_producto" => "Antipulgas NexGard 10-25kg",
                "categoria"       => "Medicamento",
                "stock"           => 12,
                "precio"          => 22.50
            ],
            [
                "id_producto"     => 102,
                "nombre_producto" => "Alimento Premium cachorro 2kg",
                "categoria"       => "Alimento",
                "stock"           => 5,
                "precio"          => 15.99
            ],
            [
                "id_producto"     => 103,
                "nombre_producto" => "Collar isabelino ajustable",
                "categoria"       => "Accesorio post-cirugía",
                "stock"           => 2,
                "precio"          => 8.00
            ],
        ];
    }

    public function getProductosBajoStock() {
        // criterio: stock <=3
        $low = [];
        foreach ($this->getProductos() as $p) {
            if ($p['stock'] <= 3) {
                $low[] = $p;
            }
        }
        return $low;
    }

    public function contarProductosBajoStock() {
        return count($this->getProductosBajoStock());
    }
}
?>
