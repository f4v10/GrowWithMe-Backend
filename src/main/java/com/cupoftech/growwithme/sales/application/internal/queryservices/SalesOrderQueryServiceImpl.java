package com.cupoftech.growwithme.sales.application.internal.queryservices;

import com.cupoftech.growwithme.sales.domain.model.aggregates.SalesOrder;
import com.cupoftech.growwithme.sales.domain.model.entities.SalesOrderItem;
import com.cupoftech.growwithme.sales.domain.model.queries.GetAllSalesOrdersQuery;
import com.cupoftech.growwithme.sales.domain.model.queries.GetSalesOrderItemsBySalesOrderId;
import com.cupoftech.growwithme.sales.domain.model.queries.GetSalesOrderByOrderIdQuery;
import com.cupoftech.growwithme.sales.domain.model.queries.GetSalesOrdersByCustomerIdQuery;
import com.cupoftech.growwithme.sales.domain.model.valueobjects.RucFarmer;
import com.cupoftech.growwithme.sales.domain.services.SalesOrderQueryService;
import com.cupoftech.growwithme.sales.infrastructure.persistence.jpa.repositories.SalesOrderRepository;
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
    public Optional<SalesOrder> handle(GetSalesOrderByOrderIdQuery query) {
        return salesOrderRepository.findById(query.salesOrderId());
    }

    @Override
    public List<SalesOrder> handle(GetAllSalesOrdersQuery query) {
        return salesOrderRepository.findAll();
    }

    @Override
    public List<SalesOrder> handle(GetSalesOrdersByCustomerIdQuery query) {
        return salesOrderRepository.findByRuc(new RucFarmer(query.ruc()));
    }

    @Override
    public List<SalesOrderItem> handle(GetSalesOrderItemsBySalesOrderId query) {

        return salesOrderRepository.findById(query.salesOrderId()).map(SalesOrder::getSalesOrderItems).orElse(null);
    }


}