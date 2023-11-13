package com.produtos.produtos.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class ProdutoIdClass implements Serializable {

    private Long idProduto;
    private Long idCategoria;
    private Long idFabricante;
}
