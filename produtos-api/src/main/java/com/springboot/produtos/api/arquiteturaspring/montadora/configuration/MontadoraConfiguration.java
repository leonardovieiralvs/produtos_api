package com.springboot.produtos.api.arquiteturaspring.montadora.configuration;

import com.springboot.produtos.api.arquiteturaspring.montadora.Motor;
import com.springboot.produtos.api.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {

    @Bean
    public Motor motorAspirado() {
        Motor motor = new Motor();
        motor.setCavalo(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean
    public Motor motorEletrico() {
        Motor motor = new Motor();
        motor.setCavalo(100);
        motor.setCilindros(4);
        motor.setModelo("XPTO-1");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean
    public Motor motorTurbo() {
        Motor motor = new Motor();
        motor.setCavalo(110);
        motor.setCilindros(4);
        motor.setModelo("XPTO-2");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.TURBO);
        return motor;
    }
}
