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

	Page<Role> findAll(Pageable pageable);

	Optional<Role> findById(String id);

	Optional<Role> findByIdAndCreatedById(String id, String createdById);

	Page<Role> findByCreatedById(Pageable pageable, String createdById);

	Page<Role> findAllByTenantId(Pageable pageable, String tenantId);


	Optional<Role> findByNameAndCreatedById(String name, String createdById);

	Optional<Role> findByName(String name);

	List<Role> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	List<Role> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<Role> findByCreatedByIdAndTenantId(
			String createdBy,
			String tenant
	);

}
