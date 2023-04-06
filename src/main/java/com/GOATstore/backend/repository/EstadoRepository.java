package com.GOATstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.GOATstore.backend.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    //JPA vai nos fornecer todos os metodos basicos, excluir, alterar, mostrar todos...


}
