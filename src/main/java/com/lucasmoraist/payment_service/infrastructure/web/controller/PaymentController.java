package com.lucasmoraist.payment_service.infrastructure.web.controller;

import com.lucasmoraist.payment_service.application.usecases.payment.CreatePaymentCase;
import com.lucasmoraist.payment_service.domain.dto.Product;
import com.lucasmoraist.payment_service.infrastructure.web.routes.PaymentRoutes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class PaymentController implements PaymentRoutes {

    private final CreatePaymentCase createPaymentCase;

    @PostMapping
    public ResponseEntity<Void> createPayment(@RequestBody Product product) {
        String checkoutUrl = createPaymentCase.execute(product);
        URI location = URI.create(checkoutUrl);
        return ResponseEntity.created(location).build();
    }

}
