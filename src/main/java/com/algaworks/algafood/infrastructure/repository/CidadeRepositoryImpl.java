package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> listar() {
        TypedQuery<Cidade> query = manager.createQuery("from Cidade ", Cidade.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Cidade adicionar(Cidade Cidade) {
        return manager.merge(Cidade);
    }
    @Override
    public Cidade porId(Long id) {
        return manager.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public void remover(Cidade Cidade) {
        Cidade = porId(Cidade.getId());
        manager.remove(Cidade);
    }
}
