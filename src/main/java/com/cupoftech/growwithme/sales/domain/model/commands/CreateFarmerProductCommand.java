package com.cupoftech.growwithme.sales.domain.model.commands;

import java.time.LocalDateTime;

public record CreateFarmerProductCommand(String productId, String money, Long amount, LocalDateTime start, LocalDateTime end, Integer quantityProduct) {
}
