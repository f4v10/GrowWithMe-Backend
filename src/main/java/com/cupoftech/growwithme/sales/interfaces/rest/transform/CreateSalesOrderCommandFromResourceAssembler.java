package com.cupoftech.growwithme.sales.interfaces.rest.transform;

import com.cupoftech.growwithme.sales.domain.model.commands.CreateSalesOrderCommand;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.CreateSalesOrderResource;

public class CreateSalesOrderCommandFromResourceAssembler {
    public static CreateSalesOrderCommand toCommandFromResource(CreateSalesOrderResource resource) {
        return new CreateSalesOrderCommand(resource.ruc(),resource.orderTimestamp(), resource.invoiceId());
    }
}
