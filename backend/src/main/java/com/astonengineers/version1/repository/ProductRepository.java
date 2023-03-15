package com.astonengineers.version1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.astonengineers.version1.model.Product;
/**
 * This class represent Product Repository which handles all CRUD operations
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
