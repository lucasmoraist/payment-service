package com.lucasmoraist.payment_service.application.gateway;

import com.lucasmoraist.payment_service.domain.dto.WebhookContext;

public interface WebhookGateway {

    void validateSignature(WebhookContext webhookContext);

}
