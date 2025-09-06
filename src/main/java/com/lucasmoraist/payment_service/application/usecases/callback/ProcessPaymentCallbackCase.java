package com.lucasmoraist.payment_service.application.usecases.callback;

import com.lucasmoraist.payment_service.application.gateway.WebhookGateway;
import com.lucasmoraist.payment_service.domain.dto.WebhookContext;

public record ProcessPaymentCallbackCase(WebhookGateway webhookGateway) {

    public void execute(WebhookContext webhookContext) {
        this.webhookGateway.validateSignature(webhookContext);
    }
}
