package com.cupoftech.growwithme.sales.Infrastructure.Persistence.Jpa.Repositories;
import com.cupoftech.growwithme.sales.Domain.Model.Aggregates.FarmerProductPrice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  FarmerProductRepository extends JpaRepository<FarmerProductPrice, Long> {
}
