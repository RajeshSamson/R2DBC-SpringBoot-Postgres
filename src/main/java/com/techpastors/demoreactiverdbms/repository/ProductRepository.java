package com.techpastors.demoreactiverdbms.repository;

import com.techpastors.demoreactiverdbms.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}
