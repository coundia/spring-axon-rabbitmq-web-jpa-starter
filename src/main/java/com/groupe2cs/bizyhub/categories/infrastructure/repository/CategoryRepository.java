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

	@Query("SELECT e FROM Category e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByIdAndCreatedById(String id, String createdById);

	Page<Category> findByCreatedById(String createdById, Pageable pageable);

	Page<Category> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Category e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Category> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Category e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.typeCategory = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Category> findByTypeCategoryAndCreatedById(String typeCategory, String createdById);

	@Query("SELECT e FROM Category e WHERE e.typeCategory = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByTypeCategoryAndTenantName(String typeCategory, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.typeCategory = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByTypeCategoryAndTenantId(String typeCategory, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.parentId = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Category> findByParentIdAndCreatedById(String parentId, String createdById);

	@Query("SELECT e FROM Category e WHERE e.parentId = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByParentIdAndTenantName(String parentId, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.parentId = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByParentIdAndTenantId(String parentId, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.isDefault = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Category> findByIsDefaultAndCreatedById(Boolean isDefault, String createdById);

	@Query("SELECT e FROM Category e WHERE e.isDefault = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByIsDefaultAndTenantName(Boolean isDefault, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.isDefault = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByIsDefaultAndTenantId(Boolean isDefault, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.icon = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Category> findByIconAndCreatedById(String icon, String createdById);

	@Query("SELECT e FROM Category e WHERE e.icon = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByIconAndTenantName(String icon, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.icon = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByIconAndTenantId(String icon, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.colorHex = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Category> findByColorHexAndCreatedById(String colorHex, String createdById);

	@Query("SELECT e FROM Category e WHERE e.colorHex = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByColorHexAndTenantName(String colorHex, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.colorHex = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByColorHexAndTenantId(String colorHex, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Category> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Category e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Category> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Category e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Category> findByTenantIdAndTenantId(String tenant, String tenantId);


}
