package com.produtos.produtos.exeptions;

public class ProdutoExitenteExeption extends RuntimeException {
    public ProdutoExitenteExeption(String message) {
        super("Produto já existe no estoque");
    }
}
