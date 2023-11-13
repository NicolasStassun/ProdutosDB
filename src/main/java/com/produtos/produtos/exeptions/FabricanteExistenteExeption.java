package com.produtos.produtos.exeptions;

public class FabricanteExistenteExeption extends RuntimeException {

    public FabricanteExistenteExeption(String message) {
        super("Fabricante já existe");
    }
}
