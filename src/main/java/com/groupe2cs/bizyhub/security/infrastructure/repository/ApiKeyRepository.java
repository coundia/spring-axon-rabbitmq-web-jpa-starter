package com.groupe2cs.bizyhub.security.infrastructure.repository;

	import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.*;
import java.util.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApiKeyRepository extends JpaRepository<ApiKey, String> {

	@Query("SELECT e FROM ApiKey e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByIdAndCreatedById(String id, String createdById);
	Page<ApiKey> findByCreatedById(String createdById, Pageable pageable);
	Page<ApiKey> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM ApiKey e WHERE e.appKey = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<ApiKey> findByAppKeyAndCreatedById(String appKey, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE e.appKey = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByAppKeyAndTenantName(String appKey, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE e.appKey = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByAppKeyAndTenantId(String appKey, String tenantId);
	@Query("SELECT e FROM ApiKey e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<ApiKey> findByUsernameAndCreatedById(String username, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByUsernameAndTenantId(String username, String tenantId);
	@Query("SELECT e FROM ApiKey e WHERE e.active = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<ApiKey> findByActiveAndCreatedById(Boolean active, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE e.active = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByActiveAndTenantName(Boolean active, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE e.active = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByActiveAndTenantId(Boolean active, String tenantId);
	@Query("SELECT e FROM ApiKey e WHERE e.createdAt = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<ApiKey> findByCreatedAtAndCreatedById(java.time.Instant createdAt, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE e.createdAt = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByCreatedAtAndTenantName(java.time.Instant createdAt, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE e.createdAt = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByCreatedAtAndTenantId(java.time.Instant createdAt, String tenantId);
	@Query("SELECT e FROM ApiKey e WHERE e.expiration = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<ApiKey> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE e.expiration = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByExpirationAndTenantName(java.time.Instant expiration, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE e.expiration = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByExpirationAndTenantId(java.time.Instant expiration, String tenantId);
	@Query("SELECT e FROM ApiKey e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<ApiKey> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
	@Query("SELECT e FROM ApiKey e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<ApiKey> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<ApiKey> findByTenantIdAndTenantId(String tenant, String tenantId);


}
