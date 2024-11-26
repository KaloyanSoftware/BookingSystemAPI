package org.booking.bookingsystemapi.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.boot.model.source.spi.ForeignKeyContributingSource;
import org.hibernate.type.ForeignKeyDirection;

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "operation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Operation operation;

    public Booking(LocalDate bookedDate, BookingStatus bookingStatus) {
        this.bookedDate = bookedDate;
        this.bookingStatus = bookingStatus;
    }

    public Booking() {

    }
}
