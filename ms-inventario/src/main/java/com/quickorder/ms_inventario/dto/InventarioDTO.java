package com.quickorder.ms_inventario.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InventarioDTO {

    @NotNull(message = "Producto obligatorio")
    private Long productoId;

    @NotNull(message = "Stock obligatorio")
    @Min(value = 0)
    private Integer stock;

    @NotNull(message = "Ubicacion obligatoria")
    private String ubicacion;
}