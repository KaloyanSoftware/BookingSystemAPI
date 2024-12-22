package org.booking.bookingsystemapi.presentation.graphqlController;

import org.booking.bookingsystemapi.service.bookingService.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    private final BookingService bookingService;

    public PostController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
}
