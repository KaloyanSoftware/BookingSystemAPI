package org.booking.bookingsystemapi.service.operationProviderService;

import org.booking.bookingsystemapi.domain.OperationProvider;

public interface OperationProviderService {
    OperationProvider fetchProviderById(Long id);

    OperationProvider saveProvider(OperationProvider operationProvider);

    void updateProvider(OperationProvider currentProviderBody, OperationProvider updateRequestProviderBody);

    void deleteProviderById(Long id);
}
