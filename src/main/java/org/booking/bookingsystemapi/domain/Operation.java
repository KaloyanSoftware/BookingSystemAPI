package org.booking.bookingsystemapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Operation {
    @Id
    @GeneratedValue
    private Long id;

    private String operationName;

    private OperationType operationType;

    private String description;

    private Double price;

    @ManyToMany
    private List<User> servicedUsers;

    public Operation(String operationName, OperationType operationType, String description, Double price) {
        setOperationName(operationName);
        setOperationType(operationType);
        setDescription(description);
        setPrice(price);
        this.servicedUsers = new ArrayList<>();
    }

    public Operation() {

    }
}
