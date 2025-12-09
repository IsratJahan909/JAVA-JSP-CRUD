package com.example.product.service;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private final ProductRepository repository;

    public ProductService() {
        this.repository = new ProductRepository();
    }

    // CREATE
    public Product createProduct(Product product) {
        // Add any business logic/validation before saving
        if (product.getPrice().doubleValue() <= 0) {
            System.err.println("Product price must be positive.");
            return null;
        }
        return repository.save(product);
    }

    // READ All
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // READ By ID
    public Optional<Product> getProductById(int id) {
        return repository.findById(id);
    }

    // UPDATE
    public Optional<Product> updateProduct(int id, Product updatedProduct) {
        Optional<Product> existingProduct = repository.findById(id); // Use repository method
        if (existingProduct.isPresent()) {
            updatedProduct.setId(id);
            if (repository.update(updatedProduct)) {
                return Optional.of(updatedProduct);
            }
        }
        return Optional.empty();
    }

    // DELETE
    public boolean deleteProduct(int id) {
        return repository.delete(id);
    }
}
