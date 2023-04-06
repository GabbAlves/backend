package com.GOATstore.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GOATstore.backend.repository.CidadeRepository;
import com.GOATstore.backend.entity.Cidade;


@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos(){
        return cidadeRepository.findAll();
    }

    public Cidade inserir(Cidade cidade){
        cidade.setDataCriação(new Date());
        Cidade cidadeNovo= cidadeRepository.saveAndFlush(cidade);
        return cidadeNovo;
    }


    public Cidade alterar(Cidade cidade){
       cidade.setDataAtualização(new Date());
       return cidadeRepository.saveAndFlush(cidade);
    }

    public void excluir(Long id){
        Cidade cidade =  cidadeRepository.findById(id).get();
        cidadeRepository.delete(cidade);
    }
}
