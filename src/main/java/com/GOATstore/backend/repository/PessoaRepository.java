package com.GOATstore.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.GOATstore.backend.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByEmail(String email);

    Pessoa findByEmailAndCodigoRecuperarSenha(String email, String codigoRecuperarSenha);

    List<Pessoa> findByEmail(String nome, String email);

}
