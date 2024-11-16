package org.booking.bookingsystemapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    public Operation(String operationName, OperationType operationType, String description, Double price) {
        setOperationName(operationName);
        setOperationType(operationType);
        setDescription(description);
        setPrice(price);
    }

    public Operation() {

    }
}
