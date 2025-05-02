package com.groupe2cs.bizyhub.security.infrastructure.repository;

	import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
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
public interface PasswordResetRepository extends JpaRepository<PasswordReset, String> {

	@Query("SELECT e FROM PasswordReset e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByIdAndCreatedById(String id, String createdById);
	Page<PasswordReset> findByCreatedById(String createdById, Pageable pageable);
	Page<PasswordReset> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM PasswordReset e WHERE e.token = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<PasswordReset> findByTokenAndCreatedById(String token, String createdById);

	@Query("SELECT e FROM PasswordReset e WHERE e.token = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByTokenAndTenantName(String token, String tenantName);

	@Query("SELECT e FROM PasswordReset e WHERE e.token = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByTokenAndTenantId(String token, String tenantId);
	@Query("SELECT e FROM PasswordReset e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<PasswordReset> findByUsernameAndCreatedById(String username, String createdById);

	@Query("SELECT e FROM PasswordReset e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM PasswordReset e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByUsernameAndTenantId(String username, String tenantId);
	@Query("SELECT e FROM PasswordReset e WHERE e.expiration = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<PasswordReset> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);

	@Query("SELECT e FROM PasswordReset e WHERE e.expiration = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByExpirationAndTenantName(java.time.Instant expiration, String tenantName);

	@Query("SELECT e FROM PasswordReset e WHERE e.expiration = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByExpirationAndTenantId(java.time.Instant expiration, String tenantId);
	@Query("SELECT e FROM PasswordReset e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<PasswordReset> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM PasswordReset e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM PasswordReset e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
	@Query("SELECT e FROM PasswordReset e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<PasswordReset> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM PasswordReset e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM PasswordReset e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByTenantIdAndTenantId(String tenant, String tenantId);


}
