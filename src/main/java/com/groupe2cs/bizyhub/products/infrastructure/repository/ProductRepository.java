package com.groupe2cs.bizyhub.products.infrastructure.repository;

import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    // @Query("SELECT t FROM Product t ")
    Page<Product> findAll(Pageable pageable);

    // @Query("SELECT t FROM Product t WHERE t.id = :id")
    Optional<Product> findById(Product id);

    @Query("SELECT t FROM Product t WHERE t.name = :name")
    List<Product> findByName(String name);

    @Query("SELECT t FROM Product t WHERE t.price = :price")
    List<Product> findByPrice(Double price);
}
