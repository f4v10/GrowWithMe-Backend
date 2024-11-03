package com.cupoftech.growwithme.sales.Application.Internal.QueryServices;

import com.cupoftech.growwithme.sales.Domain.Model.Aggregates.SalesOrder;
import com.cupoftech.growwithme.sales.Domain.Model.Entities.SalesOrderItem;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.GetAllSalesOrderQuery;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.GetSalesOrderItemsBySalesOrderId;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.SalesOrderByOrderIdQuery;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.SalesOrdersByCustomerIdQuery;
import com.cupoftech.growwithme.sales.Domain.Model.ValueObjects.RucFarmer;
import com.cupoftech.growwithme.sales.Domain.Services.SalesOrderQueryService;
import com.cupoftech.growwithme.sales.Infrastructure.Persistence.Jpa.Repositories.SalesOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SalesOrderQueryServiceImpl implements SalesOrderQueryService {
    private final SalesOrderRepository salesOrderRepository;

    public SalesOrderQueryServiceImpl(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    @Override
    public Optional<SalesOrder> handle(SalesOrderByOrderIdQuery query) {
        return salesOrderRepository.findById(query.salesOrderId());
    }

    @Override
    public List<SalesOrder> handle(GetAllSalesOrderQuery query) {
        return salesOrderRepository.findAll();
    }

    @Override
    public List<SalesOrder> handle(SalesOrdersByCustomerIdQuery query) {
        return salesOrderRepository.findByRuc(new RucFarmer(query.ruc()));
    }

    @Override
    public List<SalesOrderItem> handle(GetSalesOrderItemsBySalesOrderId query) {

        return salesOrderRepository.findById(query.salesOrderId()).map(SalesOrder::getSalesOrderItems).orElse(null);
    }


}