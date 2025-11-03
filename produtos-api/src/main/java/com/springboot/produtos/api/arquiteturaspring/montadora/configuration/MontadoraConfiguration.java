package com.springboot.produtos.api.arquiteturaspring.montadora.configuration;

import com.springboot.produtos.api.arquiteturaspring.montadora.Motor;
import com.springboot.produtos.api.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {

    @Bean
    public Motor motor() {
        Motor motor = new Motor();
        motor.setCavalo(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        return motor;
    }
}
