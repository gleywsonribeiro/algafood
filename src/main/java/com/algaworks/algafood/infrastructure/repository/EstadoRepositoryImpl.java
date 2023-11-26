package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listar() {
        TypedQuery<Estado> query = manager.createQuery("from Estado ", Estado.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Estado adicionar(Estado Estado) {
        return manager.merge(Estado);
    }
    @Override
    public Estado porId(Long id) {
        return manager.find(Estado.class, id);
    }

    @Transactional
    @Override
    public void remover(Estado Estado) {
        Estado = porId(Estado.getId());
        manager.remove(Estado);
    }
}
