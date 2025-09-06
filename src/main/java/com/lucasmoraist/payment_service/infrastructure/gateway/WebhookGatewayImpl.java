package com.lucasmoraist.payment_service.infrastructure.gateway;

import com.lucasmoraist.payment_service.application.gateway.WebhookGateway;
import com.lucasmoraist.payment_service.domain.dto.WebhookContext;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class WebhookGatewayImpl implements WebhookGateway {

    private final String clientSecret;

    public WebhookGatewayImpl(@Value("${secrets.client.mercado-pago.webhook}") String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public void validateSignature(WebhookContext context) {
        long ts = Long.parseLong(context.signature().split(",")[0].split("=")[1]);
        String v1 = context.signature().split(",")[1].split("=")[1];

        String template = "id:%s;request-id:%s;ts:%s;";
        String signedTemplate = String.format(
                template,
                context.dataId(),
                context.requestId(),
                ts
        );
        log.info("Signed template: {}", signedTemplate);

        String cyphedSignature = new HmacUtils("HmacSHA256", clientSecret).hmacHex(signedTemplate);
        log.info("Cyphed signature: {}", cyphedSignature);

        if (!cyphedSignature.equals(v1)) {
            log.error("Invalid signature for webhook: {}", context);
            throw new RuntimeException("Invalid signature");
        }

        log.info("Signature validated successfully for webhook: {}", context);
    }

}
