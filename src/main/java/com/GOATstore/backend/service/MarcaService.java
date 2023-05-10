package com.GOATstore.backend.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GOATstore.backend.entity.Marca;
import com.GOATstore.backend.repository.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarTodos(){
        return marcaRepository.findAll();
    }
    
    public Marca inserir(Marca marca) {
        // Verifica se o nome da marca é válido e não está vazio
        if (marca.getNome() == null || marca.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da marca não pode ser vazio");
        }

        // Verifica se já existe outra marca com o mesmo nome
        Marca marcaExistente = marcaRepository.findByNome(marca.getNome());
        if (marcaExistente != null) {
            throw new IllegalArgumentException("Já existe uma marca com o mesmo nome");
        }

        // Define a data de criação e salva a nova marca
        marca.setDataCriacao(new Date());
        Marca marcaNova = marcaRepository.saveAndFlush(marca);

        return marcaNova;
    }

    public Marca alterar(Marca marca) {
        if (marca.getId() == null) {
            throw new IllegalArgumentException("Não é possível atualizar uma marca sem ID");
        }
        marca.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public void excluir(Long id){
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }

}
