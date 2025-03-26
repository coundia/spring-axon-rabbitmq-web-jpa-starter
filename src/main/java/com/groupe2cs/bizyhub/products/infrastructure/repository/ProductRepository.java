package com.groupe2cs.bizyhub.products.infrastructure.repository;

import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Page<Product> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}

