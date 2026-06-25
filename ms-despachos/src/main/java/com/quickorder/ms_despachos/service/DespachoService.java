package com.quickorder.ms_despachos.service;

import com.quickorder.ms_despachos.dto.DespachoDTO;
import com.quickorder.ms_despachos.model.Despacho;
import com.quickorder.ms_despachos.repository.DespachoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@Slf4j
public class DespachoService {

    private final DespachoRepository repository;
    private final RestTemplate restTemplate;

    public DespachoService(DespachoRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }
    public List<Despacho> listar() {
        log.info("Listando despachos");
        return repository.findAll();
    }
    public Despacho guardar(DespachoDTO dto) {
        restTemplate.getForObject("http://localhost:8085/pedidos/" + dto.getPedidoId(), Object.class);
        restTemplate.getForObject("http://localhost:8087/pagos/" + dto.getPedidoId(), Object.class);

        Despacho despacho = new Despacho();
        despacho.setPedidoId(dto.getPedidoId());
        despacho.setDireccion(dto.getDireccion());
        despacho.setEstado("Enviado");

        log.info("Guardando despacho");
        return repository.save(despacho);
    }
    public Despacho buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Despacho no encontrado"));
    }
    public Despacho actualizar(Long id, DespachoDTO dto) {
        Despacho despacho = buscarPorId(id);
        despacho.setPedidoId(dto.getPedidoId());
        despacho.setDireccion(dto.getDireccion());

        log.info("Actualizando despacho");
        return repository.save(despacho);
    }

    public void eliminar(Long id) {
        Despacho despacho = buscarPorId(id);
        repository.delete(despacho);
        log.info("Eliminando despacho");
    }
}