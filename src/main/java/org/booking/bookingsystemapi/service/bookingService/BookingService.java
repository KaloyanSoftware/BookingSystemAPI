package org.booking.bookingsystemapi.service.bookingService;

import org.booking.bookingsystemapi.domain.Booking;
import java.util.Set;

public interface BookingService {

    Set<Booking> fetchAllBookings(Long userId, Long operationId);

    Booking fetchBookingById(Long bookingId);

    Booking saveBooking(Long UserId, Long OperationId, Booking booking);

    Booking updateBooking(Booking currentBookingBody, Booking updateRequestBookingBody);

    void deleteBookingById(Long bookingId);
}
