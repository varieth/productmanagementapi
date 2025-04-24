package com.inventorial.inventorymanager;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory/v1.0")
public class ProductController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/item/{productId}/{companyId}")
    public ResponseEntity<Inventory> getItemByProductIdAndCompanyId(
            @PathVariable String productId,
            @PathVariable Integer companyId) {
        System.out.println("Request received for productId: " + productId + ", companyId: " + companyId);
        Inventory item = inventoryService.getInventoryByProductIdAndCompanyId(productId, companyId);
        return ResponseEntity.ok(item);
    }
    
    @GetMapping("/item/{companyId}/products")
    public ResponseEntity<List<Inventory>> getAllProductsByCompanyId(@PathVariable Integer companyId, @RequestParam Integer page, @RequestParam Integer itemsPerPage) {
        List<Inventory> items = inventoryService.getProductsByCompanyId(companyId, page, itemsPerPage);
        return ResponseEntity.ok(items);
    }
    
    @GetMapping("/item/{companyId}/productCount")
    public ResponseEntity<Integer> getProductsByCompanyId(@PathVariable Integer companyId) {
    	Integer items = inventoryService.getProductsByCompanyId(companyId);
        return ResponseEntity.ok(items);
    }

    // Other controller methods...
}
