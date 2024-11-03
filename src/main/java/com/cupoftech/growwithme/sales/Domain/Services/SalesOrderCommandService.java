package com.cupoftech.growwithme.sales.Domain.Services;

import com.cupoftech.growwithme.sales.Domain.Model.Aggregates.SalesOrder;
import com.cupoftech.growwithme.sales.Domain.Model.Commands.*;

import java.util.List;
import java.util.Optional;

public interface SalesOrderCommandService {
    Optional<SalesOrder> handle(CreateSalesOrderCommand command);
    Optional<SalesOrder> handle(UpdateSalesOrderCommand command);
    void handle(CancelSalesOrderCommand command);
    void handle(AddFarmerProductToSalesOrderCommand command);
    void handle(RemoveProductFromSalesOrderCommand command);
}
