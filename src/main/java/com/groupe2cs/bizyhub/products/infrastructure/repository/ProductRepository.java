package com.groupe2cs.bizyhub.products.infrastructure.repository;

	import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import java.time.*;
import java.util.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	@Query("SELECT e FROM Product e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<Product> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Product e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByIdAndTenantId(String id, String tenantId);

	Page<Product> findByCreatedById(String createdById, Pageable pageable);
	Page<Product> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM Product e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Product> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Product e WHERE e.name = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Product> findByName(String name);

	@Query("SELECT e FROM Product e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Product e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Product e WHERE e.price = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Product> findByPriceAndCreatedById(Double price, String createdById);

	@Query("SELECT e FROM Product e WHERE e.price = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Product> findByPrice(Double price);

	@Query("SELECT e FROM Product e WHERE e.price = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByPriceAndTenantName(Double price, String tenantName);

	@Query("SELECT e FROM Product e WHERE e.price = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByPriceAndTenantId(Double price, String tenantId);

	@Query("SELECT e FROM Product e WHERE e.details = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Product> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM Product e WHERE e.details = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Product> findByDetails(String details);

	@Query("SELECT e FROM Product e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM Product e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByDetailsAndTenantId(String details, String tenantId);

	@Query("SELECT e FROM Product e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Product> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM Product e WHERE e.isActive = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Product> findByIsActive(Boolean isActive);

	@Query("SELECT e FROM Product e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM Product e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM Product e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Product> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);

	@Query("SELECT e FROM Product e WHERE e.updatedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Product> findByUpdatedAt(java.time.Instant updatedAt);

	@Query("SELECT e FROM Product e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM Product e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);

	@Query("SELECT e FROM Product e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Product> findByReferenceAndCreatedById(String reference, String createdById);

	@Query("SELECT e FROM Product e WHERE e.reference = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Product> findByReference(String reference);

	@Query("SELECT e FROM Product e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Product e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM Product e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Product> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Product e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Product> findByCreatedById(String createdBy);

	@Query("SELECT e FROM Product e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Product e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Product e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Product> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Product e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Product> findByTenantId(String tenant);

	@Query("SELECT e FROM Product e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Product e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Product> findByTenantIdAndTenantId(String tenant, String tenantId);




}
