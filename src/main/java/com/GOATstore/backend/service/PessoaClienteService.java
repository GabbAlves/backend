package com.GOATstore.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GOATstore.backend.entity.Pessoa;
import com.GOATstore.backend.repository.PessoaClienteRepository;


import dto.PessoaClienteRequestDTO;

@Service
public class PessoaClienteService{

    @Autowired
    private PessoaClienteRepository pessoaRepository;
    
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private EmailService emailService;


    public List<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
    }

        
    

       public Pessoa inserir(PessoaClienteRequestDTO pessoaClienteRequestDTO) throws Exception {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);

        if (pessoa != null) {
            if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
                throw new Exception("O nome de usuario não pode ser vazio");
            }
            if (pessoa.getEmail() == null) {
                throw new Exception("O email do usuario não pode ser vazio");
            }
            if (pessoa.getSenha() != null && !pessoa.getSenha().isEmpty()) {

            }

            List<Pessoa> pessoas = pessoaRepository.findByEmail(pessoa.getNome(), pessoa.getEmail());
            if (pessoas != null && !pessoas.isEmpty()) {
                throw new Exception("Já existe uma pessoa cadastrada com o mesmo nome e o Email.");
            }

            pessoa.setDataCriacao(new Date());
            Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);
            permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNovo);
            emailService.enviarEmailTexto(pessoaNovo.getEmail(), "cadastro",
                    "Cadastro realizado com sucesso na loja GOAT STORE");
            return pessoaNovo;
         } else {    
            throw new RuntimeException("Ocorreu um erro!");
        }
    }



}