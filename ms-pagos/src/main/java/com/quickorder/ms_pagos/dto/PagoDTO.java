package com.quickorder.ms_pagos.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class PagoDTO {
    @NotNull(message = "Pedido obligatorio")
    private Long pedidoId;

    @NotNull(message = "Monto obligatorio")
    @DecimalMin(value = "0.0")
    private BigDecimal monto;
}