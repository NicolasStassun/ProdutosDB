package com.produtos.produtos.controller;
import com.produtos.produtos.exeptions.*;
import com.produtos.produtos.model.entity.Fabricante;
import com.produtos.produtos.service.FabricanteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

    private final FabricanteService fabricanteService;

    @GetMapping()
    public ResponseEntity<List<Fabricante>> buscarTodos() {
        try {
            return new ResponseEntity<>(fabricanteService.buscarTodos(), HttpStatus.OK);
        } catch (ErroInternoExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> buscarUm(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(fabricanteService.buscarUm(id), HttpStatus.OK);
        } catch (FabricanteNaoEncontradoExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ErroInternoExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Fabricante> salvar(@RequestBody Fabricante fabricante) {
        try {
            return new ResponseEntity<>(fabricanteService.salvar(fabricante), HttpStatus.OK);
        } catch (FabricanteExistenteExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        fabricanteService.deletar(id);
    }

    @PutMapping
    public ResponseEntity<Fabricante> atualizar(@RequestBody Fabricante fabricanteNovo) {
        try {
            return new ResponseEntity<>(fabricanteService.editar(fabricanteNovo), HttpStatus.OK);
        } catch (DadosInvalidosExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
