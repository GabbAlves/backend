package com.GOATstore.backend.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GOATstore.backend.entity.Permissao;
import com.GOATstore.backend.entity.PermissaoPessoa;
import com.GOATstore.backend.entity.Pessoa;
import com.GOATstore.backend.repository.PermissaoPessoaRepository;
import com.GOATstore.backend.repository.PermissaoRepository;


@Service
public class PermissaoPessoaService {
    
    @Autowired
    PermissaoPessoaRepository permissaoPessoaRepository;

    @Autowired
    PermissaoRepository permissaoRepository;

    public void vincularPessoaPermissaoCliente(Pessoa pessoa){
        List<Permissao> listaPermissao = permissaoRepository.findByNome("cliente");
        if(listaPermissao.size()>0){
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriação(new Date());

            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);

        }
    }
}
