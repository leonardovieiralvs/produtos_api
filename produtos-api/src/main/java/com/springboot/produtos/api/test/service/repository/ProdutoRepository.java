package com.springboot.produtos.api.test.service.repository;

import com.springboot.produtos.api.test.service.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
