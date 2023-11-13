package com.produtos.produtos.exeptions;

public class CategoriaNaoEncontradaExeption extends RuntimeException {

    public CategoriaNaoEncontradaExeption(String message) {
        super("Categoria não encontrada");
    }
}
