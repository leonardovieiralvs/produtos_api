package com.springboot.produtos.api.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoEntity> todoSave(@RequestBody TodoEntity obj) {
        TodoEntity todoEntity = todoService.todoSave(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoEntity);
    }

    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable Integer id, @RequestBody TodoEntity obj) {
        obj.setId(id);
        todoService.atualizarStatus(obj);
    }

    @GetMapping("{id}")
    public TodoEntity buscarPorId(@PathVariable Integer id) {
        return todoService.buscarPorId(id);
    }
}
