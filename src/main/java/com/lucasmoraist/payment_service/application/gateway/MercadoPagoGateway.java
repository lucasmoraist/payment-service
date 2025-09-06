package com.lucasmoraist.payment_service.application.gateway;

import com.lucasmoraist.payment_service.domain.dto.Product;

import java.util.List;

public interface MercadoPagoGateway {

    String createCheckout(Product product);
    String createCheckout(List<Product> products);

}
