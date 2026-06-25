package com.quickorder.ms_productos.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductoDTO {
    @NotBlank(message = "Nombre obligatorio")
    private String nombre;

    @NotBlank(message = "Descripcion obligatoria")
    private String descripcion;

    @NotNull(message = "Precio obligatorio")
    @DecimalMin(value = "0.0")
    private BigDecimal precio;

    @NotBlank(message = "Categoria obligatoria")
    private String categoria;
}
