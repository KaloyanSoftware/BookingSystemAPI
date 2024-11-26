package org.booking.bookingsystemapi.domain;

import jakarta.persistence.*;
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
@Table(name = "operation_providers")
public class OperationProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opProv_seq")
    @SequenceGenerator(name = "opProv_seq", sequenceName = "opProv_seq", allocationSize = 1)
    private Long id;

    private String providerName;

    private String providerEmail;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="provider_id")
    private List<Operation> operations;

    public OperationProvider(String providerName, String providerEmail) {
        setProviderName(providerName);
        setProviderEmail(providerEmail);
        this.operations = new ArrayList<>();
    }

    public OperationProvider() {

    }
}
