package com.projeto.cuidalabs.jpa;

import com.projeto.cuidalabs.CuidalabsApplication;
import com.projeto.cuidalabs.domain.model.Produtos;
import com.projeto.cuidalabs.domain.repository.ProdutoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ProdutosMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(CuidalabsApplication.class)
                .web(WebApplicationType.NONE).run(args);

        ProdutoRepository produtoRepository = applicationContext.getBean(ProdutoRepository.class);

        Produtos produto1 = new Produtos();
        produto1.setNome("Notebook");
        produto1.setPreco(3500.00);
        produto1.setQtdEstoque(10);
        produtoRepository.salvar(produto1);

        List<Produtos> todosProdutos = produtoRepository.list();

        for (Produtos produto : todosProdutos){
            System.out.printf("%d - %s - %.2f - %d\n",
                    produto.getId(), produto.getNome(), produto.getPreco(),produto.getQtdEstoque());
        }
        Produtos produto2 = produtoRepository.findById(2L);
        System.out.printf("%d - %s - %.2f - %d\n",
                produto2.getId(), produto2.getNome(), produto2.getPreco(), produto2.getQtdEstoque());

    }
}
