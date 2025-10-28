package com.springboot.produtos.api.service;

import com.springboot.produtos.api.model.Produto;
import com.springboot.produtos.api.model.dto.ProdutoRecordDto;
import com.springboot.produtos.api.repository.ProdutoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository productRepository;

    public ProdutoService(ProdutoRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Produto> findAll() {
        return productRepository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> findId = productRepository.findById(id);
        return findId.orElseThrow();
    }

    public Produto save(Produto produto) {
        return productRepository.save(produto);
    }

    public Produto update(Long id, ProdutoRecordDto produtoRecordDto) {
        Produto produto = productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado", id));

        produto.setNome(produtoRecordDto.nome());
        produto.setDescricao(produtoRecordDto.descricao());
        produto.setPreco(produtoRecordDto.preco());

        return productRepository.save(produto);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
