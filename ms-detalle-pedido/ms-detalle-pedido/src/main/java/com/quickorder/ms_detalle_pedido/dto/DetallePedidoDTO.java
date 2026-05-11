package com.quickorder.ms_detalle_pedido.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetallePedidoDTO {

    @NotNull(message = "Pedido obligatorio")
    private Long pedidoId;

    @NotNull(message = "Producto obligatorio")
    private Long productoId;

    @NotNull(message = "Cantidad obligatoria")
    @Min(value = 1)
    private Integer cantidad;

    @NotNull(message = "Subtotal obligatorio")
    private BigDecimal subtotal;
}