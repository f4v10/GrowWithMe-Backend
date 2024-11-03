package com.cupoftech.growwithme.sales.Domain.Model.Aggregates;
import com.cupoftech.growwithme.sales.Domain.Model.Commands.CreateFarmerProductCommand;
import com.cupoftech.growwithme.sales.Domain.Model.ValueObjects.Price;
import com.cupoftech.growwithme.sales.Domain.Model.ValueObjects.ProductId;
import jakarta.persistence.Id;
import com.cupoftech.growwithme.sales.Domain.Model.ValueObjects.quantityProduct;
import com.cupoftech.growwithme.sales.Domain.Model.ValueObjects.ValidityTimeFarmerProduct;
import com.cupoftech.growwithme.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class FarmerProductPrice extends AuditableAbstractAggregateRoot<FarmerProductPrice> {

    @Embedded
    private ProductId productId;
    @Embedded
    @AttributeOverrides(
            {@AttributeOverride(name= "money", column =@Column(name="product_price_money")),
                    @AttributeOverride(name= "amount", column =@Column(name="product_price_amount"))}
    )
    private Price price;
    @Embedded
    @AttributeOverrides(
            {@AttributeOverride(name= "validityTimeFarmerProduct", column =@Column(name="validity_time_farmer_product"))}
    )
    ValidityTimeFarmerProduct validityTimeFarmerProduct;

    private Long quantityProduct;
    public FarmerProductPrice(){
        this.quantityProduct=0L;
        this.productId = new ProductId();
        this.price = new Price();
        this.validityTimeFarmerProduct= new ValidityTimeFarmerProduct();
    }
    public FarmerProductPrice(Long productId, String money, Long amount, LocalDateTime start, LocalDateTime end,Long quantityProduct){
        this();
        this.productId = new ProductId(productId);
        this.price = new Price(money,amount);
        this.quantityProduct =quantityProduct;
        this.validityTimeFarmerProduct = new ValidityTimeFarmerProduct(start,end);
    }
    public FarmerProductPrice (CreateFarmerProductCommand command){
        this();
        this.productId = new ProductId(command.productId());
        this.price = new Price(command.money(),command.amount());
        this.validityTimeFarmerProduct = new ValidityTimeFarmerProduct(command.start(),command.end());
        this.quantityProduct = command.quantityProduct();
    }

    public FarmerProductPrice updateFarmerProductPriced(String money,Long quantityProduct, Long amount){
        this.price = new Price(money,amount);
        this.quantityProduct = quantityProduct;
        return this;
    }
    public FarmerProductPrice updateValidityTime(LocalDateTime start, LocalDateTime end){
        this.validityTimeFarmerProduct = new ValidityTimeFarmerProduct(start,end);
        return this;
    }



}
