package com.lucasmoraist.payment_service.infrastructure.web.controller;

import com.lucasmoraist.payment_service.application.usecases.callback.ProcessPaymentCallbackCase;
import com.lucasmoraist.payment_service.domain.dto.WebhookContext;
import com.lucasmoraist.payment_service.infrastructure.web.routes.CallbackRoutes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CallbackController implements CallbackRoutes {

    private final ProcessPaymentCallbackCase processPaymentCallbackCase;

    @Override
    public ResponseEntity<Void> paymentNotification(String dataId, String requestId, String signature, Map<String, Object> payload) {
        this.processPaymentCallbackCase.execute(new WebhookContext(
                dataId,
                requestId,
                signature,
                payload
        ));

        return ResponseEntity.ok().build();
    }

}
