package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {
    List<Permissao> listar();

    Permissao porId(Long id);

    Permissao adicionar(Permissao Permissao);

    void remover(Permissao Permissao);
}
