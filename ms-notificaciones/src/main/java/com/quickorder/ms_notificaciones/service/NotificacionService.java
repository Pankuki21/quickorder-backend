package com.quickorder.ms_notificaciones.service;

import com.quickorder.ms_notificaciones.dto.NotificacionDTO;
import com.quickorder.ms_notificaciones.model.Notificacion;
import com.quickorder.ms_notificaciones.repository.NotificacionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@Slf4j
public class NotificacionService {

    private final NotificacionRepository repository;
    private final RestTemplate restTemplate;

    public NotificacionService(NotificacionRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }
    public List<Notificacion> listar() {
        log.info("Listando notificaciones");
        return repository.findAll();
    }
    public Notificacion guardar(NotificacionDTO dto) {
        restTemplate.getForObject("http://localhost:8081/clientes/" + dto.getClienteId(), Object.class);

        Notificacion notificacion = new Notificacion();
        notificacion.setClienteId(dto.getClienteId());
        notificacion.setMensaje(dto.getMensaje());
        notificacion.setEstado("Enviada");

        log.info("Guardando notificacion");
        return repository.save(notificacion);
    }
    public Notificacion buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Notificacion no encontrada"));
    }
    public Notificacion actualizar(Long id, NotificacionDTO dto) {
        Notificacion notificacion = buscarPorId(id);
        notificacion.setClienteId(dto.getClienteId());
        notificacion.setMensaje(dto.getMensaje());
        log.info("Actualizando notificacion");
        return repository.save(notificacion);
    }
    public void eliminar(Long id) {
        Notificacion notificacion = buscarPorId(id);
        repository.delete(notificacion);
        log.info("Eliminando notificacion");
    }
}