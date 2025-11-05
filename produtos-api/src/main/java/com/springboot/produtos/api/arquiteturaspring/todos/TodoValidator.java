package com.springboot.produtos.api.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity obj) {
        if (existeTodoComDescricao(obj.getDescricao())) {
            throw new IllegalArgumentException("descrição ja existente!");
        }
    }

    private boolean existeTodoComDescricao(String desc) {
        return repository.existsByDescricao(desc);
    }
}
