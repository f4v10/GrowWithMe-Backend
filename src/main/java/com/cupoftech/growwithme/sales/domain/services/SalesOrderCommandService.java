package com.cupoftech.growwithme.sales.domain.services;

import com.cupoftech.growwithme.sales.domain.model.aggregates.SalesOrder;
import com.cupoftech.growwithme.sales.domain.model.commands.*;

import java.util.Optional;

public interface SalesOrderCommandService {
    Optional<SalesOrder> handle(CreateSalesOrderCommand command);
    Optional<SalesOrder> handle(UpdateSalesOrderCommand command);
    void handle(DeleteSalesOrderCommand command);
    void handle(AddFarmerProductToSalesOrderCommand command);
    void handle(RemoveProductFromSalesOrderCommand command);
    void handle(PendSalesOrderCommand command);
    void handle(ConfirmSalesOrderCommand command);
    void handle(RejectSalesOrderCommand command);
    void handle(CancelSalesOrderCommand command);
}
