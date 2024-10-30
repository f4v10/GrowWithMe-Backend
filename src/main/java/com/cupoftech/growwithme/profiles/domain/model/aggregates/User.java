package com.cupoftech.growwithme.profiles.domain.model.aggregates;

import com.cupoftech.growwithme.profiles.domain.model.valueobjects.EmailAddress;
import com.cupoftech.growwithme.profiles.domain.model.valueobjects.PersonName;
import com.cupoftech.growwithme.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends AuditableAbstractAggregateRoot<User> {
    @Embedded
    private PersonName name;
    @Embedded
    private EmailAddress email;
    private String phone;

    public String getFullName() {
        return this.name.getFullName();
    }

    public String getEmailAddress() {
        return this.email.email();
    }
}
