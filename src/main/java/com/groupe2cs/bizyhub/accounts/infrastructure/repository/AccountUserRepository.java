package com.groupe2cs.bizyhub.accounts.infrastructure.repository;

	import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUser;
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
public interface AccountUserRepository extends JpaRepository<AccountUser, String> {

	@Query("SELECT e FROM AccountUser e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByIdAndCreatedById(String id, String createdById);
	Page<AccountUser> findByCreatedById(String createdById, Pageable pageable);
	Page<AccountUser> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM AccountUser e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<AccountUser> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByNameAndTenantId(String name, String tenantId);
	@Query("SELECT e FROM AccountUser e WHERE e.account.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<AccountUser> findByAccountIdAndCreatedById(String account, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.account.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByAccountIdAndTenantName(String account, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.account.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByAccountIdAndTenantId(String account, String tenantId);
	@Query("SELECT e FROM AccountUser e WHERE e.user.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<AccountUser> findByUserIdAndCreatedById(String user, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.user.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByUserIdAndTenantName(String user, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.user.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByUserIdAndTenantId(String user, String tenantId);
	@Query("SELECT e FROM AccountUser e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<AccountUser> findByUsernameAndCreatedById(String username, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByUsernameAndTenantId(String username, String tenantId);
	@Query("SELECT e FROM AccountUser e WHERE e.details = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<AccountUser> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByDetailsAndTenantId(String details, String tenantId);
	@Query("SELECT e FROM AccountUser e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<AccountUser> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByIsActiveAndTenantId(Boolean isActive, String tenantId);
	@Query("SELECT e FROM AccountUser e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<AccountUser> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);
	@Query("SELECT e FROM AccountUser e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<AccountUser> findByReferenceAndCreatedById(String reference, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByReferenceAndTenantId(String reference, String tenantId);
	@Query("SELECT e FROM AccountUser e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<AccountUser> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
	@Query("SELECT e FROM AccountUser e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<AccountUser> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<AccountUser> findByTenantIdAndTenantId(String tenant, String tenantId);




}
