package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, String> {

	Page<RolePermission> findAll(Pageable pageable);

	Optional<RolePermission> findById(String id);

	Optional<RolePermission> findByIdAndCreatedById(String id, String createdById);

	Page<RolePermission> findByCreatedById(Pageable pageable, String createdById);

	Page<RolePermission> findAllByTenantId(Pageable pageable, String tenantId);


	List<RolePermission> findByRoleIdAndCreatedById(String role, String createdById);

	List<RolePermission> findByPermissionIdAndCreatedById(String permission, String createdById);

	List<RolePermission> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	List<RolePermission> findByTenantIdAndCreatedById(String tenant, String createdById);


}
