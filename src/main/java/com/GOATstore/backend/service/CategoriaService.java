package com.GOATstore.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GOATstore.backend.entity.Categoria;
import com.GOATstore.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria) {
        String nome = categoria.getNome();
        if (nome.isEmpty()) {
            throw new RuntimeException("O nome da categoria não pode ser vazio");
        }

        Categoria categoriaExistente = categoriaRepository.findByNome(nome);
        if (categoriaExistente != null) {
            throw new RuntimeException("Já existe uma categoria com esse nome");
        }

        categoria.setNome(nome);
        categoria.setDataCriação(new Date());

        Categoria categoriaNova = categoriaRepository.saveAndFlush(categoria);
        return categoriaNova;
    }

    public Categoria alterar(Long id, String novoNome) throws Exception {
        Categoria categoria = categoriaRepository.findById(id).get();
        Categoria categoriaExistente = categoriaRepository.findById(categoria.getId()).orElse(null);
        if (categoriaExistente == null) {
            throw new RuntimeException("Categoria não encontrada");
        }

        novoNome = categoriaExistente.getNome();
        if (novoNome.isEmpty()) {
            throw new RuntimeException("O nome da categoria não pode ser vazio");
        }

        Categoria categoriaComMesmoNome = categoriaRepository.findByNome(novoNome);
       
        if (categoriaComMesmoNome != null && !categoriaComMesmoNome.getId().equals(categoriaExistente.getId())) {
            throw new RuntimeException("Já existe uma categoria com esse nome");
        }

        categoriaExistente.setNome(novoNome);
        categoriaExistente.setDataAtualizacao(new Date());

        return categoriaRepository.saveAndFlush(categoriaExistente);
    }

    public void excluir(Long id) {
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }

}