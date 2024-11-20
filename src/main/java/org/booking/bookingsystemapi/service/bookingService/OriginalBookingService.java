package org.booking.bookingsystemapi.service.bookingService;

import org.booking.bookingsystemapi.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class OriginalBookingService implements BookingService {
    private BookingRepository bookingRepository;

    public OriginalBookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
}
