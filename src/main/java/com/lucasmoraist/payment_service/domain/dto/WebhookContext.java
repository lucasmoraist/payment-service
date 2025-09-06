package com.lucasmoraist.payment_service.domain.dto;

import java.util.Map;

public record WebhookContext(
        String dataId,
        String requestId,
        String signature,
        Map<String, Object> payload
) {

}
