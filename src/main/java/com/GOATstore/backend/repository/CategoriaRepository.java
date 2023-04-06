package com.GOATstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GOATstore.backend.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
