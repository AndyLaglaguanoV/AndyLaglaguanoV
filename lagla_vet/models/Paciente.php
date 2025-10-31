<?php
class Paciente {
    public function getPacientes() {
        return [
            [
                "id_mascota"     => 1,
                "nombre_mascota" => "Firulais",
                "especie"        => "Perro",
                "raza"           => "Criollo",
                "dueno"          => "Juan Pérez",
                "telefono"       => "0987654321"
            ],
            [
                "id_mascota"     => 2,
                "nombre_mascota" => "Mishi",
                "especie"        => "Gato",
                "raza"           => "Angora",
                "dueno"          => "María López",
                "telefono"       => "0912345678"
            ],
            [
                "id_mascota"     => 3,
                "nombre_mascota" => "Bobby",
                "especie"        => "Perro",
                "raza"           => "Golden",
                "dueno"          => "Luis Chamba",
                "telefono"       => "0999999999"
            ],
        ];
    }

    public function getFichaMascota($id_mascota) {
        // mock de historia clínica
        if ($id_mascota == 1) {
            return [
                "nombre_mascota" => "Firulais",
                "dueno"          => "Juan Pérez",
                "historial"      => [
                    ["fecha"=>"2025-10-15","detalle"=>"Vacuna parvovirus","doctor"=>"Dr. Carlos"],
                    ["fecha"=>"2025-10-30","detalle"=>"Vacuna anual","doctor"=>"Dr. Carlos"]
                ]
            ];
        }
        if ($id_mascota == 2) {
            return [
                "nombre_mascota" => "Mishi",
                "dueno"          => "María López",
                "historial"      => [
                    ["fecha"=>"2025-10-20","detalle"=>"Limpieza dental","doctor"=>"Dra. Andrea"]
                ]
            ];
        }
        return [
            "nombre_mascota" => "Desconocido",
            "dueno"          => "N/A",
            "historial"      => []
        ];
    }
}
?>
