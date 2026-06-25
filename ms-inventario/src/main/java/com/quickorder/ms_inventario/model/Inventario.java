package com.quickorder.ms_inventario.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "producto_id", nullable = false)
    private Long productoId;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private String ubicacion;
}