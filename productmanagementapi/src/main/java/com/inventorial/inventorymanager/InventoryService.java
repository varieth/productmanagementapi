package com.inventorial.inventorymanager;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    @Autowired
    private ProductRepo inventoryRepository;

    public Inventory getInventoryByProductIdAndCompanyId(String productId, Integer companyId) {
        System.out.println("Searching for productId: " + productId + ", companyId: " + companyId);
        return inventoryRepository.findByProductIdAndCompanyId(productId, companyId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Item not found with productId: " + productId + " and companyId: " + companyId));
    }
    
    public List<Inventory> getProductsByCompanyId(Integer companyId, Integer page, Integer itemsPerPage) {
    	Pageable topTwenty = PageRequest.of(page, itemsPerPage);
    	
        List<Inventory> products = inventoryRepository.findAllByCompanyId(companyId, topTwenty);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Items not found with companyId: " + companyId);
        }
        return products;
    }
    
    public Integer getProductsByCompanyId(Integer companyId) {
    	
        Integer productCount = inventoryRepository.findCountByCompanyId(companyId);
        return productCount;
    }
    
//    @Transactional(readOnly = false)
//    public List<Inventory> getProductsByCompanyId(Integer companyId, Integer page, Integer itemsPerPage) {
//    	
//        List<Inventory> products = inventoryRepository.findInventoryByCompanyId(companyId, page, itemsPerPage);
//        if (products.isEmpty()) {
//            throw new ResourceNotFoundException("Items not found with companyId: " + companyId);
//        }
//        return products;
//    }

    // Other service methods...
}
