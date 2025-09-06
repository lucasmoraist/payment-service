package com.lucasmoraist.payment_service.infrastructure.usecases;

import com.lucasmoraist.payment_service.application.gateway.WebhookGateway;
import com.lucasmoraist.payment_service.application.usecases.callback.ProcessPaymentCallbackCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CallbackUseCases {

    @Bean
    public ProcessPaymentCallbackCase processPaymentCallbackCase(WebhookGateway webhookGateway) {
        return new ProcessPaymentCallbackCase(webhookGateway);
    }

}
