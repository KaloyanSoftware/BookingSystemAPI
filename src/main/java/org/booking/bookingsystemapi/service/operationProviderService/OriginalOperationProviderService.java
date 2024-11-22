package org.booking.bookingsystemapi.service.operationProviderService;

import org.booking.bookingsystemapi.domain.OperationProvider;
import org.booking.bookingsystemapi.repository.OperationProviderRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OriginalOperationProviderService implements OperationProviderService {
    private OperationProviderRepository operationProviderRepository;

    public OriginalOperationProviderService(OperationProviderRepository operationProviderRepository) {
        this.operationProviderRepository = operationProviderRepository;
    }


    @Override
    public OperationProvider fetchProviderById(Long id) {
        return operationProviderRepository.findById(id).orElse(null);
    }

    @Override
    public OperationProvider saveProvider(OperationProvider operationProvider) {
        return operationProviderRepository.save(operationProvider);
    }

    @Override
    public void updateProvider(OperationProvider currentProviderBody, OperationProvider updateRequestProviderBody) {
        if (!Objects.equals(currentProviderBody.getProviderName(), updateRequestProviderBody.getProviderName())) {
            currentProviderBody.setProviderName(updateRequestProviderBody.getProviderName());
        }
        if (!Objects.equals(currentProviderBody.getProviderEmail(), updateRequestProviderBody.getProviderEmail())) {
            currentProviderBody.setProviderEmail(updateRequestProviderBody.getProviderEmail());
        }

        // Save the updated entity
        operationProviderRepository.save(currentProviderBody);
    }


    @Override
    public void deleteProviderById(Long id) {
        operationProviderRepository.deleteById(id);
    }
}
