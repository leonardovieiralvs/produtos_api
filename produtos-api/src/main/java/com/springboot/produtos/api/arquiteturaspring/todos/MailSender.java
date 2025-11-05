package com.springboot.produtos.api.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviarMensagem(String msg) {
        System.out.println("Enviado email: " + msg);
    }
}
