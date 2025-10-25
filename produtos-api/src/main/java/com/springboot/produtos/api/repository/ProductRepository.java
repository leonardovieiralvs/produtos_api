package com.springboot.produtos.api.repository;

import com.springboot.produtos.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Produto, String> {
}
