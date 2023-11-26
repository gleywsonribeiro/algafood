package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> listar() {
        TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagamento ", FormaPagamento.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public FormaPagamento adicionar(FormaPagamento FormaPagamento) {
        return manager.merge(FormaPagamento);
    }
    @Override
    public FormaPagamento porId(Long id) {
        return manager.find(FormaPagamento.class, id);
    }

    @Transactional
    @Override
    public void remover(FormaPagamento FormaPagamento) {
        FormaPagamento = porId(FormaPagamento.getId());
        manager.remove(FormaPagamento);
    }
}
