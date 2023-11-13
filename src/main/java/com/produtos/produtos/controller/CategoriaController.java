package com.produtos.produtos.controller;
import com.produtos.produtos.exeptions.CategoriaExistenteExeption;
import com.produtos.produtos.exeptions.CategoriaNaoEncontradaExeption;
import com.produtos.produtos.exeptions.DadosInvalidosExeption;
import com.produtos.produtos.exeptions.ErroInternoExeption;
import com.produtos.produtos.model.entity.Categoria;
import com.produtos.produtos.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<List<Categoria>> buscarTodos() {
        try {
            return new ResponseEntity<>(categoriaService.buscarTodos(), HttpStatus.OK);
        } catch (ErroInternoExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarUm(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(categoriaService.buscarUm(id), HttpStatus.OK);
        } catch (CategoriaNaoEncontradaExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ErroInternoExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
        try {
            return new ResponseEntity<>(categoriaService.salvar(categoria), HttpStatus.OK);
        } catch (CategoriaExistenteExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
    }

    @PutMapping
    public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoriaNova) {
        try {
            return new ResponseEntity<>(categoriaService.editar(categoriaNova), HttpStatus.OK);
        } catch (DadosInvalidosExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
