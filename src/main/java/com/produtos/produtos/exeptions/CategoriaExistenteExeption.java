package com.produtos.produtos.exeptions;

public class CategoriaExistenteExeption extends RuntimeException{

    public CategoriaExistenteExeption(String message) {
        super("Categoria já existe");
    }
}
