package com.cupoftech.growwithme.sales.Domain.Services;

import com.cupoftech.growwithme.sales.Domain.Model.Aggregates.SalesOrder;
import com.cupoftech.growwithme.sales.Domain.Model.Entities.SalesOrderItem;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.GetAllSalesOrderQuery;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.GetSalesOrderItemsBySalesOrderId;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.SalesOrderByOrderIdQuery;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.SalesOrdersByCustomerIdQuery;

import java.util.List;
import java.util.Optional;

public interface SalesOrderQueryService {
    Optional<SalesOrder> handle (SalesOrderByOrderIdQuery query);
    List<SalesOrder> handle (GetAllSalesOrderQuery query);
    List<SalesOrder> handle (SalesOrdersByCustomerIdQuery query);
    List <SalesOrderItem> handle (GetSalesOrderItemsBySalesOrderId query);


}
