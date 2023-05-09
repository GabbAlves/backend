package com.GOATstore.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.GOATstore.backend.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

      // JPQL, não SQL
      //buscar todos
      @Query("SELECT p FROM Produto p JOIN p.marca m JOIN p.categoria c "
      + " WHERE m.nome LIKE CONCAT('%', :marca, '%') OR c.nome LIKE CONCAT('%', :categoria, '%') "
      + " OR p.nome LIKE CONCAT('%', :nome, '%')")
      List<Produto> buscarPorTodos(@Param("marca") String marca, @Param("categoria") String categoria,
      @Param("nome") String nome);


      //buscar marca e categoria
      @Query("SELECT p FROM Produto p JOIN p.marca m JOIN p.categoria c "
      + " WHERE m.nome LIKE :marca AND c.nome LIKE :categoria")
      List<Produto> buscarPorMarcaECategoria(@Param("marca") String marca, @Param("categoria") String categoria);
      
      
      //buscar por marca ou categoria
      @Query("SELECT p FROM Produto p JOIN p.marca m JOIN p.categoria c "
      + " WHERE m.nome LIKE :marca OR c.nome LIKE :categoria")
      List<Produto> buscarPorMarcaOuCategoria(@Param("marca") String marca, @Param("categoria") String categoria);

      //buscar produto por id
      @Query("SELECT p FROM Produto p"
      + " WHERE p.id = :id")
      List<Produto> buscarPorId(@Param("id") Long id);

                  
      // @Query(" SELECT * FROM produto p INNER JOIN marca m ON p.id_marca = m.id
      // INNER JOIN produtoImagens c ON p.id_categoria = c.id INNER JOIN categoria c
      // ON p.id_categoria WHERE m.nome = ?1 OR c.nome = ?2 p.nome = ?3")
      // List<Produto> buscarProdutoFoto(String marca, String categoria, String nome);
}