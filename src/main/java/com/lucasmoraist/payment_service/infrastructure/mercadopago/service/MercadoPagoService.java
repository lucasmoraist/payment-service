package com.lucasmoraist.payment_service.infrastructure.mercadopago.service;

import com.lucasmoraist.payment_service.application.gateway.MercadoPagoGateway;
import com.lucasmoraist.payment_service.domain.dto.Product;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class MercadoPagoService implements MercadoPagoGateway {

    private final PreferenceClient preferenceClient;

    @Override
    public String createCheckout(Product product) {
        List<PreferenceItemRequest> items = new ArrayList<>();

        PreferenceItemRequest itemRequest =
                PreferenceItemRequest.builder()
                        .title(product.title())
                        .description(product.description())
                        .pictureUrl(product.pictureUrl())
                        .quantity(product.quantity())
                        .currencyId("BRL")
                        .unitPrice(product.unitPrice())
                        .build();
        items.add(itemRequest);

        return this.createPreferenceClient(items);
    }

    @Override
    public String createCheckout(List<Product> products) {
        List<PreferenceItemRequest> items = new ArrayList<>();

        for (Product product : products) {
            PreferenceItemRequest itemRequest =
                    PreferenceItemRequest.builder()
                            .title(product.title())
                            .description(product.description())
                            .pictureUrl(product.pictureUrl())
                            .quantity(product.quantity())
                            .currencyId("BRL")
                            .unitPrice(product.unitPrice())
                            .build();
            items.add(itemRequest);
        }

        return this.createPreferenceClient(items);
    }

    private String createPreferenceClient(List<PreferenceItemRequest> items) {
        try {
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .build();
            log.info("Criando preferência de pagamento no Mercado Pago");

            Preference preference = this.preferenceClient.create(preferenceRequest);
            return preference.getSandboxInitPoint();
        } catch (MPException | MPApiException e) {
            log.error("Erro ao criar preferência de pagamento no Mercado Pago", e);
            throw new RuntimeException(e);
        }
    }

}
