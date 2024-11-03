package com.cupoftech.growwithme.sales.Infrastructure.Persistence.Jpa.Repositories;
import com.cupoftech.growwithme.sales.Domain.Model.Aggregates.SalesOrder;
import com.cupoftech.growwithme.sales.Domain.Model.ValueObjects.InvoiceId;
import com.cupoftech.growwithme.sales.Domain.Model.ValueObjects.RucFarmer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

    List <SalesOrder> findByRuc (RucFarmer ruc);

    boolean existsByInvoiceId(InvoiceId invoiceId);

}
