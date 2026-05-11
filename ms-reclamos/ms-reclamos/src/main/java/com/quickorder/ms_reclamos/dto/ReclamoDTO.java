package com.quickorder.ms_reclamos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReclamoDTO {

    @NotNull(message = "Pedido obligatorio")
    private Long pedidoId;

    @NotBlank(message = "Descripcion obligatoria")
    private String descripcion;
}