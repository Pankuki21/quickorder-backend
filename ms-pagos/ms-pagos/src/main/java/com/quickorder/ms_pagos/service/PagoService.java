package com.quickorder.ms_pagos.service;

import com.quickorder.ms_pagos.dto.PagoDTO;
import com.quickorder.ms_pagos.model.Pago;
import com.quickorder.ms_pagos.repository.PagoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@Slf4j
public class PagoService {

    private final PagoRepository repository;
    private final RestTemplate restTemplate;

    public PagoService(PagoRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }
    public List<Pago> listar() {
        log.info("Listando pagos");
        return repository.findAll();
    }
    public Pago guardar(PagoDTO dto) {
        restTemplate.getForObject("http://localhost:8085/pedidos/" + dto.getPedidoId(), Object.class);
        Pago pago = new Pago();
        pago.setPedidoId(dto.getPedidoId());
        pago.setMonto(dto.getMonto());
        pago.setEstado("APROBADO");

        log.info("Guardando pago");
        return repository.save(pago);
    }
    public Pago buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }
    public Pago actualizar(Long id, PagoDTO dto) {
        Pago pago = buscarPorId(id);
        pago.setPedidoId(dto.getPedidoId());
        pago.setMonto(dto.getMonto());

        log.info("Actualizando pago");
        return repository.save(pago);
    }
    public void eliminar(Long id) {
        Pago pago = buscarPorId(id);
        repository.delete(pago);
        log.info("Eliminando pago");
    }
}