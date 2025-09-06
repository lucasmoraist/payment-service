package com.lucasmoraist.payment_service.domain.dto;

import java.math.BigDecimal;

public record Product(
        String title,
        String description,
        String pictureUrl,
        int quantity,
        BigDecimal unitPrice
) {

}
