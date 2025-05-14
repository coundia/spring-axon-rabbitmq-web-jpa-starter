package com.groupe2cs.bizyhub.categories.infrastructure.repository;

import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

	@Query("SELECT e FROM Category e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<Category> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM Category e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByIdAndTenantId(String id, String tenantId);

	Page<Category> findByCreatedById(String createdById, Pageable pageable);

	Page<Category> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM Category e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Category> findByNameAndCreatedById(String name, String createdById);


	@Query("SELECT e FROM Category e WHERE e.name = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Category> findByName(String name);

	@Query("SELECT e FROM Category e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.typeCategoryRaw = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Category> findByTypeCategoryRawAndCreatedById(String typeCategoryRaw, String createdById);


	@Query("SELECT e FROM Category e WHERE e.typeCategoryRaw = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Category> findByTypeCategoryRaw(String typeCategoryRaw);

	@Query("SELECT e FROM Category e WHERE e.typeCategoryRaw = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByTypeCategoryRawAndTenantName(String typeCategoryRaw, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.typeCategoryRaw = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByTypeCategoryRawAndTenantId(String typeCategoryRaw, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.details = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Category> findByDetailsAndCreatedById(String details, String createdById);


	@Query("SELECT e FROM Category e WHERE e.details = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Category> findByDetails(String details);

	@Query("SELECT e FROM Category e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByDetailsAndTenantId(String details, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Category> findByIsActiveAndCreatedById(Boolean isActive, String createdById);


	@Query("SELECT e FROM Category e WHERE e.isActive = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Category> findByIsActive(Boolean isActive);

	@Query("SELECT e FROM Category e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Category> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);


	@Query("SELECT e FROM Category e WHERE e.updatedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Category> findByUpdatedAt(java.time.Instant updatedAt);

	@Query("SELECT e FROM Category e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Category> findByReferenceAndCreatedById(String reference, String createdById);


	@Query("SELECT e FROM Category e WHERE e.reference = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Category> findByReference(String reference);

	@Query("SELECT e FROM Category e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Category> findByCreatedByIdAndCreatedById(String createdBy, String createdById);


	@Query("SELECT e FROM Category e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Category> findByCreatedById(String createdBy);

	@Query("SELECT e FROM Category e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Category> findByTenantIdAndCreatedById(String tenant, String createdById);


	@Query("SELECT e FROM Category e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Category> findByTenantId(String tenant);

	@Query("SELECT e FROM Category e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Category> findByTenantIdAndTenantId(String tenant, String tenantId);


}
