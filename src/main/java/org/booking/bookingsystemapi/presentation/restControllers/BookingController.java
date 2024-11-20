package org.booking.bookingsystemapi.presentation.restControllers;

import org.booking.bookingsystemapi.service.bookingService.BookingService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
}
