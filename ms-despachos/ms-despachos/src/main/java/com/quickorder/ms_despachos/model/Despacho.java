package com.quickorder.ms_despachos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Despacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_id", nullable = false)
    private Long pedidoId;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String estado;
}