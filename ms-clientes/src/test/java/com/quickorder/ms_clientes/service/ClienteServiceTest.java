package com.quickorder.ms_clientes.service;

import com.quickorder.ms_clientes.model.Cliente;
import com.quickorder.ms_clientes.dto.ClienteDTO;
import com.quickorder.ms_clientes.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService service;

    @Test
    void listarDebeRetornarClientes() {

        Cliente cliente = new Cliente();
        cliente.setNombre("Juan Perez");

        when(repository.findAll())
                .thenReturn(List.of(cliente));

        List<Cliente> resultado = service.listar();

        assertEquals(1, resultado.size());
        assertEquals("Juan Perez", resultado.get(0).getNombre());
    }

    @Test
    void buscarPorIdDebeRetornarCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Juan");

        when(repository.findById(1L))
                .thenReturn(Optional.of(cliente));

        Cliente resultado = service.buscarPorId(1L);

        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    void guardarDebeCrearCliente() {
        ClienteDTO dto = new ClienteDTO();
        dto.setNombre("Juan");
        dto.setCorreo("juan@test.cl");
        dto.setTelefono("123456");
        dto.setDireccion("Santiago");

        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");

        when(repository.save(any(Cliente.class)))
                .thenReturn(cliente);

        Cliente resultado = service.guardar(dto);

        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    void eliminarDebeEliminarCliente() {

        Cliente cliente = new Cliente();
        cliente.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(cliente));

        service.eliminar(1L);

        verify(repository).delete(cliente);
    }
}