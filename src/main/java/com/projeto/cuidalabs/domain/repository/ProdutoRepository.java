package com.projeto.cuidalabs.domain.repository;

import com.projeto.cuidalabs.domain.model.Produtos;

import java.util.List;

public interface ProdutoRepository {
    List<Produtos> list();
    Produtos findById(Long id);
    Produtos salvar(Produtos produto);
}
