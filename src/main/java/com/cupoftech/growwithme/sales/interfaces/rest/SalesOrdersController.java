package com.cupoftech.growwithme.sales.interfaces.rest;

import com.cupoftech.growwithme.sales.domain.model.commands.AddFarmerProductToSalesOrderCommand;
import com.cupoftech.growwithme.sales.domain.model.commands.DeleteSalesOrderCommand;
import com.cupoftech.growwithme.sales.domain.model.queries.GetAllSalesOrdersQuery;
import com.cupoftech.growwithme.sales.domain.model.queries.GetSalesOrderItemsBySalesOrderId;
import com.cupoftech.growwithme.sales.domain.model.queries.GetSalesOrderByOrderIdQuery;
import com.cupoftech.growwithme.sales.domain.services.SalesOrderCommandService;
import com.cupoftech.growwithme.sales.domain.services.SalesOrderQueryService;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.CreateSalesOrderResource;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.SalesOrderItemResource;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.SalesOrderResource;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.UpdateSalesOrderResource;
import com.cupoftech.growwithme.sales.interfaces.rest.transform.CreateSalesOrderCommandFromResourceAssembler;
import com.cupoftech.growwithme.sales.interfaces.rest.transform.SalesOrderFromEntityAssembler;
import com.cupoftech.growwithme.sales.interfaces.rest.transform.SalesOrderItemFromResourceFromEntityAssembler;
import com.cupoftech.growwithme.sales.interfaces.rest.transform.UpdateSalesOrderCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sales-orders", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "SalesOrder", description = "Sales Order Management Endpoints")
public class SalesOrdersController {
    private final SalesOrderCommandService salesOrderCommandService;
    private final SalesOrderQueryService salesOrderQueryService;

    public SalesOrdersController(SalesOrderCommandService salesOrderCommandService, SalesOrderQueryService salesOrderQueryService) {
        this.salesOrderCommandService = salesOrderCommandService;
        this.salesOrderQueryService = salesOrderQueryService;
    }

    @PostMapping
    public ResponseEntity<SalesOrderResource> createSalesOrder(@RequestBody CreateSalesOrderResource resource) {
        if (resource.orderTimestamp() == null) {
            return ResponseEntity.badRequest().build();
        }
        var createSalesOrderCommand = CreateSalesOrderCommandFromResourceAssembler.toCommandFromResource(resource);
        var salesOrder = salesOrderCommandService.handle(createSalesOrderCommand);
        if(salesOrder.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var salesOrderResource = SalesOrderFromEntityAssembler.toResourceFromEntity(salesOrder.get());

        return new ResponseEntity<>(salesOrderResource, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<SalesOrderResource>> getSalesOrder() {
        var getAllSalesOrderQuery = new GetAllSalesOrdersQuery();
        var salesOrder = salesOrderQueryService.handle(getAllSalesOrderQuery);
        var salesOrderResource = salesOrder.stream().map(SalesOrderFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(salesOrderResource);

    }

    @GetMapping("/{salesOrderId}")
    public ResponseEntity<SalesOrderResource> getSalesOrderById(@PathVariable Long salesOrderId) {
        var getSalesOrderQuery = new GetSalesOrderByOrderIdQuery(salesOrderId);
        var salesOrder = salesOrderQueryService.handle(getSalesOrderQuery);
        if(salesOrder.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var salesOrderResource = SalesOrderFromEntityAssembler.toResourceFromEntity(salesOrder.get());
        return ResponseEntity.ok(salesOrderResource);
    }

    @PutMapping("/{salesOrderId}")
    public ResponseEntity<SalesOrderResource> updateSalesOrder(@PathVariable Long salesOrderId,@RequestBody UpdateSalesOrderResource resource) {
        var updateSalesOrder = UpdateSalesOrderCommandFromResourceAssembler.toCommandFromResource(salesOrderId, resource);
        var salesOrder =salesOrderCommandService.handle(updateSalesOrder);
        if(salesOrder.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var salesOrderResource = SalesOrderFromEntityAssembler.toResourceFromEntity(salesOrder.get());
        return ResponseEntity.ok(salesOrderResource);

    }

    @DeleteMapping("/{salesOrderId}")
    public ResponseEntity<?> deleteSalesOrder(@PathVariable Long salesOrderId) {
        var deleteSalesOrderCommand = new DeleteSalesOrderCommand(salesOrderId);
        salesOrderCommandService.handle(deleteSalesOrderCommand);
        return ResponseEntity.ok("SalesOrder with given id successfully deleted");
    }

    @PutMapping("/{salesOrderId}/items/{farmerProductPriceId}")
    public ResponseEntity <SalesOrderItemResource> AddFarmerProductToSalesOrder(@PathVariable Long farmerProductPriceId, @PathVariable Long salesOrderId){
        salesOrderCommandService.handle(new AddFarmerProductToSalesOrderCommand(salesOrderId,farmerProductPriceId));
        var salesOrderByOrderIdQuery = new GetSalesOrderItemsBySalesOrderId(salesOrderId);

        var salesOrderItem = salesOrderQueryService.handle(salesOrderByOrderIdQuery);
        if(salesOrderItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            var salesOrderItemResource = SalesOrderItemFromResourceFromEntityAssembler.toResourceFromEntity(salesOrderItem.getFirst());
            return ResponseEntity.ok(salesOrderItemResource);
        }

    }

}
