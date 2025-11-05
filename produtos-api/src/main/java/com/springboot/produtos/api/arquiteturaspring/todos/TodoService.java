package com.springboot.produtos.api.arquiteturaspring.todos;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;
    private TodoValidator todoValidator;
    private MailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidator validator, MailSender mailSender) {
        this.todoRepository = todoRepository;
        this.todoValidator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity todoSave(TodoEntity obj) {
        todoValidator.validar(obj);
        return todoRepository.save(obj);
    }

    public void atualizarStatus(TodoEntity obj) {
        todoRepository.save(obj);
        String status = obj.getConcluido() == Boolean.TRUE ? "Concluído" : "Não concluido";
        mailSender.enviarMensagem("Todo " + obj.getDescricao() + "foi atualizado para: " + status);
    }

    public TodoEntity buscarPorId(Integer id) {
        return todoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Entity não encontrada"));
    }

}
