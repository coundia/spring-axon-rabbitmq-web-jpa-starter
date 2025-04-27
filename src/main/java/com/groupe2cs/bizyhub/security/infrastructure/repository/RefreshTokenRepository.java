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

	Page<RefreshToken> findAll(Pageable pageable);

	Optional<RefreshToken> findById(String id);

	Optional<RefreshToken> findByIdAndCreatedById(String id, String createdById);

	Page<RefreshToken> findByCreatedById(Pageable pageable, String createdById);

	Page<RefreshToken> findAllByTenantId(Pageable pageable, String tenantId);


	List<RefreshToken> findByTokenAndCreatedById(String token, String createdById);

	List<RefreshToken> findByUsernameAndCreatedById(String username, String createdById);

	List<RefreshToken> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);

	List<RefreshToken> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	List<RefreshToken> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<RefreshToken> findByCreatedByIdAndTenantId(
			String createdBy,
			String tenant
	);

}
