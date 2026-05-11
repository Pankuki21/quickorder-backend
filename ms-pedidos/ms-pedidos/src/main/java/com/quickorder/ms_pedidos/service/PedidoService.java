package com.quickorder.ms_pedidos.service;

import com.quickorder.ms_pedidos.dto.PedidoDTO;
import com.quickorder.ms_pedidos.model.Pedido;
import com.quickorder.ms_pedidos.repository.PedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@Slf4j
public class PedidoService {

    private final PedidoRepository repository;
    private final RestTemplate restTemplate;

    public PedidoService(PedidoRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }
    public List<Pedido> listar() {
        log.info("Listando pedidos");
        return repository.findAll();
    }
    public Pedido guardar(PedidoDTO dto) {
        restTemplate.getForObject("http://localhost:8081/clientes/" + dto.getClienteId(), Object.class);
        restTemplate.getForObject("http://localhost:8082/productos/" + dto.getProductoId(), Object.class);
        restTemplate.getForObject("http://localhost:8083/inventario/" + dto.getProductoId(), Object.class);

        Pedido pedido = new Pedido();
        pedido.setClienteId(dto.getClienteId());
        pedido.setProductoId(dto.getProductoId());
        pedido.setCantidad(dto.getCantidad());
        pedido.setTotal(dto.getTotal());
        pedido.setEstado("Confirmado");

        log.info("Guardando pedido");
        return repository.save(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
    public Pedido actualizar(Long id, PedidoDTO dto) {
        Pedido pedido = buscarPorId(id);
        pedido.setClienteId(dto.getClienteId());
        pedido.setProductoId(dto.getProductoId());
        pedido.setCantidad(dto.getCantidad());
        pedido.setTotal(dto.getTotal());

        log.info("Actualizando pedido");
        return repository.save(pedido);
    }
    public void eliminar(Long id) {
        Pedido pedido = buscarPorId(id);
        repository.delete(pedido);
        log.info("Eliminando pedido");
    }
}