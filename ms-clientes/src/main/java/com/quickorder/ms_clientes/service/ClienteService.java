package com.quickorder.ms_clientes.service;

import com.quickorder.ms_clientes.dto.ClienteDTO;
import com.quickorder.ms_clientes.model.Cliente;
import com.quickorder.ms_clientes.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }
    public List<Cliente> listar() {
        log.info("Listando clientes");
        return repository.findAll();
    }
    public Cliente guardar(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setCorreo(dto.getCorreo());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());

        log.info("Guardando cliente");
        return repository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente actualizar(Long id, ClienteDTO dto) {
        Cliente cliente = buscarPorId(id);
        cliente.setNombre(dto.getNombre());
        cliente.setCorreo(dto.getCorreo());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());

        log.info("Actualizando cliente");
        return repository.save(cliente);
    }
    public void eliminar(Long id) {
        Cliente cliente = buscarPorId(id);
        repository.delete(cliente);
        log.info("Eliminando cliente");
    }
}
