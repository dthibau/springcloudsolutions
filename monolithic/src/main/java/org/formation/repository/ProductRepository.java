package org.formation.repository;

import java.util.List;

import org.formation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findByNameContainingIgnoreCase(String name);
}
