package com.lucasmoraist.payment_service.application.usecases.payment;

import com.lucasmoraist.payment_service.application.gateway.MercadoPagoGateway;
import com.lucasmoraist.payment_service.domain.dto.Product;

public record CreatePaymentCase(MercadoPagoGateway mercadoPagoGateway) {

    public String execute(Product product) {
        return this.mercadoPagoGateway.createCheckout(product);
    }

}
