package com.castores.prueba.service;

import org.springframework.stereotype.Service;
import com.castores.prueba.model.Historico;
import com.castores.prueba.model.HistoricoDTO;
import com.castores.prueba.model.Productos;
import com.castores.prueba.rerpository.HistoricoRepository;
import com.castores.prueba.rerpository.ProductosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;
    private final ProductosRepository productosRepository;

    public HistoricoService(HistoricoRepository historicoRepository, ProductosRepository productosRepository) {
        this.historicoRepository = historicoRepository;
        this.productosRepository =  productosRepository;
    }

    public List<Historico> finHistorico() {
        return historicoRepository.findAll();
    }

    public Optional<Historico> findbyid(int id) {
        return historicoRepository.findById(id);
    }

    public Historico saveUsuario(HistoricoDTO historicodto) {
       Productos Producto = productosRepository.getReferenceById(historicodto.getIdProducto());
       Historico historico = new Historico( historicodto.getTipoMovimiento(), historicodto.getCantidad(), historicodto.getUsuarioMovimiento(), Producto );
        return historicoRepository.save(historico);
    }

}