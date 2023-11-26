package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permissao> listar() {
        TypedQuery<Permissao> query = manager.createQuery("from Permissao ", Permissao.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Permissao adicionar(Permissao Permissao) {
        return manager.merge(Permissao);
    }
    @Override
    public Permissao porId(Long id) {
        return manager.find(Permissao.class, id);
    }

    @Transactional
    @Override
    public void remover(Permissao Permissao) {
        Permissao = porId(Permissao.getId());
        manager.remove(Permissao);
    }
}
