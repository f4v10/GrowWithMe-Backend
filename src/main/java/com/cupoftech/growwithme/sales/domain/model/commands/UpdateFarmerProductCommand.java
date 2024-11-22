package com.cupoftech.growwithme.sales.domain.model.commands;

import java.time.LocalDateTime;

public record UpdateFarmerProductCommand(Long farmerProductPriceId,String productId, String money,Integer quantityProduct, Long amount, LocalDateTime start, LocalDateTime end) {

}
