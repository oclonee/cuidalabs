package com.projeto.cuidalabs.infrastructure.repository;

import com.projeto.cuidalabs.domain.model.Produtos;
import com.projeto.cuidalabs.domain.repository.ProdutoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProdutosRepositoryImpl implements ProdutoRepository {
    @PersistenceContext
    EntityManager manager;

    @Override
    public List<Produtos> list() {
        return manager.createQuery("from produtos", Produtos.class)
                .getResultList();
    }

    @Override
    public Produtos findById(Long id) {
        return manager.find(Produtos.class, id);
    }
    @Transactional
    @Override
    public Produtos salvar(Produtos produto) {
        return manager.merge(produto);
    }
}
