package com.cupoftech.growwithme.sales.infrastructure.persistence.jpa.repositories;
import com.cupoftech.growwithme.sales.domain.model.aggregates.FarmerProductPrice;

import com.cupoftech.growwithme.sales.domain.model.valueobjects.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  FarmerProductRepository extends JpaRepository<FarmerProductPrice, Long> {
    boolean existsByProductId(ProductId productId);
}
