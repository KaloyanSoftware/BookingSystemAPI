package org.booking.bookingsystemapi.repository;

import org.booking.bookingsystemapi.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
