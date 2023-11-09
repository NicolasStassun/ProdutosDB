package com.produtos.produtos.exeptions;

public class ErroInternoExeption extends RuntimeException{
    public ErroInternoExeption(String message) {
        super("Erro interno no servidor");
    }
}
