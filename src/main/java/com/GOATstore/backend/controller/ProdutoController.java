package com.GOATstore.backend.controller;

import java.util.ArrayList;
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

import com.GOATstore.backend.entity.Produto;
import com.GOATstore.backend.repository.ProdutoRepository;
import com.GOATstore.backend.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/")
    public List<Produto> buscarTodos() {
        return produtoService.buscarTodos();
    }

    @GetMapping("/Lupa")
    public List<Produto> buscarProduto(@RequestParam String marca, @RequestParam String categoria,
            @RequestParam String nome) {
        return produtoRepository.buscarPorTodos(marca, categoria, nome);

    }

    @GetMapping("/Filtro")
    public List<Produto> buscarPorFiltro(@RequestParam(required = false) String marca,
            @RequestParam(required = false) String categoria) {
        if (marca != "" && categoria != "") {
            return produtoRepository.buscarPorMarcaECategoria(marca, categoria);
        } else if (marca != "" || categoria != "") {
            return produtoRepository.buscarPorMarcaOuCategoria(marca, categoria);
        } else {
            return new ArrayList<Produto>();
        }

    }

    @GetMapping("/{id}")
    public List<Produto> buscarPorId(@PathVariable("id") Long id) {
        return produtoRepository.buscarPorId(id);
    }

    @PostMapping("/")
    public Produto inserir(@RequestBody Produto produto) {
        return produtoService.inserir(produto);
    }

    @PutMapping("/")
    public Produto alterar(@RequestBody Produto produto) {
        return produtoService.alterar(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
