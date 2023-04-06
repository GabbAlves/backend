package com.GOATstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GOATstore.backend.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
