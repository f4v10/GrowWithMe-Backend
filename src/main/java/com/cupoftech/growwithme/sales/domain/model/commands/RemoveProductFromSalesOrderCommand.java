package com.cupoftech.growwithme.sales.domain.model.commands;

public record RemoveProductFromSalesOrderCommand(Long SalesOrderId, Long farmerProductPriceId) {
}
