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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.GOATstore.backend.entity.ProdutoImagens;
import com.GOATstore.backend.service.ProdutoImagensService;

@RestController
@RequestMapping("/api/produtoImagens") 

public class ProdutoImagensController {

    @Autowired
    ProdutoImagensService produtoImagensService;
 
    @GetMapping("/")
    public List<ProdutoImagens> buscarTodos(){
        return produtoImagensService.buscarTodos();
    }
    
    @PostMapping("/{id}")
    public ProdutoImagens inserir(@RequestParam("idProduto") Long idProduto, @RequestBody String nome){
        return produtoImagensService.inserir(idProduto, nome);
    }

    @PutMapping("/")
    public ProdutoImagens alterar(@RequestBody ProdutoImagens produtoImagens){
        return produtoImagensService.alterar(produtoImagens);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
            produtoImagensService.excluir(id);
            return ResponseEntity.ok().build();
        }

        
        // @PostMapping("/")
        // public ProdutoImagens inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("file") MultipartFile file){
        //     return produtoImagensService.inserir(idProduto, file);
        // }
        
    }
    

    
