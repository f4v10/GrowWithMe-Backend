package com.cupoftech.growwithme.sales.Domain.Model.Commands;

import java.time.LocalDateTime;

public record UpdateSalesOrderCommand(Long SalesOrderId, Long ruc, LocalDateTime orderTimestamp, String invoiceId ) {
}
