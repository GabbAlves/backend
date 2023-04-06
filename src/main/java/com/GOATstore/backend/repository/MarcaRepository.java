package com.GOATstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GOATstore.backend.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{
    
}
