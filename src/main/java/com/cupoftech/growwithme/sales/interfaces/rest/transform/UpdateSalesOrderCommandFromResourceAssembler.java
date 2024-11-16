package com.cupoftech.growwithme.sales.interfaces.rest.transform;

import com.cupoftech.growwithme.sales.domain.model.commands.UpdateSalesOrderCommand;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.UpdateSalesOrderResource;

public class UpdateSalesOrderCommandFromResourceAssembler {
    public static UpdateSalesOrderCommand toCommandFromResource(Long salesOrderId, UpdateSalesOrderResource resource) {
        return new UpdateSalesOrderCommand(salesOrderId,resource.ruc(), resource.orderTimestamp(), resource.invoiceId());
    }
}
