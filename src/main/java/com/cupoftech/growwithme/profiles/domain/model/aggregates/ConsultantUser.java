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
public class ConsultantUser extends AuditableAbstractAggregateRoot<ConsultantUser> {
    @Embedded
    private PersonName name;
    @Embedded
    private EmailAddress email;
    private String phone;
    private String dni;

    public ConsultantUser() {}

    public ConsultantUser(String firstName, String lastName, String email, String phone, String dni) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.phone = phone;
        this.dni = dni;
    }

    public ConsultantUser(CreateConsultantUserCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.phone = command.phone();
        this.dni = command.dni();
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getEmailAddress() {
        return email.email();
    }
}
