package org.booking.bookingsystemapi.service.operationService;

import org.booking.bookingsystemapi.domain.Operation;

import java.util.List;

public interface OperationService {
    Operation fetchOperationById(Long id);

    List<Operation> fetchAllProviderOperations(Long providerId);

    Operation saveOperation(Operation operation, Long OperationId);

    Operation updateOperation(Long operationId, Operation updatedOperationBody);

    void deleteOperation(Long operationId);
}
