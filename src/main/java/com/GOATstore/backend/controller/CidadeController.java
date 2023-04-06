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

import com.GOATstore.backend.entity.Cidade;
import com.GOATstore.backend.service.CidadeService;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {
    
    @Autowired
    // para nao precisar criar um new  CidadeService
    private CidadeService cidadeService;


    @GetMapping("/")
    public List<Cidade> buscarTodos(){
       return cidadeService.buscarTodos();
    }

    @PostMapping("/")
     //@Requestbody mandando as informações no corpo da requisição http
    public Cidade inserir (@RequestBody Cidade cidade){
        return cidadeService.inserir(cidade);
    }

    @PutMapping("/")
    public Cidade alterar(@RequestBody Cidade cidade){
        return cidadeService.alterar(cidade);
    }

    @DeleteMapping("/{id}")
     // @PATHVARIABLE - informação q receber da url, vai atribuir ao idetificador

    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        if(cidadeService != null){
        cidadeService.excluir(id);
        }
        return ResponseEntity.ok().build();
        // se der algum erro no excluir ele retorna um OK
        
    }
}
