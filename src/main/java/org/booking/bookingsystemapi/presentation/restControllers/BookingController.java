package org.booking.bookingsystemapi.presentation.restControllers;

import org.booking.bookingsystemapi.domain.Booking;
import org.booking.bookingsystemapi.service.bookingService.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users/{userId}/operations/{operationId}/bookings")
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(@PathVariable("userId") String userId,
                                                        @PathVariable("operationId") String operationId) {
        Set<Booking> bookings = bookingService.fetchAllBookings(Long.parseLong(userId), Long.parseLong(operationId));
        return ResponseEntity.ok(bookings.stream().toList());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("bookingId") String bookingId) {
        Booking booking = bookingService.fetchBookingById(Long.parseLong(bookingId));
        return ResponseEntity.ok(booking);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@PathVariable("userId") String userId,
                                                 @PathVariable("operationId") String operationId,
                                                 @RequestBody Booking bookingRequest) {
        Booking newBooking = bookingService.saveBooking(Long.parseLong(userId),Long.parseLong(operationId),bookingRequest);
        return ResponseEntity.ok(newBooking);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable("bookingId") String bookingId,
            @RequestBody Booking bookingRequest) {
        Booking updatedBooking = bookingService.updateBooking(bookingService.fetchBookingById(Long.parseLong(bookingId)), bookingRequest);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("bookingId") String bookingId) {
        bookingService.deleteBookingById(Long.parseLong(bookingId));
        return ResponseEntity.noContent().build();
    }
}
