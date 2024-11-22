package com.cupoftech.growwithme.sales.domain.model.commands;

public record AddFarmerProductToSalesOrderCommand(Long salesOrderId, Long farmerProductPriceId) {
}
