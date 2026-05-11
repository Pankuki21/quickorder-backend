package com.quickorder.ms_usuarios.service;

import com.quickorder.ms_usuarios.dto.UsuarioDTO;
import com.quickorder.ms_usuarios.model.Usuario;
import com.quickorder.ms_usuarios.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    public List<Usuario> listar() {
        log.info("Listando usuarios");
        return repository.findAll();
    }
    public Usuario guardar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setRol(dto.getRol());
        usuario.setPassword(dto.getPassword());

        log.info("Guardando usuario");
        return repository.save(usuario);
    }
    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
    public Usuario actualizar(Long id, UsuarioDTO dto) {
        Usuario usuario = buscarPorId(id);
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setRol(dto.getRol());
        usuario.setPassword(dto.getPassword());

        log.info("Actualizando usuario");
        return repository.save(usuario);
    }
    public void eliminar(Long id) {
        Usuario usuario = buscarPorId(id);
        repository.delete(usuario);
        log.info("Eliminando usuario");
    }
}