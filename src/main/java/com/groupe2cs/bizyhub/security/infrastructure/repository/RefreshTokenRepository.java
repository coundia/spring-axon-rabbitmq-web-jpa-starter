package com.groupe2cs.bizyhub.security.infrastructure.repository;

	import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import java.time.*;
import java.util.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

	@Query("SELECT e FROM RefreshToken e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<RefreshToken> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM RefreshToken e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<RefreshToken> findByIdAndTenantId(String id, String tenantId);

	Page<RefreshToken> findByCreatedById(String createdById, Pageable pageable);
	Page<RefreshToken> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM RefreshToken e WHERE e.token = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<RefreshToken> findByTokenAndCreatedById(String token, String createdById);


	@Query("SELECT e FROM RefreshToken e WHERE e.token = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<RefreshToken> findByToken(String token);

	@Query("SELECT e FROM RefreshToken e WHERE e.token = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<RefreshToken> findByTokenAndTenantName(String token, String tenantName);

	@Query("SELECT e FROM RefreshToken e WHERE e.token = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<RefreshToken> findByTokenAndTenantId(String token, String tenantId);

	@Query("SELECT e FROM RefreshToken e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<RefreshToken> findByUsernameAndCreatedById(String username, String createdById);


	@Query("SELECT e FROM RefreshToken e WHERE e.username = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<RefreshToken> findByUsername(String username);

	@Query("SELECT e FROM RefreshToken e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<RefreshToken> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM RefreshToken e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<RefreshToken> findByUsernameAndTenantId(String username, String tenantId);

	@Query("SELECT e FROM RefreshToken e WHERE e.expiration = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<RefreshToken> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);


	@Query("SELECT e FROM RefreshToken e WHERE e.expiration = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<RefreshToken> findByExpiration(java.time.Instant expiration);

	@Query("SELECT e FROM RefreshToken e WHERE e.expiration = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<RefreshToken> findByExpirationAndTenantName(java.time.Instant expiration, String tenantName);

	@Query("SELECT e FROM RefreshToken e WHERE e.expiration = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<RefreshToken> findByExpirationAndTenantId(java.time.Instant expiration, String tenantId);

	@Query("SELECT e FROM RefreshToken e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<RefreshToken> findByCreatedByIdAndCreatedById(String createdBy, String createdById);


	@Query("SELECT e FROM RefreshToken e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<RefreshToken> findByCreatedById(String createdBy);

	@Query("SELECT e FROM RefreshToken e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<RefreshToken> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM RefreshToken e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<RefreshToken> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM RefreshToken e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<RefreshToken> findByTenantIdAndCreatedById(String tenant, String createdById);


	@Query("SELECT e FROM RefreshToken e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<RefreshToken> findByTenantId(String tenant);

	@Query("SELECT e FROM RefreshToken e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<RefreshToken> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM RefreshToken e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<RefreshToken> findByTenantIdAndTenantId(String tenant, String tenantId);




}
