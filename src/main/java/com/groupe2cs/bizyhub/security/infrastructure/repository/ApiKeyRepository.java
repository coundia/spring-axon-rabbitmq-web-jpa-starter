package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApiKeyRepository extends JpaRepository<ApiKey, String> {

	Page<ApiKey> findAll(Pageable pageable);

	Optional<ApiKey> findById(String id);

	Optional<ApiKey> findByIdAndCreatedById(String id, String createdById);

	Page<ApiKey> findByCreatedById(Pageable pageable, String createdById);

	Page<ApiKey> findAllByTenantId(Pageable pageable, String tenantId);


	List<ApiKey> findByAppKeyAndCreatedById(String appKey, String createdById);

	List<ApiKey> findByUsernameAndCreatedById(String username, String createdById);

	List<ApiKey> findByCreatedAtAndCreatedById(java.time.Instant createdAt, String createdById);

	List<ApiKey> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);

	List<ApiKey> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	List<ApiKey> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<ApiKey> findByCreatedByIdAndTenantId(
			String createdBy,
			String tenant
	);

}
