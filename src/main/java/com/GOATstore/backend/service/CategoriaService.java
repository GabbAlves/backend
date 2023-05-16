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

    public Categoria alterar(Long id, String nome) throws Exception {
            if (id == null) {
                throw new IllegalArgumentException("O id não pode ser nulo");
            }
            if (nome == "" || nome.isEmpty()) {
                throw new IllegalArgumentException("O nome não pode estar vazio ou nulo");
            }
            Categoria alterarCategoria = categoriaRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
            alterarCategoria.setDataAtualizacao(new Date());
            alterarCategoria.setNome(nome);
            return categoriaRepository.saveAndFlush(alterarCategoria);
        }
        

    public void excluir(Long id) {
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }

}