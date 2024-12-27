package org.booking.bookingsystemapi.service.bookingService;

import lombok.extern.java.Log;
import org.booking.bookingsystemapi.domain.Booking;
import org.booking.bookingsystemapi.domain.Operation;
import org.booking.bookingsystemapi.domain.User;
import org.booking.bookingsystemapi.repository.BookingRepository;
import org.booking.bookingsystemapi.service.logDataService.LogDataService;
import org.booking.bookingsystemapi.service.operationService.OperationService;
import org.booking.bookingsystemapi.service.userService.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Log
@Service
public class OriginalBookingService implements BookingService {
    private BookingRepository bookingRepository;

    private UserService userService;

    private OperationService operationService;

    private LogDataService logDataService;

    public OriginalBookingService(BookingRepository bookingRepository,UserService userService, OperationService operationService, LogDataService logDataService) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.operationService = operationService;
        this.logDataService = logDataService;
    }

    @Override
    public List<Booking> fetchAllUserOperationBookings(Long userId, Long operationId) {
        User user = userService.fetchUserById(userId);
        Operation operation = operationService.fetchOperationById(operationId);
        logDataService.saveLogData("Booking","GET");
        return user.getBookings().stream().filter(booking -> booking.getOperation().equals(operation)).collect(Collectors.toList());
    }

    @Override
    public List<Booking> fetchAllUserBookings(Long userId) {
        return bookingRepository.getBookingByUserId(userId);
    }

    @Override
    public Booking fetchBookingById(Long bookingId) {
        logDataService.saveLogData("Booking","GET");
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override
    public Booking saveBooking(Long userId, Long operationId, Booking booking) {
        User user = userService.fetchUserById(userId);
        Operation operation = operationService.fetchOperationById(operationId);

        booking.setOperation(operation);

        user.addBooking(booking);
        booking.setUser(user);
        logDataService.saveLogData("Booking","POST");

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
        logDataService.saveLogData("Booking","PUT");
        return currentBookingBody;
    }

    @Override
    public void deleteBookingById(Long bookingId) {
        logDataService.saveLogData("Booking","DELETE");
        bookingRepository.deleteById(bookingId);
    }
}
