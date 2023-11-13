package com.produtos.produtos.repository;

import com.produtos.produtos.model.entity.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante,Long> {
}
