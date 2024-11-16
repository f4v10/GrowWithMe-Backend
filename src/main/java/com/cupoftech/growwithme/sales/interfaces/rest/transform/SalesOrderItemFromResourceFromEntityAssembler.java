package com.cupoftech.growwithme.sales.interfaces.rest.transform;

import com.cupoftech.growwithme.sales.domain.model.entities.SalesOrderItem;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.SalesOrderItemResource;

public class SalesOrderItemFromResourceFromEntityAssembler {
    public static SalesOrderItemResource toResourceFromEntity(SalesOrderItem entity) {
        return new SalesOrderItemResource(entity.getId(), entity.getFarmerProductPrice().getId());
    }
}
