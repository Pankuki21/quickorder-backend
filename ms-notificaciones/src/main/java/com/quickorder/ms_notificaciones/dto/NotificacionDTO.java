package com.quickorder.ms_notificaciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificacionDTO {

    @NotNull(message = "Cliente obligatorio")
    private Long clienteId;

    @NotBlank(message = "Mensaje obligatorio")
    private String mensaje;
}
