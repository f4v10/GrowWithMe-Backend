package com.cupoftech.growwithme.sales.Interfaces.REST.Transform;

import com.cupoftech.growwithme.sales.Domain.Model.Commands.AddFarmerProductToSalesOrderCommand;
import com.cupoftech.growwithme.sales.Interfaces.REST.Resources.AddFarmerProductToSalesOrderResource;

public class AddFarmerProductToSalesOrderCommandFromResourceAssembler {
    public static AddFarmerProductToSalesOrderCommand toCommandFromResource(Long salesOrderId, AddFarmerProductToSalesOrderResource resource) {
        return new AddFarmerProductToSalesOrderCommand(salesOrderId, resource.farmerProductPriceId());
    }
}
