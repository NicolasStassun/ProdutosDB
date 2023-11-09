package com.produtos.produtos.exeptions;

public class ProdutoNaoEncontradoExeption extends RuntimeException{
    public ProdutoNaoEncontradoExeption(String message) {
        super("Produto não encontrado");
    }
}
