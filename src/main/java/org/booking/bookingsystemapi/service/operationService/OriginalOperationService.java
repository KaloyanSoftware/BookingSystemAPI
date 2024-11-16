package org.booking.bookingsystemapi.service.operationService;

import org.booking.bookingsystemapi.repository.OperationRepository;
import org.springframework.stereotype.Service;

@Service
public class OriginalOperationService implements OperationService {

    private OperationRepository operationRepository;

    public OriginalOperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }
}
