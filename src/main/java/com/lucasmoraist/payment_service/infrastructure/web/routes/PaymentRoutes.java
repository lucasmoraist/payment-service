package com.lucasmoraist.payment_service.infrastructure.web.routes;

import com.lucasmoraist.payment_service.domain.dto.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/payments")
public interface PaymentRoutes {

    @PostMapping("/create")
    ResponseEntity<Void> createPayment(@RequestBody Product product);

}
