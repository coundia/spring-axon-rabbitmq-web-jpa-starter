package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
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
public interface ApiKeyRepository extends JpaRepository<ApiKey, String> {

	@Query("SELECT t FROM ApiKey t ")
	Page<ApiKey> findAll(Pageable pageable);

	@Query("SELECT t FROM ApiKey t WHERE t.id = :id")
	Optional<ApiKey> findById(ApiKey id);
	@Query("SELECT t FROM ApiKey t WHERE t.appKey = :appKey")
	Optional<ApiKey> findByAppKey(String appKey);
	@Query("SELECT t FROM ApiKey t WHERE t.username = :username")
	Optional<ApiKey> findByUsername(String username);
	@Query("SELECT t FROM ApiKey t WHERE t.createdAt = :createdAt")
	List<ApiKey> findByCreatedAt(java.time.Instant createdAt);
	@Query("SELECT t FROM ApiKey t WHERE t.expiration = :expiration")
	List<ApiKey> findByExpiration(java.time.Instant expiration);
	@Query("SELECT t FROM ApiKey t WHERE t.createdBy = :createdBy")
	List<ApiKey> findByCreatedBy(String createdBy);
	@Query("SELECT t FROM ApiKey t WHERE t.tenant = :tenant")
	List<ApiKey> findByTenant(String tenant);

	Optional<ApiKey> findByCreatedByAndTenant(CustomUser createdBy, Tenant tenant);
}
