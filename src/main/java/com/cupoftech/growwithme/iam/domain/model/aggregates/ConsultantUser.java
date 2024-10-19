package com.cupoftech.growwithme.iam.domain.model.aggregates;

import com.cupoftech.growwithme.iam.domain.model.commands.consultant.CreateConsultantUserCommand;
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
public class ConsultantUser extends AuditableAbstractAggregateRoot<ConsultantUser> {
    @Embedded
    private PersonName name;
    @Embedded
    private EmailAddress email;
    private String password;
    private String dni;
    private String phone;

    public ConsultantUser() {}

    public ConsultantUser(String firstName, String lastName, String email, String password, String dni, String phone) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.password = password;
        this.dni = dni;
        this.phone = phone;
    }

    public ConsultantUser(CreateConsultantUserCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.password = command.password();
        this.dni = command.dni();
        this.phone = command.phone();
    }

    public String getFullName() {
        return this.name.getFullName();
    }
}
