package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordReset, String> {

	@Query("SELECT e FROM PasswordReset e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<PasswordReset> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM PasswordReset e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<PasswordReset> findByIdAndTenantId(String id, String tenantId);

	Page<PasswordReset> findByCreatedById(String createdById, Pageable pageable);

	Page<PasswordReset> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM PasswordReset e WHERE e.token = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<PasswordReset> findByTokenAndCreatedById(String token, String createdById);


	@Query("SELECT e FROM PasswordReset e WHERE e.token = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<PasswordReset> findByToken(String token);

	@Query("SELECT e FROM PasswordReset e WHERE e.token = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<PasswordReset> findByTokenAndTenantName(String token, String tenantName);

	@Query("SELECT e FROM PasswordReset e WHERE e.token = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<PasswordReset> findByTokenAndTenantId(String token, String tenantId);

	@Query("SELECT e FROM PasswordReset e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<PasswordReset> findByUsernameAndCreatedById(String username, String createdById);


	@Query("SELECT e FROM PasswordReset e WHERE e.username = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<PasswordReset> findByUsername(String username);

	@Query("SELECT e FROM PasswordReset e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<PasswordReset> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM PasswordReset e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<PasswordReset> findByUsernameAndTenantId(String username, String tenantId);

	@Query("SELECT e FROM PasswordReset e WHERE e.expiration = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<PasswordReset> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);


	@Query("SELECT e FROM PasswordReset e WHERE e.expiration = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<PasswordReset> findByExpiration(java.time.Instant expiration);

	@Query("SELECT e FROM PasswordReset e WHERE e.expiration = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<PasswordReset> findByExpirationAndTenantName(java.time.Instant expiration, String tenantName);

	@Query("SELECT e FROM PasswordReset e WHERE e.expiration = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<PasswordReset> findByExpirationAndTenantId(java.time.Instant expiration, String tenantId);

	@Query("SELECT e FROM PasswordReset e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<PasswordReset> findByCreatedByIdAndCreatedById(String createdBy, String createdById);


	@Query("SELECT e FROM PasswordReset e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<PasswordReset> findByCreatedById(String createdBy);

	@Query("SELECT e FROM PasswordReset e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<PasswordReset> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM PasswordReset e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<PasswordReset> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM PasswordReset e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<PasswordReset> findByTenantIdAndCreatedById(String tenant, String createdById);


	@Query("SELECT e FROM PasswordReset e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<PasswordReset> findByTenantId(String tenant);

	@Query("SELECT e FROM PasswordReset e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<PasswordReset> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM PasswordReset e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<PasswordReset> findByTenantIdAndTenantId(String tenant, String tenantId);


}
