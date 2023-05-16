package com.GOATstore.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GOATstore.backend.entity.Pessoa;
import com.GOATstore.backend.repository.PessoaRepository;

@Service
public class PessoaService{

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa pessoa) throws Exception {
        if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
            throw new Exception("O nome de usuario não pode ser vazio");
        }
        if (pessoa.getEmail() == null) {
            throw new Exception("O email do usuario não pode ser vazio");
        }
        if (pessoa.getSenha() != null && !pessoa.getSenha().isEmpty()) {

        }

        List<Pessoa> pessoas = (List<Pessoa>) pessoaRepository.findByEmail(pessoa.getEmail());
        if (pessoas != null && !pessoas.isEmpty()) {
            throw new Exception("Já existe uma pessoa cadastrada com o mesmo nome e o Email.");
        }
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);
        return pessoaNovo;
    }

    public Pessoa alterar(Pessoa pessoa){
        pessoa.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void excluir(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }

}