<?php
class Servicio {
    public function getServicios() {
        return [
            [
                "nombre_servicio"     => "Esterilización (perro)",
                "categoria"           => "Cirugía",
                "doctor_responsable"  => "Dr. Carlos Veterinario",
                "precio"              => 120.00,
                "duracion_estim"      => "45 min"
            ],
            [
                "nombre_servicio"     => "Limpieza dental felina",
                "categoria"           => "Odontología",
                "doctor_responsable"  => "Dra. Andrea Salas",
                "precio"              => 60.00,
                "duracion_estim"      => "30 min"
            ],
            [
                "nombre_servicio"     => "Vacuna antirrábica",
                "categoria"           => "Vacunación",
                "doctor_responsable"  => "Dr. Carlos Veterinario",
                "precio"              => 18.00,
                "duracion_estim"      => "10 min"
            ],
        ];
    }

    public function contarServicios() {
        return count($this->getServicios());
    }
}
?>
