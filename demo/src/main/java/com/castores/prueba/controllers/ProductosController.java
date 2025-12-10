package com.castores.prueba.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.castores.prueba.model.Productos;
import com.castores.prueba.service.ProductosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public List<Productos> getAllProductoss() {
        return productosService.finProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> getProductosById(@PathVariable int id) {
        Optional<Productos> producto = productosService.findbyid(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Productos createProductos(@RequestBody Productos producto) {
        List <Productos> productoexistente = productosService.findByNombreProducto(producto.getNombreProducto());
        if (!productoexistente.isEmpty() && productoexistente.get(0).getEstatus() == 0) {
            productoexistente.get(0).setEstatus(1);
             return productosService.saveProducto(productoexistente.get(0));
        } else{
             return productosService.saveProducto(producto);
        }
          
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> updateProductos(@PathVariable int id, @RequestBody Productos productoDetails) {
        Optional<Productos> userOptional = productosService.findbyid(id);

        if (userOptional.isPresent()) {
            Productos producto = userOptional.get();
            producto.setCantidad(productoDetails.getCantidad());
            producto.setEstatus(productoDetails.getEstatus());
            producto.setId(productoDetails.getId());
            producto.setNombreProducto(productoDetails.getNombreProducto());
            producto.setPrecio(productoDetails.getPrecio());
            final Productos updatedProductos = productosService.saveProducto(producto);
            return ResponseEntity.ok(updatedProductos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Productos> deleteProductos(@PathVariable String nombre) {
        List<Productos> producto = productosService.findByNombreProducto(nombre);
        if (!producto.isEmpty()) {
            producto.get(0).setEstatus(0);
            productosService.saveProducto(producto.get(0));
            return ResponseEntity.ok(producto.get(0));
        } else {
            return ResponseEntity.noContent().build();
        }

    }
}