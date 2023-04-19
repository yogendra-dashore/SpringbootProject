package com.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.ProductsEntity;

@Repository
public interface ProductsRepo extends CrudRepository<ProductsEntity, Integer>{

	List<ProductsEntity> findAll();

	List<ProductsEntity> findByName(String name);

	ProductsEntity save(Integer id);
	
	
	
}
