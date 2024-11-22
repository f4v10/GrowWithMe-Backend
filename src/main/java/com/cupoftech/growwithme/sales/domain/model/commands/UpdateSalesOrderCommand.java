package com.cupoftech.growwithme.sales.domain.model.commands;

import java.time.LocalDateTime;

public record UpdateSalesOrderCommand(Long SalesOrderId, String ruc, LocalDateTime orderTimestamp, String invoiceId ) {
}
