package org.booking.bookingsystemapi.repository;

import org.booking.bookingsystemapi.domain.LogData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogDataRepository extends MongoRepository<LogData, String> {
}
