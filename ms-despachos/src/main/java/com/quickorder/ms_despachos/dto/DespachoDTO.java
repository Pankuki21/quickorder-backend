package com.quickorder.ms_despachos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DespachoDTO {

    @NotNull(message = "Pedido obligatorio")
    private Long pedidoId;

    @NotBlank(message = "Direccion obligatoria")
    private String direccion;
}