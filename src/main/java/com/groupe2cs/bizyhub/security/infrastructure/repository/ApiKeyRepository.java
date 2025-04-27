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

	//Page<ApiKey> findAll(Pageable pageable);

	//Optional<ApiKey> findById(String id);

	Optional<ApiKey> findByIdAndCreatedById(String id, String createdById);

	Page<ApiKey> findByCreatedById(Pageable pageable, String createdById);

	Page<ApiKey> findAllByTenantId(Pageable pageable, String tenantId);


	List<ApiKey> findByAppKeyAndCreatedById(String appKey, String createdById);

	Optional<ApiKey> findByAppKeyAndTenantName(String appKey, String tenantName);

	Optional<ApiKey> findByAppKeyAndTenantId(String appKey, String tenantId);

	List<ApiKey> findByUsernameAndCreatedById(String username, String createdById);

	Optional<ApiKey> findByUsernameAndTenantName(String username, String tenantName);

	Optional<ApiKey> findByUsernameAndTenantId(String username, String tenantId);

	List<ApiKey> findByActiveAndCreatedById(Boolean active, String createdById);

	Optional<ApiKey> findByActiveAndTenantName(Boolean active, String tenantName);

	Optional<ApiKey> findByActiveAndTenantId(Boolean active, String tenantId);

	List<ApiKey> findByCreatedAtAndCreatedById(java.time.Instant createdAt, String createdById);

	Optional<ApiKey> findByCreatedAtAndTenantName(java.time.Instant createdAt, String tenantName);

	Optional<ApiKey> findByCreatedAtAndTenantId(java.time.Instant createdAt, String tenantId);

	List<ApiKey> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);

	Optional<ApiKey> findByExpirationAndTenantName(java.time.Instant expiration, String tenantName);

	Optional<ApiKey> findByExpirationAndTenantId(java.time.Instant expiration, String tenantId);

	List<ApiKey> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	Optional<ApiKey> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	Optional<ApiKey> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	List<ApiKey> findByTenantIdAndCreatedById(String tenant, String createdById);

	Optional<ApiKey> findByTenantIdAndTenantName(String tenant, String tenantName);

	Optional<ApiKey> findByTenantIdAndTenantId(String tenant, String tenantId);


}
