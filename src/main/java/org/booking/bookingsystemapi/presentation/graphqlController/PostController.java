package org.booking.bookingsystemapi.presentation.graphqlController;

import org.booking.bookingsystemapi.domain.Booking;
import org.booking.bookingsystemapi.domain.Operation;
import org.booking.bookingsystemapi.service.bookingService.BookingService;
import org.booking.bookingsystemapi.service.operationService.OperationService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    private final BookingService bookingService;
    private final OperationService operationService;

    public PostController(BookingService bookingService, OperationService operationService) {
        this.bookingService = bookingService;
        this.operationService = operationService;
    }

    @QueryMapping
    public Booking bookingById(@Argument Integer id) {
        return bookingService.fetchBookingById(Long.parseLong(id.toString()));
    }

    @QueryMapping
    public List<Booking> bookings(@Argument Integer userId) {
        return bookingService.fetchAllUserBookings(Long.parseLong(userId.toString()));
    }

    @SchemaMapping
    public Operation operationById(@Argument Integer operationId) {
        return operationService.fetchOperationById(Long.parseLong(operationId.toString()));
    }
}