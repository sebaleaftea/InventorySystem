package com.example.Inventory_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory_System.Model.InventoryMovement;



public interface InventoryMovementRepository extends JpaRepository<InventoryMovement, Long>{

}
