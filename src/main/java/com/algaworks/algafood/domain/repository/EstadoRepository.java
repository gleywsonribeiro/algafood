package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {
    List<Estado> listar();

    Estado porId(Long id);

    Estado adicionar(Estado Estado);

    void remover(Estado Estado);
}
