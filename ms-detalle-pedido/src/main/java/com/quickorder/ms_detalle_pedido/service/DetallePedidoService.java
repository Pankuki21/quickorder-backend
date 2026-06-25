package com.quickorder.ms_detalle_pedido.service;

import com.quickorder.ms_detalle_pedido.dto.DetallePedidoDTO;
import com.quickorder.ms_detalle_pedido.model.DetallePedido;
import com.quickorder.ms_detalle_pedido.repository.DetallePedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@Slf4j
public class DetallePedidoService {
    private final DetallePedidoRepository repository;
    private final RestTemplate restTemplate;

    public DetallePedidoService(DetallePedidoRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }
    public List<DetallePedido> listar() {
        log.info("Listando detalle pedido");
        return repository.findAll();
    }
    public DetallePedido guardar(DetallePedidoDTO dto) {
        restTemplate.getForObject("http://localhost:8085/pedidos/" + dto.getPedidoId(), Object.class);
        restTemplate.getForObject("http://localhost:8082/productos/" + dto.getProductoId(), Object.class);

        DetallePedido detalle = new DetallePedido();
        detalle.setPedidoId(dto.getPedidoId());
        detalle.setProductoId(dto.getProductoId());
        detalle.setCantidad(dto.getCantidad());
        detalle.setSubtotal(dto.getSubtotal());

        log.info("Guardando detalle pedido");
        return repository.save(detalle);
    }
    public DetallePedido buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Detalle pedido no encontrado"));
    }
    public DetallePedido actualizar(Long id, DetallePedidoDTO dto) {
        DetallePedido detalle = buscarPorId(id);
        detalle.setPedidoId(dto.getPedidoId());
        detalle.setProductoId(dto.getProductoId());
        detalle.setCantidad(dto.getCantidad());
        detalle.setSubtotal(dto.getSubtotal());

        log.info("Actualizando detalle pedido");
        return repository.save(detalle);
    }
    public void eliminar(Long id) {
        DetallePedido detalle = buscarPorId(id);
        repository.delete(detalle);
        log.info("Eliminando detalle pedido");
    }
}
