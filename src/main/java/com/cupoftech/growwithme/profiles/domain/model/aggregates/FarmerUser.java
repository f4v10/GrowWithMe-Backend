package com.cupoftech.growwithme.profiles.domain.model.aggregates;

import com.cupoftech.growwithme.profiles.domain.model.commands.farmer.CreateFarmerUserCommand;
import com.cupoftech.growwithme.profiles.domain.model.valueobjects.EmailAddress;
import com.cupoftech.growwithme.profiles.domain.model.valueobjects.PersonName;
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
    private String phone;
    private String documentType;
    private String valueDocumentType;

    public FarmerUser() {}

    public FarmerUser(String firstName, String lastName, String email, String phone, String documentType, String valueDocumentType) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.phone = phone;
        this.documentType = documentType;
        this.valueDocumentType = valueDocumentType;
    }

    public FarmerUser(CreateFarmerUserCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.phone = command.phone();
        this.documentType = command.documentType();
        this.valueDocumentType = command.valueDocumentType();
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getEmailAddress() {
        return email.email();
    }
}
