package com.cupoftech.growwithme.sales.Interfaces.REST.Transform;

import com.cupoftech.growwithme.sales.Domain.Model.Aggregates.SalesOrder;
import com.cupoftech.growwithme.sales.Interfaces.REST.Resources.SalesOrderResource;

import java.util.List;
import java.util.stream.Collectors;

public class SalesOrderFromEntityAssembler {
    public static SalesOrderResource toResourceFromEntity(SalesOrder entity) {
        List<Long> farmerProductPriceIds = entity.getSalesOrderItems().stream()
                .map(SalesOrderItem-> SalesOrderItem.getFarmerProductPrice().getId())
                .toList();
        return new SalesOrderResource(entity.getId(), entity.getRuc().ruc(), entity.getOrderTimestamp().dateTime(), entity.getInvoiceId().InvoiceId(),farmerProductPriceIds);

    }
}
