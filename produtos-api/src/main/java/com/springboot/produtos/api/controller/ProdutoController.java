package com.springboot.produtos.api.controller;


import com.springboot.produtos.api.model.Produto;
import com.springboot.produtos.api.model.dto.ProdutoRecordDto;
import com.springboot.produtos.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService productService;

    @GetMapping("/find")
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> all = productService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody ProdutoRecordDto produtoRecordDto) {
        Produto produto = productService.update(id, produtoRecordDto);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
