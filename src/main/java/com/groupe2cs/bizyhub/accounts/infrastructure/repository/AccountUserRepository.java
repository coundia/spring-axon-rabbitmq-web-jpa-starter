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

	@Query("SELECT e FROM AccountUser e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<AccountUser> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM AccountUser e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<AccountUser> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM AccountUser e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<AccountUser> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM AccountUser e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<AccountUser> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<AccountUser> findByNameAndCreatedById(String name, String createdById);
        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<AccountUser> findByNameAndTenantName(String name, String tenantName);

        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<AccountUser> findByNameAndTenantId(String name, String tenantId);
        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<AccountUser> findByAccountIdAndCreatedById(String account, String createdById);
        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<AccountUser> findByAccountIdAndTenantName(String account, String tenantName);

        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<AccountUser> findByAccountIdAndTenantId(String account, String tenantId);
        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.user.id) LIKE LOWER(CONCAT('%', :user, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<AccountUser> findByUserIdAndCreatedById(String user, String createdById);
        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.user.id) LIKE LOWER(CONCAT('%', :user, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<AccountUser> findByUserIdAndTenantName(String user, String tenantName);

        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.user.id) LIKE LOWER(CONCAT('%', :user, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<AccountUser> findByUserIdAndTenantId(String user, String tenantId);
        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<AccountUser> findByUsernameAndCreatedById(String username, String createdById);
        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<AccountUser> findByUsernameAndTenantName(String username, String tenantName);

        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<AccountUser> findByUsernameAndTenantId(String username, String tenantId);
        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<AccountUser> findByDetailsAndCreatedById(String details, String createdById);
        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<AccountUser> findByDetailsAndTenantName(String details, String tenantName);

        @Query("SELECT e FROM AccountUser e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<AccountUser> findByDetailsAndTenantId(String details, String tenantId);
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


	List<AccountUser> findBySyncAtAndTenantId(Instant syncAt, String tenantId);

    List<AccountUser> findBySyncAtAndCreatedById(Instant syncAt, String createdById);
}
