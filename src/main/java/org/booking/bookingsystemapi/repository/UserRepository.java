package org.booking.bookingsystemapi.repository;

import org.booking.bookingsystemapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}