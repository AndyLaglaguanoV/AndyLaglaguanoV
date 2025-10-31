<?php
class Usuario {
    private $usuarios = [
        [
            "id_usuario"      => 1,
            "username"        => "admin1",
            "password"        => "admin123",
            "nombre_completo" => "Administrador General",
            "rol"             => "ADMIN",
            "activo"          => 1
        ],
        [
            "id_usuario"      => 2,
            "username"        => "vet1",
            "password"        => "vet123",
            "nombre_completo" => "Dr. Carlos Veterinario",
            "rol"             => "VET",
            "activo"          => 1
        ],
        [
            "id_usuario"      => 3,
            "username"        => "recep1",
            "password"        => "recep123",
            "nombre_completo" => "Ana Recepción",
            "rol"             => "RECEP",
            "activo"          => 1
        ],
    ];

    public function autenticar($username, $password) {
        foreach ($this->usuarios as $u) {
            if ($u['username'] === $username &&
                $u['password'] === $password &&
                $u['activo'] == 1) {
                return $u;
            }
        }
        return null;
    }

    public function getAllUsers() {
        $out = [];
        foreach ($this->usuarios as $u) {
            $out[] = [
                "id_usuario"      => $u['id_usuario'],
                "username"        => $u['username'],
                "nombre_completo" => $u['nombre_completo'],
                "rol"             => $u['rol'],
                "activo"          => $u['activo'],
            ];
        }
        return $out;
    }
}
?>
