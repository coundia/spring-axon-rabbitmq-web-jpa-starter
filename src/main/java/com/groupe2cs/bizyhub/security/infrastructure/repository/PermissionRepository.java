package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
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
public interface PermissionRepository extends JpaRepository<Permission, String> {

	@Query("SELECT e FROM Permission e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Permission> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM Permission e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Permission> findByIdAndTenantId(String id, String tenantId);

	@Query("SELECT e FROM Permission e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Permission> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Permission e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Permission> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Permission e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Permission> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Permission e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Permission> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Permission e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Permission> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Permission e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Permission> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Permission e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Permission> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Permission e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Permission> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Permission e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Permission> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Permission e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Permission> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Permission e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Permission> findByTenantIdAndTenantId(String tenant, String tenantId);


}
