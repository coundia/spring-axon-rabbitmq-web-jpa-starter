package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {

	Page<UserRole> findAll(Pageable pageable);

	Optional<UserRole> findById(String id);

	Optional<UserRole> findByIdAndCreatedById(String id, String createdById);

	Page<UserRole> findByCreatedById(Pageable pageable, String createdById);

	Page<UserRole> findAllByTenantId(Pageable pageable, String tenantId);


	List<UserRole> findByUserIdAndCreatedById(String user, String createdById);

	List<UserRole> findByRoleIdAndCreatedById(String role, String createdById);

	List<UserRole> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	List<UserRole> findByTenantIdAndCreatedById(String tenant, String createdById);


}
