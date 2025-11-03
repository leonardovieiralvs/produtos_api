package com.springboot.produtos.api.arquiteturaspring.montadora.api;

import com.springboot.produtos.api.arquiteturaspring.montadora.*;
import com.springboot.produtos.api.arquiteturaspring.montadora.configuration.MontadoraConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/carro")
public class TesteFabricaController {

    @Autowired
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
            Carro carro = new HondaHRV(motor);
            return carro.darIgnicao(chave);
    }
}
