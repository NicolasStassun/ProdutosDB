package com.produtos.produtos.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto")
@IdClass(ProdutoIdClass.class)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private ProdutoIdClass id;
    @Column(nullable = false, unique = true)
    private String nome;
    @Positive
    private Double preco;
    @Column(nullable = false, columnDefinition = "int default 1")
    @Positive
    private Integer quantidade;
    @Column(nullable = false)
    private Date dataValidade;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String codigoBarras;
    @Column(nullable = false)
    private Double peso;
    @Column(nullable = false)
    private String medida;
    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "idFabricante", referencedColumnName = "idFabricante")
    private Fabricante fabricante;
    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    private Categoria categoria;
}
