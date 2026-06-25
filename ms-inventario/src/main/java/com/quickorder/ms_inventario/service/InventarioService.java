package com.quickorder.ms_inventario.service;

import com.quickorder.ms_inventario.dto.InventarioDTO;
import com.quickorder.ms_inventario.model.Inventario;
import com.quickorder.ms_inventario.repository.InventarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@Slf4j
public class InventarioService {

    private final InventarioRepository repository;
    private final RestTemplate restTemplate;

    public InventarioService(InventarioRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public List<Inventario> listar() {
        log.info("Listando inventario");
        return repository.findAll();
    }
    public Inventario guardar(InventarioDTO dto) {
        restTemplate.getForObject("http://localhost:8082/productos/" + dto.getProductoId(), Object.class);
        Inventario inventario = new Inventario();
        inventario.setProductoId(dto.getProductoId());
        inventario.setStock(dto.getStock());
        inventario.setUbicacion(dto.getUbicacion());

        log.info("Guardando inventario");
        return repository.save(inventario);
    }
    public Inventario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }
    public Inventario actualizar(Long id, InventarioDTO dto) {
        Inventario inventario = buscarPorId(id);
        inventario.setProductoId(dto.getProductoId());
        inventario.setStock(dto.getStock());
        inventario.setUbicacion(dto.getUbicacion());

        log.info("Actualizando inventario");
        return repository.save(inventario);
    }

    public void eliminar(Long id) {
        Inventario inventario = buscarPorId(id);
        repository.delete(inventario);
        log.info("Eliminando inventario");
    }
}