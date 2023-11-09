package com.produtos.produtos.exeptions;

public class DadosInvalidosExeption extends RuntimeException{
    public DadosInvalidosExeption(String message) {
        super("Dados invalidos ou falta de informação");
    }
}
