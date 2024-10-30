package com.cupoftech.growwithme.profiles.domain.model.aggregates;

import com.cupoftech.growwithme.profiles.domain.model.commands.farmer.CreateFarmerUserCommand;
import com.cupoftech.growwithme.profiles.domain.model.valueobjects.EmailAddress;
import com.cupoftech.growwithme.profiles.domain.model.valueobjects.PersonName;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FarmerUser extends User {
    private String documentType;
    private String valueDocumentType;

    public FarmerUser() {}

    public FarmerUser(String firstName, String lastName, String email, String phone, String documentType, String valueDocumentType) {
        super();
        this.setName(new PersonName(firstName, lastName));
        this.setEmail(new EmailAddress(email));
        this.setPhone(phone);
        this.documentType = documentType;
        this.valueDocumentType = valueDocumentType;
    }

    public FarmerUser(CreateFarmerUserCommand command) {
        super();
        this.setName(new PersonName(command.firstName(), command.lastName()));
        this.setEmail(new EmailAddress(command.email()));
        this.setPhone(command.phone());
        this.documentType = command.documentType();
        this.valueDocumentType = command.valueDocumentType();
    }

    public String getFullName() {
        return super.getFullName();
    }

    public String getEmailAddress() {
        return super.getEmail().email();
    }
}
