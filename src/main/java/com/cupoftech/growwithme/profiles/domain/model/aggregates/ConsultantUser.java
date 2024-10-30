package com.cupoftech.growwithme.profiles.domain.model.aggregates;

import com.cupoftech.growwithme.profiles.domain.model.commands.consultant.CreateConsultantUserCommand;
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
public class ConsultantUser extends User {
    private String dni;

    public ConsultantUser() {}

    public ConsultantUser(String firstName, String lastName, String email, String phone, String dni) {
        super();
        this.setName(new PersonName(firstName, lastName));
        this.setEmail(new EmailAddress(email));
        this.setPhone(phone);
        this.dni = dni;
    }

    public ConsultantUser(CreateConsultantUserCommand command) {
        super();
        this.setName(new PersonName(command.firstName(), command.lastName()));
        this.setEmail(new EmailAddress(command.email()));
        this.setPhone(command.phone());
        this.dni = command.dni();
    }

    public String getFullName() {
        return super.getFullName();
    }

    public String getEmailAddress() {
        return super.getEmail().email();
    }
}
