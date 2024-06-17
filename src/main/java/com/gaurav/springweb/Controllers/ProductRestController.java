package com.gaurav.springweb.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.springweb.entities.Product;
import com.gaurav.springweb.repos.ProductRepository;

import jakarta.persistence.Cacheable;
import jakarta.transaction.Transactional;

@RestController
public class ProductRestController {
	
	@Autowired
	ProductRepository repository;
	
	@RequestMapping(value="/products/",method=RequestMethod.GET)
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/products/{Id}",method=RequestMethod.GET)
	@Transactional
	public Product getProduct(@PathVariable("Id") int Id) {
		return repository.findById(Id).get();	
		}
	@RequestMapping(value="/products/",method=RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@RequestMapping(value="/products/",method=RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@RequestMapping(value="/products/{Id}",method=RequestMethod.DELETE)
	@CacheEvict("product-cache")
	public void deleteProduct(@PathVariable("Id") int Id) {
	    repository.deleteById(Id);	
		}
}
