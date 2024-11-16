package com.cupoftech.growwithme.sales.interfaces.rest.resources;

import java.time.LocalDateTime;

public record UpdateFarmerProductPriceResource(Long id, String productId, String money, Integer quantityProduct, Long amount, LocalDateTime start, LocalDateTime end) {
}
