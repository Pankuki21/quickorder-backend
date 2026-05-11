package com.quickorder.ms_detalle_pedido.controller;

import com.quickorder.ms_detalle_pedido.dto.DetallePedidoDTO;
import com.quickorder.ms_detalle_pedido.model.DetallePedido;
import com.quickorder.ms_detalle_pedido.service.DetallePedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/detallepedido")
public class DetallePedidoController {
    private final DetallePedidoService service;

    public DetallePedidoController(DetallePedidoService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<DetallePedido>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    @PostMapping
    public ResponseEntity<DetallePedido> guardar(@Valid @RequestBody DetallePedidoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> actualizar(@PathVariable Long id, @Valid @RequestBody DetallePedidoDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
