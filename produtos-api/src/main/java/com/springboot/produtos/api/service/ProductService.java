package com.springboot.produtos.api.service;

import com.springboot.produtos.api.model.Produto;
import com.springboot.produtos.api.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Produto save(Produto produto) {
        return productRepository.save(produto);
    }
}
