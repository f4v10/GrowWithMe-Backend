package com.cupoftech.growwithme.sales.Interfaces.REST.Transform;

import com.cupoftech.growwithme.sales.Domain.Model.Entities.SalesOrderItem;
import com.cupoftech.growwithme.sales.Interfaces.REST.Resources.SalesOrderItemResource;

public class SalesOrderItemFromResourceFromEntityAssembler {
    public static SalesOrderItemResource toResourceFromEntity(SalesOrderItem entity) {
        return new SalesOrderItemResource(entity.getId(), entity.getFarmerProductPrice().getId());
    }
}
