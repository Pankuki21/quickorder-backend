package com.quickorder.ms_productos.service;

import com.quickorder.ms_productos.dto.ProductoDTO;
import com.quickorder.ms_productos.model.Producto;
import com.quickorder.ms_productos.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ProductoService {
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }
    public List<Producto> listar() {
        log.info("Listando productos");
        return repository.findAll();
    }
    public Producto guardar(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setCategoria(dto.getCategoria());

        log.info("Guardando producto");
        return repository.save(producto);
    }
    public Producto buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
    public Producto actualizar(Long id, ProductoDTO dto) {
        Producto producto = buscarPorId(id);
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setCategoria(dto.getCategoria());

        log.info("Actualizando producto");
        return repository.save(producto);
    }

    public void eliminar(Long id) {
        Producto producto = buscarPorId(id);
        repository.delete(producto);
        log.info("Eliminando producto");
    }
}
