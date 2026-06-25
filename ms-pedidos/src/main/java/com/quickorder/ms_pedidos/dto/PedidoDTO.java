package com.quickorder.ms_pedidos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class PedidoDTO {

    @NotNull(message = "Cliente obligatorio")
    private Long clienteId;

    @NotNull(message = "Producto obligatorio")
    private Long productoId;

    @NotNull(message = "Cantidad obligatoria")
    @Min(value = 1)
    private Integer cantidad;

    @NotNull(message = "Total obligatorio")
    private BigDecimal total;
}