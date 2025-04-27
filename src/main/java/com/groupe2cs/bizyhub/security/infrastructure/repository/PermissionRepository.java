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

	Page<Permission> findAll(Pageable pageable);

	Optional<Permission> findById(String id);

	Optional<Permission> findByIdAndCreatedById(String id, String createdById);

	Page<Permission> findByCreatedById(Pageable pageable, String createdById);

	Page<Permission> findAllByTenantId(Pageable pageable, String tenantId);


	Optional<Permission> findByNameAndCreatedById(String name, String createdById);

	Optional<Permission> findByName(String name);

	List<Permission> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	List<Permission> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<Permission> findByCreatedByIdAndTenantId(
			String createdBy,
			String tenant
	);

}
