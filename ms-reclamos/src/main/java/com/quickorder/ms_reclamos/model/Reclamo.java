package com.quickorder.ms_reclamos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_id", nullable = false)
    private Long pedidoId;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String estado;
}