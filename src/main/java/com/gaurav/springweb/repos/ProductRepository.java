package com.gaurav.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurav.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
