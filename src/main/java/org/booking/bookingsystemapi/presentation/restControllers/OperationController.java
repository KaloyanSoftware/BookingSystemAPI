package org.booking.bookingsystemapi.presentation.restControllers;

import org.booking.bookingsystemapi.service.operationService.OperationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {
    private OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

}
