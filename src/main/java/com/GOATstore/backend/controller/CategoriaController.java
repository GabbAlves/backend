package com.GOATstore.backend.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GOATstore.backend.entity.Categoria;
import com.GOATstore.backend.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    DataSource dataSource;

    @GetMapping("/")
    public List<Categoria> buscarTodos(){
        return categoriaService.buscarTodos();
    }

    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria categoria){
        return categoriaService.inserir(categoria);
        
    }

    @PutMapping("/{id}")
    public  Categoria alterar(@PathVariable("id") Long id,  @RequestBody(required = false) String novoNome) throws Exception{
        try {
            return categoriaService.alterar(id, novoNome);
        } catch (Exception ex) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        categoriaService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/categoria")
    public Long getIdByNome(@RequestParam String nome) {
        String sql = "SELECT id FROM categoria WHERE nome = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long id = jdbcTemplate.queryForObject(sql, Long.class, nome);
        return id;
    }
}
