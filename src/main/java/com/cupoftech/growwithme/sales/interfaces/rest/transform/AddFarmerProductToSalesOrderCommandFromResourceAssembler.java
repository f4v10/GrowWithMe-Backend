package com.cupoftech.growwithme.sales.interfaces.rest.transform;

import com.cupoftech.growwithme.sales.domain.model.commands.AddFarmerProductToSalesOrderCommand;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.AddFarmerProductToSalesOrderResource;

public class AddFarmerProductToSalesOrderCommandFromResourceAssembler {
    public static AddFarmerProductToSalesOrderCommand toCommandFromResource(Long salesOrderId, AddFarmerProductToSalesOrderResource resource) {
        return new AddFarmerProductToSalesOrderCommand(salesOrderId, resource.farmerProductPriceId());
    }
}
