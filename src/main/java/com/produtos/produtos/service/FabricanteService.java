package com.produtos.produtos.service;

import com.produtos.produtos.model.entity.Fabricante;
import com.produtos.produtos.model.entity.Produto;
import com.produtos.produtos.repository.FabricanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FabricanteService {

    private final FabricanteRepository fabricanteRepository;

    public List<Fabricante> buscarTodos() {
        return fabricanteRepository.findAll();
    }

    public Fabricante buscarUm(Long id) {
        return fabricanteRepository.findById(id).orElse(null);
    }

    public Fabricante salvar(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

    public Fabricante editar(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

    public void deletar(Long id) {
        fabricanteRepository.deleteById(id);
    }
}
