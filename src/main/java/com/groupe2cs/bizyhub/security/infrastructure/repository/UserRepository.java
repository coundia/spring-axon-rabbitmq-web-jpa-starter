package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, String> {

	//Page<CustomUser> findAll(Pageable pageable);

	//Optional<CustomUser> findById(String id);

	Optional<CustomUser> findByIdAndCreatedById(String id, String createdById);

	Page<CustomUser> findByCreatedById(Pageable pageable, String createdById);

	Page<CustomUser> findAllByTenantId(Pageable pageable, String tenantId);


	List<CustomUser> findByUsernameAndCreatedById(String username, String createdById);

	Optional<CustomUser> findByUsernameAndTenantName(String username, String tenantName);

	Optional<CustomUser> findByUsernameAndTenantId(String username, String tenantId);

	List<CustomUser> findByPasswordAndCreatedById(String password, String createdById);

	Optional<CustomUser> findByPasswordAndTenantName(String password, String tenantName);

	Optional<CustomUser> findByPasswordAndTenantId(String password, String tenantId);

	List<CustomUser> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	Optional<CustomUser> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	Optional<CustomUser> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	List<CustomUser> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<CustomUser> findByTenantIdAndTenantName(String tenant, String tenantName);

	Optional<CustomUser> findByTenantIdAndTenantId(String tenant, String tenantId);


}
