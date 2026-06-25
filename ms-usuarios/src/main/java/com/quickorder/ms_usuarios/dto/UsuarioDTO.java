package com.quickorder.ms_usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioDTO {

    @NotBlank(message = "Nombre obligatorio")
    private String nombre;

    @Email(message = "Correo invalido")
    @NotBlank(message = "Correo obligatorio")
    private String correo;

    @NotBlank(message = "Rol obligatorio")
    private String rol;

    @NotBlank(message = "Password obligatorio")
    private String password;
}