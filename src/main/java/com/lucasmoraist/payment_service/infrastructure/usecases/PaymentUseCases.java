package com.lucasmoraist.payment_service.infrastructure.usecases;

import com.lucasmoraist.payment_service.application.gateway.MercadoPagoGateway;
import com.lucasmoraist.payment_service.application.usecases.payment.CreatePaymentCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentUseCases {

    @Bean
    public CreatePaymentCase createPaymentCase(MercadoPagoGateway mercadoPagoGateway) {
        return new CreatePaymentCase(mercadoPagoGateway);
    }

}
