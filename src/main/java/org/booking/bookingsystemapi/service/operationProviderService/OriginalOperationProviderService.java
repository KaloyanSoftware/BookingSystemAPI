package org.booking.bookingsystemapi.service.operationProviderService;

import org.booking.bookingsystemapi.repository.OperationProviderRepository;
import org.springframework.stereotype.Service;

@Service
public class OriginalOperationProviderService implements OperationProviderService {
    private OperationProviderRepository operationProviderRepository;

    public OriginalOperationProviderService(OperationProviderRepository operationProviderRepository) {
        this.operationProviderRepository = operationProviderRepository;
    }
}
