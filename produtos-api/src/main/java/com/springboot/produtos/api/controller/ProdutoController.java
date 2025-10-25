package com.springboot.produtos.api.controller;


import com.springboot.produtos.api.model.Produto;
import com.springboot.produtos.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        return ResponseEntity.ok().body(productService.save(produto));
    }
}
