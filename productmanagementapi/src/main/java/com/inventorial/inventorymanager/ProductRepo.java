package com.inventorial.inventorymanager;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Inventory, String> {

    @Query("SELECT i FROM Inventory i WHERE i.productId = :productId AND i.companyId = :companyId")
    Optional<Inventory> findByProductIdAndCompanyId(@Param("productId") String productId, @Param("companyId") Integer companyId);
    
    @Query("SELECT i FROM Inventory i WHERE i.companyId = :companyId")
    List<Inventory> findAllByCompanyId(@Param("companyId") Integer companyId, Pageable topTwenty);


    @Query("SELECT COUNT(i.productId) FROM Inventory i WHERE i.companyId = :companyId")
    Integer findCountByCompanyId(@Param("companyId") Integer companyId);

    
//    @Procedure(procedureName = "GetInventoryByCompanyId")
//    List<Inventory> findInventoryByCompanyId(
//            @Param("companyIdParam") Integer companyId, 
//            @Param("offsetParam") Integer offset, 
//            @Param("limitParam") Integer limit
//    );
}
