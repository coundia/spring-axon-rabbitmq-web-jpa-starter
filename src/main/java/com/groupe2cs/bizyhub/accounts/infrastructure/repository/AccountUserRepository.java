package com.groupe2cs.bizyhub.accounts.infrastructure.repository;

import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, String> {

	@Query("SELECT e FROM AccountUser e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<AccountUser> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<AccountUser> findByIdAndTenantId(String id, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<AccountUser> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM AccountUser e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<AccountUser> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByAccountAndCreatedById(String account, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByAccountAndTenantName(String account, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByAccountAndTenantId(String account, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.user) LIKE LOWER(CONCAT('%', :user, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByUserAndCreatedById(String user, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.user) LIKE LOWER(CONCAT('%', :user, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByUserAndTenantName(String user, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.user) LIKE LOWER(CONCAT('%', :user, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByUserAndTenantId(String user, String tenantId);

	@Query("""
			SELECT e FROM AccountUser e
			WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC)
			.toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			  AND (
			         e.createdBy.id = :createdById
			         OR EXISTS (
			              SELECT 1 FROM User u
			              WHERE u.id = :createdById
			                AND (
			                      (e.identity IS NOT NULL AND u.username  = e.identity)
			                   OR (e.email    IS NOT NULL AND u.email     = e.email)
			                   OR (e.phone    IS NOT NULL AND u.telephone = e.phone)
			                )
			         )
			    )
			ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
			""")
	List<AccountUser> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

	@Query("""
			select case when count(e)>0 then true else false end
				from AccountUser e
				where     e.id = :id
					and (
							e.createdBy.id = :userId
							or exists (
							select 1
							from  User u
							where e.account = e.account
					and (
							(e.identity is not null and e.identity = u.username)
							or (e.email is not null and e.email = u.email)
							or (e.phone is not null and e.phone = u.telephone)
						)
					)
			)
			""")
	boolean isOwner(@Param("id") String id, @Param("userId") String userId);

	@Query("""
			SELECT e FROM AccountUser e
			WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			AND e.tenant.id = :tenantId
			ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
			""")
	List<AccountUser> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);


	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByRemoteIdAndCreatedById(String remoteId, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByRemoteIdAndTenantName(String remoteId, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByRemoteIdAndTenantId(String remoteId, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByLocalIdAndCreatedById(String localId, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByLocalIdAndTenantName(String localId, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByLocalIdAndTenantId(String localId, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE e.isActive = :isActive AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE e.isActive = :isActive AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE e.isActive = :isActive AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM AccountUser e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<AccountUser> findByTenantIdAndTenantId(String tenant, String tenantId);


	List<AccountUser> findByStatusAndTenantId(String status, String tenantId);

	List<AccountUser> findByStatusAndCreatedById(String status, String createdById);

	List<AccountUser> findByAcceptedAtAndTenantId(Instant acceptedAt, String tenantId);

	List<AccountUser> findByAcceptedAtAndCreatedById(Instant acceptedAt, String createdById);

	List<AccountUser> findByInvitedByAndTenantId(String invitedBy, String tenantId);

	List<AccountUser> findByInvitedByAndCreatedById(String invitedBy, String createdById);

	List<AccountUser> findByRoleAndTenantId(String role, String tenantId);

	List<AccountUser> findByRoleAndCreatedById(String role, String createdById);

	List<AccountUser> findByRevokedAtAndTenantId(Instant revokedAt, String tenantId);

	List<AccountUser> findByRevokedAtAndCreatedById(Instant revokedAt, String createdById);

	List<AccountUser> findByMessageAndTenantId(String message, String tenantId);

	List<AccountUser> findByMessageAndCreatedById(String message, String createdById);

	List<AccountUser> findByIdentityAndTenantId(String identity, String tenantId);

	List<AccountUser> findByIdentityAndCreatedById(String identity, String createdById);

	List<AccountUser> findByPhoneAndTenantId(String phone, String tenantId);

	List<AccountUser> findByPhoneAndCreatedById(String phone, String createdById);

	List<AccountUser> findByEmailAndTenantId(String email, String tenantId);

	List<AccountUser> findByEmailAndCreatedById(String email, String createdById);
}
