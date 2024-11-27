package org.booking.bookingsystemapi.presentation.restControllers;

import org.booking.bookingsystemapi.domain.Operation;
import org.booking.bookingsystemapi.service.operationService.OperationService;
import org.springframework.http.HttpStatus;
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
    public String retrieveOperation(@PathVariable("id") String id) {
        return operationService.fetchOperationById(Long.parseLong(id)).toString();
    }

    @PostMapping
    public ResponseEntity<String> saveOperation(@PathVariable String providerId, @RequestBody Operation operation) {
        try {
            operationService.saveOperation(operation,Long.parseLong(providerId));
            return new ResponseEntity<>("Provider data successfully received and processed.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing provider data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateProvider(@PathVariable("providerId") String id, @RequestBody Operation updateRequestOperation) {
        try {
            operationService.updateOperation(Long.parseLong(id), updateRequestOperation);
            return new ResponseEntity<>("User data successfully received and processed.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing user data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOperation(@PathVariable("id") String id) {
        try {
            operationService.deleteOperation(Long.parseLong(id));
            return new ResponseEntity<>("User data successfully received and processed.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing user data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
