package com.quickorder.ms_reclamos.service;

import com.quickorder.ms_reclamos.dto.ReclamoDTO;
import com.quickorder.ms_reclamos.model.Reclamo;
import com.quickorder.ms_reclamos.repository.ReclamoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@Slf4j
public class ReclamoService {

    private final ReclamoRepository repository;
    private final RestTemplate restTemplate;

    public ReclamoService(ReclamoRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }
    public List<Reclamo> listar() {
        log.info("Listando reclamos");
        return repository.findAll();
    }
    public Reclamo guardar(ReclamoDTO dto) {
        restTemplate.getForObject("http://localhost:8085/pedidos/" + dto.getPedidoId(), Object.class);
        Reclamo reclamo = new Reclamo();
        reclamo.setPedidoId(dto.getPedidoId());
        reclamo.setDescripcion(dto.getDescripcion());
        reclamo.setEstado("Abierto");
        log.info("Guardando reclamo");
        return repository.save(reclamo);
    }
    public Reclamo buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Reclamo no encontrado"));
    }
    public Reclamo actualizar(Long id, ReclamoDTO dto) {
        Reclamo reclamo = buscarPorId(id);
        reclamo.setPedidoId(dto.getPedidoId());
        reclamo.setDescripcion(dto.getDescripcion());
        log.info("Actualizando reclamo");
        return repository.save(reclamo);
    }
    public void eliminar(Long id) {
        Reclamo reclamo = buscarPorId(id);
        repository.delete(reclamo);
        log.info("Eliminando reclamo");
    }
}