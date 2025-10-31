<?php
class Cita {
    public function getCitas() {
        return [
            [
                "id_cita"   => 10,
                "fecha_hora"=> "2025-10-30 09:00",
                "mascota"   => "Firulais",
                "dueno"     => "Juan Pérez",
                "doctor"    => "Dr. Carlos Veterinario",
                "motivo"    => "Vacuna anual",
                "estado"    => "PENDIENTE"
            ],
            [
                "id_cita"   => 11,
                "fecha_hora"=> "2025-10-31 15:30",
                "mascota"   => "Mishi",
                "dueno"     => "María López",
                "doctor"    => "Dr. Carlos Veterinario",
                "motivo"    => "Revisión general",
                "estado"    => "PENDIENTE"
            ],
            [
                "id_cita"   => 12,
                "fecha_hora"=> "2025-10-31 18:00",
                "mascota"   => "Bobby",
                "dueno"     => "Luis Chamba",
                "doctor"    => "Dr. Carlos Veterinario",
                "motivo"    => "Control post-cirugía",
                "estado"    => "ATENDIDA"
            ],
        ];
    }

    // listado de mascotas disponibles para agendar cita
    public function getMascotasParaCita() {
        return [
            [
                "id_mascota"      => 1,
                "nombre_mascota"  => "Firulais",
                "dueno"           => "Juan Pérez"
            ],
            [
                "id_mascota"      => 2,
                "nombre_mascota"  => "Mishi",
                "dueno"           => "María López"
            ],
            [
                "id_mascota"      => 3,
                "nombre_mascota"  => "Bobby",
                "dueno"           => "Luis Chamba"
            ],
        ];
    }
}
?>
