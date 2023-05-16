package com.GOATstore.backend.controller;

import java.util.List;

import javax.sql.DataSource;

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
import org.springframework.jdbc.core.JdbcTemplate;


import com.GOATstore.backend.entity.Marca;
import com.GOATstore.backend.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    DataSource dataSource;
    
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> buscarTodos(){
        return marcaService.buscarTodos();
    }
    
    @PostMapping("/")
        public Marca inserir(@RequestBody Marca marca){
            return marcaService.inserir(marca);
        }
    

    @PutMapping("/{id}")
    public Marca alterar(@PathVariable("id") Long id,  @RequestBody(required = false) String nome) throws Exception{
        return marcaService.alterar(id, nome);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        marcaService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/marca")
    public Long getIdByNome(@RequestParam String nome) {
        String sql = "SELECT id FROM marca WHERE nome = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long id = jdbcTemplate.queryForObject(sql, Long.class, nome);
        return id;
    }
}
