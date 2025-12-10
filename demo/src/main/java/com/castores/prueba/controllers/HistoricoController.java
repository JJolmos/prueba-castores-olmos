package com.castores.prueba.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.castores.prueba.model.Historico;
import com.castores.prueba.model.HistoricoDTO;
import com.castores.prueba.service.HistoricoService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    private final HistoricoService historicoService;

    public HistoricoController(HistoricoService historicoService) {
        this.historicoService = historicoService;
    }

    @GetMapping
    public List<Historico> getAllHistoricos() {
        return historicoService.finHistorico();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Historico> getHistoricoById(@PathVariable int id) {
        Optional<Historico> historico = historicoService.findbyid(id);
        return historico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Historico createHistorico(@RequestBody HistoricoDTO historico) {
        return historicoService.saveUsuario(historico);
    }



}