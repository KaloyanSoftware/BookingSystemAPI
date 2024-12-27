package org.booking.bookingsystemapi.presentation.graphqlController;

import org.booking.bookingsystemapi.domain.Booking;
import org.booking.bookingsystemapi.service.bookingService.BookingService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    private final BookingService bookingService;

    public PostController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @QueryMapping
    public Booking bookingById(@Argument Integer id) {
        return bookingService.fetchBookingById(Long.parseLong(id.toString()));
    }

    @QueryMapping
    public List<Booking> bookings(@Argument Integer id) {
        return bookingService.fetchAllUserBookings(Long.parseLong(id.toString()));
    }
}
