package com.cupoftech.growwithme.iam.domain.model.aggregates;

import com.cupoftech.growwithme.iam.domain.model.commands.crop.CreateCropsCommand;
import com.cupoftech.growwithme.iam.domain.model.valueobjects.CropCode;
import com.cupoftech.growwithme.iam.domain.model.valueobjects.CropName;
import com.cupoftech.growwithme.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Crops extends AuditableAbstractAggregateRoot<Crops> {
    @Embedded
    private CropName name;
    @Embedded
    private CropCode code;
    private String status;
    private String cost;

    public Crops() {}

    public Crops(String Name, String code, String status, String cost) {
        this.name = new CropName(Name);
        this.code = new CropCode(code);
        this.status = status;
        this.cost = cost;
    }

    public Crops(CreateCropsCommand command) {
        this.name = new CropName(command.Name());
        this.code = new CropCode(command.code());
        this.status = command.status();
        this.cost = command.cost();
    }

    public String getFullName() {
        return this.name.getFullName();
    }
}