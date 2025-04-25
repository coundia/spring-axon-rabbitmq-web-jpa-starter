package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordReset, String> {

	@Query("SELECT t FROM PasswordReset t ")
	Page<PasswordReset> findAll(Pageable pageable);

	@Query("SELECT t FROM PasswordReset t WHERE t.id = :id")
	Optional<PasswordReset> findById(PasswordReset id);
	@Query("SELECT t FROM PasswordReset t WHERE t.token = :token")
	Optional<PasswordReset> findByToken(String token);
	@Query("SELECT t FROM PasswordReset t WHERE t.username = :username")
	List<PasswordReset> findByUsername(String username);
	@Query("SELECT t FROM PasswordReset t WHERE t.expiration = :expiration")
	List<PasswordReset> findByExpiration(java.time.Instant expiration);
	@Query("SELECT t FROM PasswordReset t WHERE t.createdBy = :createdBy")
	List<PasswordReset> findByCreatedBy(String createdBy);
	@Query("SELECT t FROM PasswordReset t WHERE t.tenant = :tenant")
	List<PasswordReset> findByTenant(String tenant);

	Optional<PasswordReset> findByCreatedByAndTenant(CustomUser createdBy, Tenant tenant);
}
