package com.produtos.produtos.controller;
import com.produtos.produtos.exeptions.DadosInvalidosExeption;
import com.produtos.produtos.exeptions.ErroInternoExeption;
import com.produtos.produtos.exeptions.ProdutoExitenteExeption;
import com.produtos.produtos.exeptions.ProdutoNaoEncontradoExeption;
import com.produtos.produtos.model.entity.Produto;
import com.produtos.produtos.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")

public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<List<Produto>>  buscarTodos() {
        try {
            return new ResponseEntity<>(produtoService.buscarTodos(), HttpStatus.OK);
        }catch (ErroInternoExeption e){
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> bucarUm(@PathVariable Long id) {
        try {
            return new ResponseEntity<>( produtoService.buscarUm(id), HttpStatus.OK);
        }catch (ProdutoNaoEncontradoExeption e){
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (ErroInternoExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping()
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        try {
            return new ResponseEntity<>(produtoService.salvar(produto), HttpStatus.OK);
        }catch (ProdutoExitenteExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }
    @PutMapping
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produtoNovo){
        try {
            return new ResponseEntity<>(produtoService.editar(produtoNovo), HttpStatus.OK);
        }catch (DadosInvalidosExeption e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
