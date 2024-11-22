package com.cupoftech.growwithme.sales.domain.model.commands;

import java.time.LocalDateTime;

public record CreateSalesOrderCommand(String ruc, LocalDateTime orderTimestamp, String invoiceId) {
}
