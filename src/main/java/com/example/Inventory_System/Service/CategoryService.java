package com.example.Inventory_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Inventory_System.Model.Category;
import com.example.Inventory_System.Model.Product;
import com.example.Inventory_System.Repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category>findall(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }

    //Metodo para verificar si un producto es menor al un valor minimo dado
    //(osea que no esta en el stock de inventario)
    public boolean productWithLowStock(Long categoryId, int minStock) {

    Category category = categoryRepository.findById(categoryId)
        .orElseThrow(() -> new RuntimeException("Category not found"));


    if (category.getProducts() == null || category.getProducts().isEmpty()) {
        return false; 
    }

    
    for (Product product : category.getProducts()) {
        if (product.getStock() < minStock) {
            return true; 
        }
    }

    return false;
}


}
