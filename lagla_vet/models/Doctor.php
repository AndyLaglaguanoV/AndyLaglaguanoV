<?php
class Doctor {
    public function getDoctores() {
        return [
            [
                "id_doctor"     => 2,
                "nombre_doctor" => "Dr. Carlos Veterinario",
                "especialidad"  => "Cirugía y vacunas",
                "disponible"    => true
            ],
            [
                "id_doctor"     => 4,
                "nombre_doctor" => "Dra. Andrea Salas",
                "especialidad"  => "Odontología felina",
                "disponible"    => false
            ],
        ];
    }

    // para agendar cita solo queremos los disponibles
    public function getDoctoresDisponibles() {
        return [
            [
                "id_doctor"     => 2,
                "nombre_doctor" => "Dr. Carlos Veterinario",
                "especialidad"  => "Cirugía y vacunas",
            ],
        ];
    }

    public function contarDisponibles() {
        $count = 0;
        foreach ($this->getDoctores() as $d) {
            if ($d['disponible']) $count++;
        }
        return $count;
    }
}
?>
