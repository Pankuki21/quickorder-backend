package com.quickorder.ms_pagos.controller;

import com.quickorder.ms_pagos.dto.PagoDTO;
import com.quickorder.ms_pagos.model.Pago;
import com.quickorder.ms_pagos.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Pago>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    @PostMapping
    public ResponseEntity<Pago> guardar(@Valid @RequestBody PagoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pago> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(@PathVariable Long id, @Valid @RequestBody PagoDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}