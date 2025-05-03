package com.example.Inventory_System.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Inventory_System.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}