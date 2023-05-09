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

    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria){
        if (categoria.getNome().equals("")) {
            throw new RuntimeException("Ocorreu um erro!");   

        }else {
            categoria.setDataCriação(new Date());
            Categoria categoriaNovo = categoriaRepository.saveAndFlush(categoria);
            return categoriaNovo;
        }
        
    }


    // public Categoria alterar(Long id){
    //     Categoria categoria = categoriaRepository.findById(id).get();
    //     categoria.setDataAtualizacao(new Date());
    //     return categoriaRepository.saveAndFlush(categoria);

    // }

  public Categoria alterar(Long id, String novoNome) throws Exception {
    Categoria categoria = categoriaRepository.findById(id).get();
    categoria.setNome(novoNome);
    categoria.setDataAtualizacao(new Date());
      return categoriaRepository.save(categoria);
  }
  
      public void excluir(Long id){
          Categoria categoria = categoriaRepository.findById(id).get();
          categoriaRepository.delete(categoria);
      }
}


 


