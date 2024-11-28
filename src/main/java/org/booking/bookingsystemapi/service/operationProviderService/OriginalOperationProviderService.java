package org.booking.bookingsystemapi.service.operationProviderService;

import org.booking.bookingsystemapi.domain.OperationProvider;
import org.booking.bookingsystemapi.repository.OperationProviderRepository;
import org.booking.bookingsystemapi.service.logDataService.LogDataService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OriginalOperationProviderService implements OperationProviderService {
    private OperationProviderRepository operationProviderRepository;

    private LogDataService logDataService;

    public OriginalOperationProviderService(OperationProviderRepository operationProviderRepository, LogDataService logDataService) {
        this.operationProviderRepository = operationProviderRepository;
        this.logDataService = logDataService;
    }


    @Override
    public OperationProvider fetchProviderById(Long id) {
        logDataService.saveLogData("OperationProvider","GET");
        return operationProviderRepository.findById(id).orElse(null);
    }

    @Override
    public List<OperationProvider> fetchAllProviders() {
        logDataService.saveLogData("OperationProvider","GET");
        return operationProviderRepository.findAll();
    }

    @Override
    public OperationProvider saveProvider(OperationProvider operationProvider) {
        logDataService.saveLogData("OperationProvider","POST");
        return operationProviderRepository.save(operationProvider);
    }

    @Override
    public OperationProvider updateProvider(OperationProvider currentProviderBody, OperationProvider updateRequestProviderBody) {
        if (!Objects.equals(currentProviderBody.getProviderName(), updateRequestProviderBody.getProviderName())
        && updateRequestProviderBody.getProviderName() != null) {
            currentProviderBody.setProviderName(updateRequestProviderBody.getProviderName());
        }
        if (!Objects.equals(currentProviderBody.getProviderEmail(), updateRequestProviderBody.getProviderEmail())
        && updateRequestProviderBody.getProviderEmail() != null) {
            currentProviderBody.setProviderEmail(updateRequestProviderBody.getProviderEmail());
        }

        // Save the updated entity
        logDataService.saveLogData("OperationProvider","PUT");
        return operationProviderRepository.save(currentProviderBody);
    }


    @Override
    public void deleteProviderById(Long id) {
        logDataService.saveLogData("OperationProvider","DELETE");
        operationProviderRepository.deleteById(id);
    }
}
