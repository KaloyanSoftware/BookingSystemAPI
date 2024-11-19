package org.booking.bookingsystemapi.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "bookings")
public class Booking{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(name = "booking_seq", sequenceName = "booking_seq", allocationSize = 1)
    private Long id;

    private LocalDate bookedDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

    public Booking(LocalDate bookedDate, BookingStatus bookingStatus, User user, Operation operation) {
        this.bookedDate = bookedDate;
        this.bookingStatus = bookingStatus;
        this.user = user;
        this.operation = operation;
    }

    public Booking() {

    }
}
