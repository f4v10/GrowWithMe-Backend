package com.cupoftech.growwithme.sales.infrastructure.persistence.jpa.repositories;
import com.cupoftech.growwithme.sales.domain.model.aggregates.SalesOrder;
import com.cupoftech.growwithme.sales.domain.model.valueobjects.InvoiceId;
import com.cupoftech.growwithme.sales.domain.model.valueobjects.RucFarmer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

    List <SalesOrder> findByRuc (RucFarmer ruc);

    boolean existsByInvoiceId(InvoiceId invoiceId);

}
