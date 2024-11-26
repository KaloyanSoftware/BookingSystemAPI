package org.booking.bookingsystemapi.service.bookingService;

import org.booking.bookingsystemapi.domain.Booking;
import org.booking.bookingsystemapi.domain.Operation;
import org.booking.bookingsystemapi.domain.User;
import org.booking.bookingsystemapi.repository.BookingRepository;
import org.booking.bookingsystemapi.service.operationService.OperationService;
import org.booking.bookingsystemapi.service.userService.UserService;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OriginalBookingService implements BookingService {
    private BookingRepository bookingRepository;

    private UserService userService;

    private OperationService operationService;

    public OriginalBookingService(BookingRepository bookingRepository,UserService userService, OperationService operationService) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.operationService = operationService;
    }

    @Override
    public Set<Booking> fetchAllBookings(Long userId, Long operationId) {
        return userService.fetchUserById(userId).getBookings().stream()
                .filter(operation -> operation.getId().equals(operationId)).collect(Collectors.toSet());
    }

    @Override
    public Booking fetchBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override
    public Booking saveBooking(Long userId, Long operationId, Booking booking) {
        User user = userService.fetchUserById(userId);
        Operation operation = operationService.fetchOperationById(operationId);

        user.getBookings().add(booking);

        booking.setUser(user);
        booking.setOperation(operation);

        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Booking currentBookingBody, Booking updateRequestBookingBody) {
        if (!Objects.equals(currentBookingBody.getBookedDate(), updateRequestBookingBody.getBookedDate())
        && updateRequestBookingBody.getBookedDate() != null) {
            currentBookingBody.setBookedDate(updateRequestBookingBody.getBookedDate());
        }
        if (!Objects.equals(currentBookingBody.getBookingStatus(), updateRequestBookingBody.getBookingStatus())
        && updateRequestBookingBody.getBookingStatus() != null) {
            currentBookingBody.setBookingStatus(updateRequestBookingBody.getBookingStatus());
        }

        // Save the updated entity
        bookingRepository.save(currentBookingBody);
        return currentBookingBody;
    }

    @Override
    public void deleteBookingById(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
