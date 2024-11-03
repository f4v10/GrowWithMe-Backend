package com.cupoftech.growwithme.sales.Domain.Model.Commands;

public record AddFarmerProductToSalesOrderCommand(Long salesOrderId, Long farmerProductPriceId) {
}
