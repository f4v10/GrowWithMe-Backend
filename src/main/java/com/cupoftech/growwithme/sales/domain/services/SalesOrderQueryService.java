package com.cupoftech.growwithme.sales.domain.services;

import com.cupoftech.growwithme.sales.domain.model.aggregates.SalesOrder;
import com.cupoftech.growwithme.sales.domain.model.entities.SalesOrderItem;
import com.cupoftech.growwithme.sales.domain.model.queries.GetAllSalesOrdersQuery;
import com.cupoftech.growwithme.sales.domain.model.queries.GetSalesOrderItemsBySalesOrderId;
import com.cupoftech.growwithme.sales.domain.model.queries.GetSalesOrderByOrderIdQuery;
import com.cupoftech.growwithme.sales.domain.model.queries.GetSalesOrdersByCustomerIdQuery;

import java.util.List;
import java.util.Optional;

public interface SalesOrderQueryService {
    Optional<SalesOrder> handle (GetSalesOrderByOrderIdQuery query);
    List<SalesOrder> handle (GetAllSalesOrdersQuery query);
    List<SalesOrder> handle (GetSalesOrdersByCustomerIdQuery query);
    List <SalesOrderItem> handle (GetSalesOrderItemsBySalesOrderId query);


}
