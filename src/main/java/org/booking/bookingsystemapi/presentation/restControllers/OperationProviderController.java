package org.booking.bookingsystemapi.presentation.restControllers;

import org.booking.bookingsystemapi.domain.OperationProvider;
import org.booking.bookingsystemapi.service.operationProviderService.OperationProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookingApi/providers")
public class OperationProviderController {
    private OperationProviderService operationProviderService;

    public OperationProviderController(OperationProviderService operationProviderService) {
        this.operationProviderService = operationProviderService;
    }

    @GetMapping("{id}")
    public String retrieveOperationProvider(@PathVariable("id") String id) {
        return operationProviderService.fetchProviderById(Long.parseLong(id)).toString();
    }

    @PostMapping
    public ResponseEntity<String> saveOperationProvider(@RequestBody OperationProvider operationProvider) {
        try {
            operationProviderService.saveProvider(operationProvider);
            return new ResponseEntity<>("Provider data successfully received and processed.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing provider data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateProvider(@PathVariable("id") String id, @RequestBody OperationProvider updateRequestProvider) {
        try {
            operationProviderService.updateProvider(operationProviderService.fetchProviderById(Long.parseLong(id)), updateRequestProvider);
            return new ResponseEntity<>("User data successfully received and processed.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing user data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProvider(@PathVariable("id") String id) {
        try {
            operationProviderService.deleteProviderById(Long.parseLong(id));
            return new ResponseEntity<>("User data successfully received and processed.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing user data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
