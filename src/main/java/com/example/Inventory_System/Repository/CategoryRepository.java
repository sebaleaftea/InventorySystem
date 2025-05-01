package com.example.Inventory_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory_System.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
