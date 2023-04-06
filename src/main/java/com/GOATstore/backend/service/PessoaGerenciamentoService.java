package com.GOATstore.backend.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GOATstore.backend.entity.Pessoa;
import com.GOATstore.backend.repository.PessoaRepository;




@Service
public class PessoaGerenciamentoService{

    @Autowired
    private PessoaRepository pessoaRepository;
    

    @Autowired
    private EmailService emailService;

    public String solicitarCodigo(String email){

        Pessoa pessoa = pessoaRepository.findByEmail(email);
        pessoa.setCodigoRecuperarSenha(getCodigoRecuperarSenha(pessoa.getId()));
        pessoa.setDataValidarCodigo(new Date());
        pessoaRepository.saveAndFlush(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(), "Codigo de recuperação de senha", "o seu codigo para recuperar senha é o seguinte: " + pessoa.getCodigoRecuperarSenha());


        return "Codigo Enviado";
    }

    public String alterarSenha(Pessoa pessoa){
        Pessoa pessoaBanco = pessoaRepository.findByEmailAndCodigoRecuperarSenha(pessoa.getEmail(), pessoa.getCodigoRecuperarSenha());
        if(pessoaBanco != null){
            Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataValidarCodigo().getTime());
            if(diferenca.getTime()/1000<900){
                pessoaBanco.setSenha(pessoa.getSenha());
                pessoaBanco.setCodigoRecuperarSenha(null);
                pessoaRepository.saveAndFlush(pessoaBanco);
                return "senha alterada";
            }else{
                return "Tempo expirado, solicite um outro codigo ";
            }
        } else{
           return "email ou codigo não encontrado";
        }   
    }

    private String getCodigoRecuperarSenha(Long id){
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date())+id;
    }



}