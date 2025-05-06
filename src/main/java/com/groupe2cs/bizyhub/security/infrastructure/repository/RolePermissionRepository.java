package com.groupe2cs.bizyhub.security.infrastructure.repository;

	import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
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
public interface RolePermissionRepository extends JpaRepository<RolePermission, String> {

	@Query("SELECT e FROM RolePermission e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<RolePermission> findByIdAndCreatedById(String id, String createdById);
	Page<RolePermission> findByCreatedById(String createdById, Pageable pageable);
	Page<RolePermission> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM RolePermission e WHERE e.role.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<RolePermission> findByRoleIdAndCreatedById(String role, String createdById);

	@Query("SELECT e FROM RolePermission e WHERE e.role.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<RolePermission> findByRoleIdAndTenantName(String role, String tenantName);

	@Query("SELECT e FROM RolePermission e WHERE e.role.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<RolePermission> findByRoleIdAndTenantId(String role, String tenantId);
	@Query("SELECT e FROM RolePermission e WHERE e.permission.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<RolePermission> findByPermissionIdAndCreatedById(String permission, String createdById);

	@Query("SELECT e FROM RolePermission e WHERE e.permission.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<RolePermission> findByPermissionIdAndTenantName(String permission, String tenantName);

	@Query("SELECT e FROM RolePermission e WHERE e.permission.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<RolePermission> findByPermissionIdAndTenantId(String permission, String tenantId);
	@Query("SELECT e FROM RolePermission e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<RolePermission> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM RolePermission e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<RolePermission> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM RolePermission e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<RolePermission> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
	@Query("SELECT e FROM RolePermission e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<RolePermission> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM RolePermission e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<RolePermission> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM RolePermission e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<RolePermission> findByTenantIdAndTenantId(String tenant, String tenantId);




}
