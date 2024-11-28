package org.booking.bookingsystemapi.service.operationService;

import org.booking.bookingsystemapi.domain.Operation;
import org.booking.bookingsystemapi.domain.OperationProvider;
import org.booking.bookingsystemapi.repository.OperationRepository;
import org.booking.bookingsystemapi.service.logDataService.LogDataService;
import org.booking.bookingsystemapi.service.operationProviderService.OperationProviderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OriginalOperationService implements OperationService {

    private OperationRepository operationRepository;

    private OperationProviderService operationProviderService;

    private LogDataService logDataService;

    public OriginalOperationService(OperationRepository operationRepository, OperationProviderService operationProviderService, LogDataService logDataService) {
        this.operationRepository = operationRepository;
        this.operationProviderService = operationProviderService;
        this.logDataService = logDataService;
    }

    @Override
    public Operation fetchOperationById(Long id) {
        logDataService.saveLogData("Operation","GET");
        return operationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Operation> fetchAllProviderOperations(Long providerId) {
        logDataService.saveLogData("Operation","GET");
        return operationProviderService.fetchProviderById(providerId).getOperations();
    }

    @Override
    public Operation saveOperation(Operation operation, Long providerId) {
        OperationProvider provider = operationProviderService.fetchProviderById(providerId);
        provider.getOperations().add(operation);
        logDataService.saveLogData("Operation","POST");
        return operationRepository.save(operation);
    }

    @Override
    public Operation updateOperation(Long operationId, Operation updateRequest) {
        Operation currentOperation = fetchOperationById(operationId);
        if (!Objects.equals(updateRequest.getOperationName(), currentOperation.getOperationName())
        && updateRequest.getOperationName() != null) {
            currentOperation.setOperationName(updateRequest.getOperationName());
        }

        if (!Objects.equals(updateRequest.getDescription(), currentOperation.getDescription())
        && updateRequest.getDescription() != null) {
            currentOperation.setDescription(updateRequest.getDescription());
        }

        if (!Objects.equals(updateRequest.getPrice(), currentOperation.getPrice())
        && updateRequest.getPrice() != null) {
            currentOperation.setPrice(updateRequest.getPrice());
        }

        if (!Objects.equals(updateRequest.getOperationType(), currentOperation.getOperationType())
        && updateRequest.getOperationType() != null) {
            currentOperation.setOperationType(updateRequest.getOperationType());
        }

        logDataService.saveLogData("Operation","PUT");
        return operationRepository.save(currentOperation);
    }

    @Override
    public void deleteOperation(Long operationId) {
        operationRepository.deleteById(operationId);
        logDataService.saveLogData("Operation","DELETE");
    }
}
