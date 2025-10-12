// Spring Data repository for ProductImage with helpers and batch lookup by product IDs.
package com.groupe2cs.bizyhub.products.infrastructure.repository;

import com.groupe2cs.bizyhub.products.infrastructure.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String> {
	List<ProductImage> findByProductIdOrderByUpdatedAtAuditDescCreatedAtAuditDesc(String productId);

	// New: batch query to avoid N+1 on listing
	List<ProductImage> findByProductIdIn(Collection<String> productIds);

	void deleteByProductId(String value);
}
