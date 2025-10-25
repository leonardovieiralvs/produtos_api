package com.springboot.produtos.api.service;

import com.springboot.produtos.api.mapper.ProdutoMapper;
import com.springboot.produtos.api.model.Produto;
import com.springboot.produtos.api.model.dto.ProdutoPutDto;
import com.springboot.produtos.api.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

    public Produto findById(Long id) {
        Optional<Produto> findId = productRepository.findById(id);
        return findId.orElseThrow();
    }

    public Produto save(Produto produto) {
        return productRepository.save(produto);
    }

    @Transactional
    public Produto update(Long id, ProdutoPutDto produtoDto) {
        Produto existente = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado: " + id));

        ProdutoMapper.INSTANCE.updateFromDto(produtoDto, existente); // mapper configured para ignorar id
        return productRepository.save(existente);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
