package com.cupoftech.growwithme.sales.Domain.Model.Commands;

public record RemoveProductFromSalesOrderCommand(Long SalesOrderId, Long farmerProductPriceId) {
}
