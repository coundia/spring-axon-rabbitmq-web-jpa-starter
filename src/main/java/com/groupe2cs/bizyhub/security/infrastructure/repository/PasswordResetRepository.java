package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordReset, String> {

	//Page<PasswordReset> findAll(Pageable pageable);

	//Optional<PasswordReset> findById(String id);

	Optional<PasswordReset> findByIdAndCreatedById(String id, String createdById);

	Page<PasswordReset> findByCreatedById(Pageable pageable, String createdById);

	Page<PasswordReset> findAllByTenantId(Pageable pageable, String tenantId);


	List<PasswordReset> findByTokenAndCreatedById(String token, String createdById);

	Optional<PasswordReset> findByTokenAndTenantName(String token, String tenantName);

	Optional<PasswordReset> findByTokenAndTenantId(String token, String tenantId);

	List<PasswordReset> findByUsernameAndCreatedById(String username, String createdById);

	Optional<PasswordReset> findByUsernameAndTenantName(String username, String tenantName);

	Optional<PasswordReset> findByUsernameAndTenantId(String username, String tenantId);

	List<PasswordReset> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);

	Optional<PasswordReset> findByExpirationAndTenantName(java.time.Instant expiration, String tenantName);

	Optional<PasswordReset> findByExpirationAndTenantId(java.time.Instant expiration, String tenantId);

	List<PasswordReset> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	Optional<PasswordReset> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	Optional<PasswordReset> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	List<PasswordReset> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<PasswordReset> findByTenantIdAndTenantName(String tenant, String tenantName);

	Optional<PasswordReset> findByTenantIdAndTenantId(String tenant, String tenantId);


}
