package org.booking.bookingsystemapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class OperationProvider {
    @Id
    @GeneratedValue
    private Long id;

    private String providerName;

    private String providerEmail;

    @OneToMany
    private List<Operation> operations;

    public OperationProvider(String providerName, String providerEmail) {
        setProviderName(providerName);
        setProviderEmail(providerEmail);
        this.operations = new ArrayList<>();
    }

    public OperationProvider() {

    }
}
