package com.quan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quan.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
