package org.booking.bookingsystemapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Operation bookedOperation;

    private LocalDate bookedDate;

    private BookingStatus bookingStatus;

    public Booking(Operation bookedOperation, LocalDate bookedDate, BookingStatus bookingStatus) {
        setBookedOperation(bookedOperation);
        setBookedDate(bookedDate);
        setBookingStatus(bookingStatus);
    }

    public Booking() {

    }
}
