package org.booking.bookingsystemapi.presentation.restControllers;

import org.booking.bookingsystemapi.service.operationProviderService.OperationProviderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationProviderController {
    private OperationProviderService operationProviderService;

    public OperationProviderController(OperationProviderService operationProviderService) {
        this.operationProviderService = operationProviderService;
    }

}
