package com.GOATstore.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.GOATstore.backend.entity.Pessoa;

public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByEmail(String nome, String email);
}
