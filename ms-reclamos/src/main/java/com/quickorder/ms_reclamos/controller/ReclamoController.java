package com.quickorder.ms_reclamos.controller;

import com.quickorder.ms_reclamos.dto.ReclamoDTO;
import com.quickorder.ms_reclamos.model.Reclamo;
import com.quickorder.ms_reclamos.service.ReclamoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {

    private final ReclamoService service;

    public ReclamoController(ReclamoService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Reclamo>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    @PostMapping
    public ResponseEntity<Reclamo> guardar(@Valid @RequestBody ReclamoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reclamo> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reclamo> actualizar(@PathVariable Long id, @Valid @RequestBody ReclamoDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}