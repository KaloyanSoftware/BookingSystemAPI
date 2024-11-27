package org.booking.bookingsystemapi.service.bookingService;

import lombok.extern.java.Log;
import org.booking.bookingsystemapi.domain.Booking;
import org.booking.bookingsystemapi.domain.Operation;
import org.booking.bookingsystemapi.domain.User;
import org.booking.bookingsystemapi.repository.BookingRepository;
import org.booking.bookingsystemapi.service.operationService.OperationService;
import org.booking.bookingsystemapi.service.userService.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Log
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
    public List<Booking> fetchAllUserOperationBookings(Long userId, Long operationId) {
        User user = userService.fetchUserById(userId);
        Operation operation = operationService.fetchOperationById(operationId);
        return user.getBookings().stream().filter(booking -> booking.getOperation().equals(operation)).collect(Collectors.toList());
    }

    @Override
    public Booking fetchBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override
    public Booking saveBooking(Long userId, Long operationId, Booking booking) {
        User user = userService.fetchUserById(userId);
        Operation operation = operationService.fetchOperationById(operationId);

        booking.setOperation(operation);

        user.addBooking(booking);
        booking.setUser(user);

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
