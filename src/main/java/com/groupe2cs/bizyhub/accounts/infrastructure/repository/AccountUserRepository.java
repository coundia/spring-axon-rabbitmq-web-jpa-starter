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

	@Query("SELECT e FROM AccountUser e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<AccountUser> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM AccountUser e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByIdAndTenantId(String id, String tenantId);

	Page<AccountUser> findByCreatedById(String createdById, Pageable pageable);
	Page<AccountUser> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM AccountUser e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<AccountUser> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.name = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<AccountUser> findByName(String name);

	@Query("SELECT e FROM AccountUser e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE e.account.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<AccountUser> findByAccountIdAndCreatedById(String account, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.account.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<AccountUser> findByAccountId(String account);

	@Query("SELECT e FROM AccountUser e WHERE e.account.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByAccountIdAndTenantName(String account, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.account.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByAccountIdAndTenantId(String account, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE e.user.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<AccountUser> findByUserIdAndCreatedById(String user, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.user.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<AccountUser> findByUserId(String user);

	@Query("SELECT e FROM AccountUser e WHERE e.user.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByUserIdAndTenantName(String user, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.user.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByUserIdAndTenantId(String user, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<AccountUser> findByUsernameAndCreatedById(String username, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.username = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<AccountUser> findByUsername(String username);

	@Query("SELECT e FROM AccountUser e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByUsernameAndTenantId(String username, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE e.details = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<AccountUser> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.details = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<AccountUser> findByDetails(String details);

	@Query("SELECT e FROM AccountUser e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByDetailsAndTenantId(String details, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<AccountUser> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.isActive = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<AccountUser> findByIsActive(Boolean isActive);

	@Query("SELECT e FROM AccountUser e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<AccountUser> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.updatedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<AccountUser> findByUpdatedAt(java.time.Instant updatedAt);

	@Query("SELECT e FROM AccountUser e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<AccountUser> findByReferenceAndCreatedById(String reference, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.reference = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<AccountUser> findByReference(String reference);

	@Query("SELECT e FROM AccountUser e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<AccountUser> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<AccountUser> findByCreatedById(String createdBy);

	@Query("SELECT e FROM AccountUser e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<AccountUser> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<AccountUser> findByTenantId(String tenant);

	@Query("SELECT e FROM AccountUser e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<AccountUser> findByTenantIdAndTenantId(String tenant, String tenantId);



	List<AccountUser> findByUserIdAndAccountId(String userId, String accountId);
}
