package org.booking.bookingsystemapi.service.bookingService;

import org.booking.bookingsystemapi.domain.Booking;
import java.util.List;

public interface BookingService {

    List<Booking> fetchAllUserOperationBookings(Long userId, Long operationId);

    List<Booking> fetchAllUserBookings(Long userId);

    Booking fetchBookingById(Long bookingId);

    Booking saveBooking(Long UserId, Long OperationId, Booking booking);

    Booking updateBooking(Booking currentBookingBody, Booking updateRequestBookingBody);

    void deleteBookingById(Long bookingId);
}
