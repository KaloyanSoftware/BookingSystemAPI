package org.booking.bookingsystemapi.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_seq")
    @SequenceGenerator(name = "operation_seq", sequenceName = "operation_seq", allocationSize = 1)
    private Long id;

    private String operationName;

    @Enumerated(EnumType.STRING)
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
