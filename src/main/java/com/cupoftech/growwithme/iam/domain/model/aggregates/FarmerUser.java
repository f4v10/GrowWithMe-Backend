package com.cupoftech.growwithme.iam.domain.model.aggregates;

import com.cupoftech.growwithme.iam.domain.model.commands.farmer.CreateFarmerUserCommand;
import com.cupoftech.growwithme.iam.domain.model.valueobjects.EmailAddress;
import com.cupoftech.growwithme.iam.domain.model.valueobjects.PersonName;
import com.cupoftech.growwithme.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FarmerUser extends AuditableAbstractAggregateRoot<FarmerUser> {
    @Embedded
    private PersonName name;
    @Embedded
    private EmailAddress email;
    private String password;
    private String documentType;
    private String valueDocumentType;
    private String phone;

    public FarmerUser() {}

    public FarmerUser(String firstName, String lastName, String email, String password, String documentType, String valueDocumentType, String phone) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.password = password;
        this.documentType = documentType;
        this.valueDocumentType = valueDocumentType;
        this.phone = phone;
    }

    public FarmerUser(CreateFarmerUserCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.password = command.password();
        this.documentType = command.documentType();
        this.valueDocumentType = command.valueDocumentType();
        this.phone = command.phone();
    }
}
