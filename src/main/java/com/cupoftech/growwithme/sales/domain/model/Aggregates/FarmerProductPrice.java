package com.cupoftech.growwithme.sales.domain.model.aggregates;
import com.cupoftech.growwithme.sales.domain.model.commands.CreateFarmerProductCommand;
import com.cupoftech.growwithme.sales.domain.model.valueobjects.Price;
import com.cupoftech.growwithme.sales.domain.model.valueobjects.ProductId;
import com.cupoftech.growwithme.sales.domain.model.valueobjects.QuantityProduct;
import com.cupoftech.growwithme.sales.domain.model.valueobjects.ValidityTimeFarmerProduct;
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
    @AttributeOverrides({
            @AttributeOverride(name= "money", column =@Column(name="product_price_money")),
            @AttributeOverride(name= "amount", column =@Column(name="product_price_amount"))
    })
    private Price price;

    @Embedded
    @AttributeOverrides(
            {@AttributeOverride(name= "validityTimeFarmerProduct", column =@Column(name="validity_time_farmer_product"))}
    )
    ValidityTimeFarmerProduct validityTimeFarmerProduct;

    @Embedded
    private QuantityProduct quantityProduct;

    public FarmerProductPrice(){
        this.quantityProduct = new QuantityProduct();
        this.productId = new ProductId();
        this.price = new Price();
        this.validityTimeFarmerProduct= new ValidityTimeFarmerProduct();
    }
    public FarmerProductPrice(String productId, String money, Long amount, LocalDateTime start, LocalDateTime end, Integer quantityProduct){
        this();
        this.productId = new ProductId(productId);
        this.price = new Price(money,amount);
        this.quantityProduct = new QuantityProduct(quantityProduct);
        this.validityTimeFarmerProduct = new ValidityTimeFarmerProduct(start,end);
    }
    public FarmerProductPrice (CreateFarmerProductCommand command){
        this.productId = new ProductId(command.productId());
        this.price = new Price(command.money(),command.amount());
        this.validityTimeFarmerProduct = new ValidityTimeFarmerProduct(command.start(),command.end());
        this.quantityProduct = new QuantityProduct(command.quantityProduct());
    }

    public FarmerProductPrice updateFarmerProductPriced(String money,Integer quantityProduct, Long amount){
        this.price = new Price(money,amount);
        this.quantityProduct = new QuantityProduct(quantityProduct);
        return this;
    }
    public FarmerProductPrice updateValidityTime(LocalDateTime start, LocalDateTime end){
        this.validityTimeFarmerProduct = new ValidityTimeFarmerProduct(start,end);
        return this;
    }



}
