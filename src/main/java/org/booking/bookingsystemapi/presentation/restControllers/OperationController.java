package org.booking.bookingsystemapi.presentation.restControllers;

import org.booking.bookingsystemapi.domain.Operation;
import org.booking.bookingsystemapi.service.operationService.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bookingApi/providers/{providerId}/services")
public class OperationController {
    private OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public List<Operation> retrieveAllProviderOperations(@PathVariable String providerId) {
        return operationService.fetchAllProviderOperations(Long.parseLong(providerId));
    }

    @GetMapping("{id}")
    public ResponseEntity<Operation> retrieveOperation(@PathVariable("id") String id) {
        return ResponseEntity.ok(operationService.fetchOperationById(Long.parseLong(id)));
    }

    @PostMapping
    public ResponseEntity<Operation> saveOperation(@PathVariable String providerId, @RequestBody Operation operation) {
        return ResponseEntity.ok(operationService.saveOperation(operation,Long.parseLong(providerId)));
    }

    @PutMapping("{id}")
    public ResponseEntity<Operation> updateOperation(@PathVariable("id") String id, @RequestBody Operation updateRequestOperation) {
            return ResponseEntity.ok(operationService.updateOperation(Long.parseLong(id), updateRequestOperation));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOperation(@PathVariable("id") String id) {
        operationService.deleteOperation(Long.parseLong(id));
        return ResponseEntity.noContent().build();
    }



}
