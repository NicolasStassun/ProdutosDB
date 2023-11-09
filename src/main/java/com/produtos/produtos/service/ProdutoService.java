package com.produtos.produtos.service;

import com.produtos.produtos.model.entity.Produto;
import com.produtos.produtos.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProdutoService {

    ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }
    public Produto buscarUm(Long id) {
        return produtoRepository.findById(id).get();
    }
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
    public Produto editar(Produto produto) {
        return produtoRepository.save(produto);
    }
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

}
