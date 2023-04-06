package com.GOATstore.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GOATstore.backend.entity.Estado;
import com.GOATstore.backend.repository.EstadoRepository;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos(){
        return estadoRepository.findAll();
    }

    public Estado inserir(Estado estado){
        estado.setDataCriação(new Date());
        Estado estadoNovo= estadoRepository.saveAndFlush(estado);
            //saveAndFlush ele salva o registro no banco diretamente
            return estadoNovo;

    }
        //sem id ele cria um novo elemento ja existente "estado",
        // com id ele altera o elemento "estado"

    public Estado alterar(Estado estado){
        estado.setDataAtualização(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public void excluir(Long id){
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }
}
