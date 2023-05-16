package com.GOATstore.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.GOATstore.backend.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByEmail(String email);

    Pessoa findByEmailAndCodigoRecuperarSenha(String email, String codigoRecuperarSenha);



}
