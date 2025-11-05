package com.springboot.produtos.api.arquiteturaspring.todos;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoEntity todoSave(TodoEntity obj) {
        return todoRepository.save(obj);
    }

    public TodoEntity atualizarStatus(TodoEntity obj) {
        return todoRepository.save(obj);
    }

    public TodoEntity buscarPorId(Integer id) {
        return todoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Entity não encontrada"));
    }
}
