package com.cupoftech.growwithme.sales.interfaces.rest.resources;

import java.time.LocalDateTime;

public record FarmerProductPriceResource(Long id, String productId, String money, Long amount, LocalDateTime start, LocalDateTime end, Integer quantityProduct) {
}
