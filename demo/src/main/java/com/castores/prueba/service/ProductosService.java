package com.castores.prueba.service;

import org.springframework.stereotype.Service;
import com.castores.prueba.model.Productos;
import com.castores.prueba.rerpository.ProductosRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {

    private final ProductosRepository productosRepository;

    public ProductosService(ProductosRepository productosRepository ) {
        this.productosRepository = productosRepository;
    }

    public List<Productos> finProductos() {
        return productosRepository.findAll();
    }

    public List<Productos> findByNombreProducto(String nombre){
        return productosRepository.findByNombreProducto(nombre);
    }

    List<Productos> findByEstatus(String estatus){
         return productosRepository.findByEstatus(estatus);
    }

    public Optional<Productos> findbyid(int id) {
        return productosRepository.findById(id);
    }

    public Productos saveProducto(Productos producto) {
        return productosRepository.save(producto);
    }

    public void deleteProducto(int id) {
        productosRepository.deleteById(id);
    }
}