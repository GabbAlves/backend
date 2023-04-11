package com.GOATstore.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GOATstore.backend.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  

      @Query(" SELECT * FROM produto p INNER JOIN marca m ON p.id_marca = m.id INNER JOIN categoria c ON p.id_categoria = c.id WHERE m.nome = ?1 OR c.nome = ?2 p.nome = ?3")
      List<Produto> buscarPorReferencia(String marca, String categoria, String nome);
    

      @Query(" SELECT * FROM produto p INNER JOIN marca m ON p.id_marca = m.id INNER JOIN produtoImagens c ON p.id_categoria = c.id INNER JOIN categoria c ON p.id_categoria WHERE m.nome = ?1 OR c.nome = ?2 p.nome = ?3")
      List<Produto> buscarProdutoFoto(String marca, String categoria, String nome);
}
