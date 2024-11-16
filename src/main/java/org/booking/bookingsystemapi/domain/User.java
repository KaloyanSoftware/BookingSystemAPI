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
public class User {
    @Setter
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    @ManyToMany
    private List<Operation> bookedOperations;

    public User(String firstName, String lastName, String email, String phone) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        this.bookedOperations = new ArrayList<>();
    }

    public User() {

    }
}