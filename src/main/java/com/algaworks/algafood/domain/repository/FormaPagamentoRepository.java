package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {
    List<FormaPagamento> listar();

    FormaPagamento porId(Long id);

    FormaPagamento adicionar(FormaPagamento FormaPagamento);

    void remover(FormaPagamento FormaPagamento);
}
