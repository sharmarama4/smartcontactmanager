package com.smart.smartcontactmanager.service;

import com.smart.smartcontactmanager.models.Category;
import com.smart.smartcontactmanager.models.Product;
import com.smart.smartcontactmanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    @Autowired
 private ProductRepository productRepository;


    public Product getProductByID(int id) {
        Optional optional = productRepository.findById(id);

        if (optional.isPresent()){
            return (Product) optional.get();
        }

        return null;
    }

    public List<Product> getProductsByCategory(Category category) {

        return productRepository.findProductByCategory(category);
    }

    public void addProduct(Product product) {

        productRepository.save(product);
    }
    public void deleteProduct(int id) {

        productRepository.deleteById(id);
    }



}


