package com.cupoftech.growwithme.sales.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateSalesOrderResource(String ruc, LocalDateTime orderTimestamp, String invoiceId) {
}
