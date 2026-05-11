package com.quickorder.ms_notificaciones.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private String estado;
}