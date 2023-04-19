package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductsEntity;
import com.repo.ProductsRepo;

@RestController
public class ProductsController {

	
	@Autowired
	ProductsRepo productsRepo;
	
	@PostMapping("/addProduct")
	public ProductsEntity addProduct(@RequestBody ProductsEntity product) {
		
		productsRepo.save(product);
		return product;
		
		
	} 
	
	@GetMapping("/product")
	public List<ProductsEntity> getAllProducts(){
		return productsRepo.findAll();
		
	}
	
	@GetMapping("/productbyname/{Id}")
	public ProductsEntity getProductById(@PathVariable("Id") Integer Id) {
		Optional<ProductsEntity> proOptional = productsRepo.findById(Id);
		
		if(proOptional.isEmpty()) {
			return null;
		}
		else {
			return proOptional.get();
		}
		
	}
	
	@GetMapping("/productByName/{name}")
	public List<ProductsEntity> getproductByName(@PathVariable("name") String name){
		
		return productsRepo.findByName(name);
	}
	
	@DeleteMapping("/product/{Id}")
	public ProductsEntity deleteById(@PathVariable("Id") Integer Id) {
		
		ProductsEntity productsEntity = productsRepo.findById(Id).get();
		productsRepo.deleteById(Id);
		return productsEntity;
	}
	
	
	@PutMapping("/update/{Id}")
	public ProductsEntity updateById(@PathVariable("Id") Integer Id) {
		
		ProductsEntity productsEntity = productsRepo.save(Id);
		productsRepo.save(Id);
		return productsEntity;
	}
	
	
	
	
	
	
}
