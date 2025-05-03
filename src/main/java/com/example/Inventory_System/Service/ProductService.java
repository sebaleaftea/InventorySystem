package com.example.Inventory_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Inventory_System.Model.Product;
import com.example.Inventory_System.Repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //Metodos de lista productos,busqueda por id, guardar y eliminar productos
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }
    
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    //Metodo para calcular el valor total de un producto en el inventario
public double calculateTotalValue(Long productId) {
        //Se verifica si existe el producto en el inventario ,busqueda por id
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("El producto con ID " + productId + " no existe."));
    
    // Calculo del producto por precio y stock
        return product.getPrice() * product.getStock();
    }
}

