package org.booking.bookingsystemapi.presentation.restControllers;

import org.booking.bookingsystemapi.domain.OperationProvider;
import org.booking.bookingsystemapi.service.operationProviderService.OperationProviderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bookingApi/providers")
public class OperationProviderController {
    private OperationProviderService operationProviderService;

    public OperationProviderController(OperationProviderService operationProviderService) {
        this.operationProviderService = operationProviderService;
    }

    @GetMapping
    public ResponseEntity<List<OperationProvider>> retrieveOperationProviders() {
        List<OperationProvider> allProviders = operationProviderService.fetchAllProviders();
        return ResponseEntity.ok(allProviders);
    }

    @GetMapping("{id}")
    public ResponseEntity<OperationProvider> retrieveOperationProvider(@PathVariable("id") String id) {
        OperationProvider provider = operationProviderService.fetchProviderById(Long.parseLong(id));
        return ResponseEntity.ok(provider);
    }

    @PostMapping
    public ResponseEntity<OperationProvider> saveOperationProvider(@RequestBody OperationProvider operationProvider) {
        return ResponseEntity.ok(operationProviderService.saveProvider(operationProvider));
    }

    @PutMapping("{id}")
    public ResponseEntity<OperationProvider> updateProvider(@PathVariable("id") String id, @RequestBody OperationProvider updateRequestProvider) {
        return ResponseEntity.ok(operationProviderService.updateProvider(operationProviderService.fetchProviderById(Long.parseLong(id)), updateRequestProvider));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable("id") String id) {
        operationProviderService.deleteProviderById(Long.parseLong(id));
        return ResponseEntity.noContent().build();
    }
}
