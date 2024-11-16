package com.cupoftech.growwithme.sales.interfaces.rest.transform;

import com.cupoftech.growwithme.sales.domain.model.aggregates.SalesOrder;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.SalesOrderResource;

import java.util.List;

public class SalesOrderFromEntityAssembler {
    public static SalesOrderResource toResourceFromEntity(SalesOrder entity) {
        List<Long> farmerProductPriceIds = entity.getSalesOrderItems().stream()
                .map(SalesOrderItem-> SalesOrderItem.getFarmerProductPrice().getId())
                .toList();
        return new SalesOrderResource(entity.getId(), entity.getRuc().ruc(), entity.getOrderTimestamp().dateTime(), entity.getInvoiceId(),farmerProductPriceIds);

    }
}
