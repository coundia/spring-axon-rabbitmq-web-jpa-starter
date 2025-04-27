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

	Page<PasswordReset> findAll(Pageable pageable);

	Optional<PasswordReset> findById(String id);

	Optional<PasswordReset> findByIdAndCreatedById(String id, String createdById);

	Page<PasswordReset> findByCreatedById(Pageable pageable, String createdById);

	Page<PasswordReset> findAllByTenantId(Pageable pageable, String tenantId);


	List<PasswordReset> findByTokenAndCreatedById(String token, String createdById);

	List<PasswordReset> findByUsernameAndCreatedById(String username, String createdById);

	List<PasswordReset> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);

	List<PasswordReset> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	List<PasswordReset> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<PasswordReset> findByCreatedByIdAndTenantId(
			String createdBy,
			String tenant
	);

}
