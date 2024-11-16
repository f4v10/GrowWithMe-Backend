package com.cupoftech.growwithme.sales.interfaces.rest.resources;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record SalesOrderResource(Long id,String ruc, LocalDateTime orderTimestamp, String invoiceId, List<Long> farmerProductPriceIds) {
    public SalesOrderResource(Long id, String ruc, LocalDateTime orderTimestamp, String invoiceId) {
        this(id, ruc, orderTimestamp, invoiceId, new ArrayList<>());

    }

}
