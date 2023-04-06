package com.GOATstore.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GOATstore.backend.entity.Estado;
import com.GOATstore.backend.service.EstadoService;


@RestController
@RequestMapping("/api/estado")
public class EstadoController {
    
    @Autowired // para nao precisar criar um new estado service
    private EstadoService estadoService;

    @GetMapping("/")
    public List<Estado> buscarTodos(){
       return estadoService.buscarTodos();
    }

    @PostMapping("/")
    //@Requestbody mandando as informações no corpo da requisição http
    public Estado inserir(@RequestBody Estado estado){
        return estadoService.inserir(estado);
    }

    @PutMapping("/")
    public Estado alterar(@RequestBody Estado estado){
        return estadoService.alterar(estado);
    }

    @DeleteMapping("/{id}")
    // informação q receber da url, vai atribuir ao idetificador
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        estadoService.excluir(id);
        return ResponseEntity.ok().build();
        // se der algum erro no excluir ele retorna um OK
    }

}
