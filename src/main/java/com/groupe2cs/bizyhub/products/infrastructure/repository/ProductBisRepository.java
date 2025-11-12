package com.groupe2cs.bizyhub.products.infrastructure.repository;

import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBisRepository
		extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {

	Page<Product> findByStatusesIgnoreCaseOrderByUpdatedAtAuditDescCreatedAtAuditDesc(String status, Pageable pageable);


}
