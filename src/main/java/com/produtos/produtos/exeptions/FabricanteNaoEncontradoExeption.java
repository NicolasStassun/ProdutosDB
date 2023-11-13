package com.produtos.produtos.exeptions;

public class FabricanteNaoEncontradoExeption extends RuntimeException{

    public FabricanteNaoEncontradoExeption(String message) {
        super("Fabricante não encontrado");
    }

}
