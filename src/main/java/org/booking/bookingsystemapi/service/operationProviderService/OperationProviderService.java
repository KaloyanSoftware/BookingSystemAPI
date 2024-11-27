package org.booking.bookingsystemapi.service.operationProviderService;

import org.booking.bookingsystemapi.domain.OperationProvider;

import java.util.List;

public interface OperationProviderService {
    OperationProvider fetchProviderById(Long id);

    List<OperationProvider> fetchAllProviders();

    OperationProvider saveProvider(OperationProvider operationProvider);

    void updateProvider(OperationProvider currentProviderBody, OperationProvider updateRequestProviderBody);

    void deleteProviderById(Long id);
}
