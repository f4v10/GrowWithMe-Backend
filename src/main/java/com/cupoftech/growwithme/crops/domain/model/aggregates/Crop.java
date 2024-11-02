package com.cupoftech.growwithme.crops.domain.model.aggregates;

import com.cupoftech.growwithme.crops.domain.model.commands.CreateCropCommand;
import com.cupoftech.growwithme.crops.domain.model.valueobjects.CropCode;
import com.cupoftech.growwithme.crops.domain.model.valueobjects.CropName;
import com.cupoftech.growwithme.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Crop extends AuditableAbstractAggregateRoot<Crop> {
    @Embedded
    private CropName name;
    @Embedded
    private CropCode code;
    private String status;
    private String cost;

    public Crop() {}

    public Crop(String Name, String code, String status, String cost) {
        this.name = new CropName(Name);
        this.code = new CropCode(code);
        this.status = status;
        this.cost = cost;
    }

    public Crop(CreateCropCommand command) {
        this.name = new CropName(command.name());
        this.code = new CropCode(command.code());
        this.status = command.status();
        this.cost = command.cost();
    }
}