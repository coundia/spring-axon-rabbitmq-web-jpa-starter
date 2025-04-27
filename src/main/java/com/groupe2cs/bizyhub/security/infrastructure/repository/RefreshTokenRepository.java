package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

	//Page<RefreshToken> findAll(Pageable pageable);

	//Optional<RefreshToken> findById(String id);

	Optional<RefreshToken> findByIdAndCreatedById(String id, String createdById);

	Page<RefreshToken> findByCreatedById(Pageable pageable, String createdById);

	Page<RefreshToken> findAllByTenantId(Pageable pageable, String tenantId);


	List<RefreshToken> findByTokenAndCreatedById(String token, String createdById);

	Optional<RefreshToken> findByTokenAndTenantName(String token, String tenantName);

	Optional<RefreshToken> findByTokenAndTenantId(String token, String tenantId);

	List<RefreshToken> findByUsernameAndCreatedById(String username, String createdById);

	Optional<RefreshToken> findByUsernameAndTenantName(String username, String tenantName);

	Optional<RefreshToken> findByUsernameAndTenantId(String username, String tenantId);

	List<RefreshToken> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);

	Optional<RefreshToken> findByExpirationAndTenantName(java.time.Instant expiration, String tenantName);

	Optional<RefreshToken> findByExpirationAndTenantId(java.time.Instant expiration, String tenantId);

	List<RefreshToken> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	Optional<RefreshToken> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	Optional<RefreshToken> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	List<RefreshToken> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<RefreshToken> findByTenantIdAndTenantName(String tenant, String tenantName);

	Optional<RefreshToken> findByTenantIdAndTenantId(String tenant, String tenantId);


}
