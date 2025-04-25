package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

	@Query("SELECT t FROM RefreshToken t ")
	Page<RefreshToken> findAll(Pageable pageable);

	@Query("SELECT t FROM RefreshToken t WHERE t.id = :id")
	Optional<RefreshToken> findById(RefreshToken id);

	@Query("SELECT t FROM RefreshToken t WHERE t.token = :token")
	Optional<RefreshToken> findByToken(String token);

	@Query("SELECT t FROM RefreshToken t WHERE t.username = :username")
	Optional<RefreshToken> findByUsername(String username);

	@Query("SELECT t FROM RefreshToken t WHERE t.expiration = :expiration")
	List<RefreshToken> findByExpiration(java.time.Instant expiration);

	@Query("SELECT t FROM RefreshToken t WHERE t.createdBy = :createdBy")
	List<RefreshToken> findByCreatedBy(String createdBy);

	@Query("SELECT t FROM RefreshToken t WHERE t.tenant = :tenant")
	List<RefreshToken> findByTenant(String tenant);

	Optional<RefreshToken> findByCreatedByAndTenant(User createdBy, Tenant tenant);
}
