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
    
    public Marca inserir(Marca marca){
       if (marca.getNome().equals("") ) {
        throw new RuntimeException("Ocorreu um erro!");    

       } else {
           marca.setDataCriacao(new Date());
           Marca marcaNovo = marcaRepository.saveAndFlush(marca);
           return marcaNovo;
       }
       
    }

    public Marca alterar(Marca marca){
        marca.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public void excluir(Long id){
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }

}
