package com.groupe2cs.bizyhub.categories.infrastructure.repository;

	import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
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
public interface CategoryRepository extends JpaRepository<Category, String> {

	@Query("SELECT e FROM Category e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Category> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Category e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Category> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM Category e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Category> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Category e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Category> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM Category e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByNameAndCreatedById(String name, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByNameAndTenantName(String name, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByNameAndTenantId(String name, String tenantId);
        @Query("SELECT e FROM Category e WHERE LOWER(e.typeCategoryRaw) LIKE LOWER(CONCAT('%', :typeCategoryRaw, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByTypeCategoryRawAndCreatedById(String typeCategoryRaw, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.typeCategoryRaw) LIKE LOWER(CONCAT('%', :typeCategoryRaw, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByTypeCategoryRawAndTenantName(String typeCategoryRaw, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.typeCategoryRaw) LIKE LOWER(CONCAT('%', :typeCategoryRaw, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByTypeCategoryRawAndTenantId(String typeCategoryRaw, String tenantId);
        @Query("SELECT e FROM Category e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByDetailsAndCreatedById(String details, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByDetailsAndTenantName(String details, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByDetailsAndTenantId(String details, String tenantId);
        @Query("SELECT e FROM Category e WHERE e.isActive = :isActive AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByIsActiveAndCreatedById(Boolean isActive, String createdById);
        @Query("SELECT e FROM Category e WHERE e.isActive = :isActive AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

        @Query("SELECT e FROM Category e WHERE e.isActive = :isActive AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByIsActiveAndTenantId(Boolean isActive, String tenantId);
        @Query("SELECT e FROM Category e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM Category e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByTenantIdAndTenantId(String tenant, String tenantId);




}
