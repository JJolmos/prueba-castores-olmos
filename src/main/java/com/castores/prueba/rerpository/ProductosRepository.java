package com.castores.prueba.rerpository;


import com.castores.prueba.model.Productos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    List<Productos> findByNombreProducto(String nombreProducto);
    List<Productos> findByEstatus(String estatus);
}