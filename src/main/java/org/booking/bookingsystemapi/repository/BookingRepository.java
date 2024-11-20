package org.booking.bookingsystemapi.repository;

import org.booking.bookingsystemapi.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
