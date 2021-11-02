package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Product;
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByDivision(String searchKeyword);
	Product findBypname(String searchKeyword);
}
