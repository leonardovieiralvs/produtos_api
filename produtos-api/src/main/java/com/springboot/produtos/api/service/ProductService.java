package com.springboot.produtos.api.service;

import com.springboot.produtos.api.model.Produto;
import com.springboot.produtos.api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Produto> findAll() {
        return productRepository.findAll();
    }

    public Produto findById(String id) {
        Optional<Produto> findId = productRepository.findById(id);
        return findId.orElseThrow();
    }

    public Produto save(Produto produto) {
        return productRepository.save(produto);
    }
}
