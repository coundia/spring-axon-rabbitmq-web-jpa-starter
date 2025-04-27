package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

	//Page<Role> findAll(Pageable pageable);

	//Optional<Role> findById(String id);

	Optional<Role> findByIdAndCreatedById(String id, String createdById);

	Page<Role> findByCreatedById(Pageable pageable, String createdById);

	Page<Role> findAllByTenantId(Pageable pageable, String tenantId);


	List<Role> findByNameAndCreatedById(String name, String createdById);

	Optional<Role> findByNameAndTenantName(String name, String tenantName);

	Optional<Role> findByNameAndTenantId(String name, String tenantId);

	List<Role> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	Optional<Role> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	Optional<Role> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	List<Role> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<Role> findByTenantIdAndTenantName(String tenant, String tenantName);

	Optional<Role> findByTenantIdAndTenantId(String tenant, String tenantId);


}
