package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

	//Page<Permission> findAll(Pageable pageable);

	//Optional<Permission> findById(String id);

	Optional<Permission> findByIdAndCreatedById(String id, String createdById);

	Page<Permission> findByCreatedById(Pageable pageable, String createdById);

	Page<Permission> findAllByTenantId(Pageable pageable, String tenantId);


	List<Permission> findByNameAndCreatedById(String name, String createdById);

	Optional<Permission> findByNameAndTenantName(String name, String tenantName);

	Optional<Permission> findByNameAndTenantId(String name, String tenantId);

	List<Permission> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	Optional<Permission> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	Optional<Permission> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	List<Permission> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<Permission> findByTenantIdAndTenantName(String tenant, String tenantName);

	Optional<Permission> findByTenantIdAndTenantId(String tenant, String tenantId);


}
