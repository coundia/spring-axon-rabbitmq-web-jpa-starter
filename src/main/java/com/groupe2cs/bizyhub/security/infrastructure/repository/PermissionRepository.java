package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

	@Query("SELECT e FROM Permission e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Permission> findByIdAndCreatedById(String id, String createdById);

	Page<Permission> findByCreatedById(String createdById, Pageable pageable);

	Page<Permission> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Permission e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Permission> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Permission e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Permission> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Permission e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Permission> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Permission e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Permission> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Permission e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Permission> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Permission e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Permission> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Permission e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Permission> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Permission e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Permission> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Permission e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Permission> findByTenantIdAndTenantId(String tenant, String tenantId);


}
