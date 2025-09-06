package com.lucasmoraist.payment_service.infrastructure.mercadopago.config;

import com.mercadopago.client.preference.PreferenceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MercadoPagoConfig {

    private final String accessToken;

    public MercadoPagoConfig(@Value("${secrets.client.mercado-pago.access-token}") String accessToken) {
        this.accessToken = accessToken;
    }

    @PostConstruct
    public void init() {
        com.mercadopago.MercadoPagoConfig.setAccessToken(accessToken);
    }

    @Bean
    public PreferenceClient preferenceClient() {
        return new PreferenceClient();
    }

}
