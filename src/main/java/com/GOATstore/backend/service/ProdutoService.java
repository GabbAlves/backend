package com.GOATstore.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.GOATstore.backend.entity.Produto;
import com.GOATstore.backend.repository.ProdutoRepository;



@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    } 

    public Produto inserir(Produto produto){
      if (produto.getNome().equals("") || produto.getValor().equals("")
      || produto.getDescricaoProduto().equals("")) {
          
        throw new RuntimeException("Ocorreu um erro!");        
    }
    else {
        produto.setDataCriacao(new Date());
        Produto produtoNovo = produtoRepository.saveAndFlush(produto);
        return produtoNovo;

    }
}

    public Produto alterar(Produto produto){
        produto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public void excluir(Long id){
        Produto produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }
    
}
