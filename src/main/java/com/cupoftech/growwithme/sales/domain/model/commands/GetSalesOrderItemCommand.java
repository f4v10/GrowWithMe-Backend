package com.cupoftech.growwithme.sales.domain.model.commands;

import com.cupoftech.growwithme.sales.domain.model.entities.SalesOrderItem;

public record GetSalesOrderItemCommand(SalesOrderItem item) {
}
