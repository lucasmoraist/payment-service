package com.lucasmoraist.payment_service.infrastructure.web.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@RequestMapping("/api/v1/callback")
public interface CallbackRoutes {

    @PostMapping("/payments")
    ResponseEntity<Void> paymentNotification(
            @RequestParam("data.id") String dataId,
            @RequestHeader("X-Request-Id") String requestId,
            @RequestHeader("X-Signature") String signature,
            @RequestBody Map<String, Object> payload
    ) throws IOException;

}
