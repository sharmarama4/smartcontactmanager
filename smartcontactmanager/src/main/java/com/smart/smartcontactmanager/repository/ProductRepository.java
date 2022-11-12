package com.smart.smartcontactmanager.repository;

import com.smart.smartcontactmanager.models.Category;
import com.smart.smartcontactmanager.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findProductByCategory(Category category);


}
