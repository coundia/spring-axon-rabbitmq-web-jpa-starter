package com.groupe2cs.bizyhub.accounts.infrastructure.repository;

	import com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account;
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
public interface AccountRepository extends JpaRepository<Account, String> {

	@Query("SELECT e FROM Account e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Account> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Account e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Account> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM Account e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Account> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Account e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Account> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM Account e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByCodeAndCreatedById(String code, String createdById);
        @Query("SELECT e FROM Account e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByCodeAndTenantName(String code, String tenantName);

        @Query("SELECT e FROM Account e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByCodeAndTenantId(String code, String tenantId);
        @Query("SELECT e FROM Account e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByNameAndCreatedById(String name, String createdById);
        @Query("SELECT e FROM Account e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByNameAndTenantName(String name, String tenantName);

        @Query("SELECT e FROM Account e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByNameAndTenantId(String name, String tenantId);
        @Query("SELECT e FROM Account e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByStatusAndCreatedById(String status, String createdById);
        @Query("SELECT e FROM Account e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByStatusAndTenantName(String status, String tenantName);

        @Query("SELECT e FROM Account e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByStatusAndTenantId(String status, String tenantId);
        @Query("SELECT e FROM Account e WHERE LOWER(e.currency) LIKE LOWER(CONCAT('%', :currency, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByCurrencyAndCreatedById(String currency, String createdById);
        @Query("SELECT e FROM Account e WHERE LOWER(e.currency) LIKE LOWER(CONCAT('%', :currency, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByCurrencyAndTenantName(String currency, String tenantName);

        @Query("SELECT e FROM Account e WHERE LOWER(e.currency) LIKE LOWER(CONCAT('%', :currency, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByCurrencyAndTenantId(String currency, String tenantId);
        @Query("SELECT e FROM Account e WHERE LOWER(e.typeAccount) LIKE LOWER(CONCAT('%', :typeAccount, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByTypeAccountAndCreatedById(String typeAccount, String createdById);
        @Query("SELECT e FROM Account e WHERE LOWER(e.typeAccount) LIKE LOWER(CONCAT('%', :typeAccount, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByTypeAccountAndTenantName(String typeAccount, String tenantName);

        @Query("SELECT e FROM Account e WHERE LOWER(e.typeAccount) LIKE LOWER(CONCAT('%', :typeAccount, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByTypeAccountAndTenantId(String typeAccount, String tenantId);
        @Query("SELECT e FROM Account e WHERE e.balance = :balance AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalanceAndCreatedById(Double balance, String createdById);
        @Query("SELECT e FROM Account e WHERE e.balance = :balance AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalanceAndTenantName(Double balance, String tenantName);

        @Query("SELECT e FROM Account e WHERE e.balance = :balance AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByBalanceAndTenantId(Double balance, String tenantId);
        @Query("SELECT e FROM Account e WHERE e.balancePrev = :balancePrev AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalancePrevAndCreatedById(Double balancePrev, String createdById);
        @Query("SELECT e FROM Account e WHERE e.balancePrev = :balancePrev AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalancePrevAndTenantName(Double balancePrev, String tenantName);

        @Query("SELECT e FROM Account e WHERE e.balancePrev = :balancePrev AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByBalancePrevAndTenantId(Double balancePrev, String tenantId);
        @Query("SELECT e FROM Account e WHERE e.balanceBlocked = :balanceBlocked AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalanceBlockedAndCreatedById(Double balanceBlocked, String createdById);
        @Query("SELECT e FROM Account e WHERE e.balanceBlocked = :balanceBlocked AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalanceBlockedAndTenantName(Double balanceBlocked, String tenantName);

        @Query("SELECT e FROM Account e WHERE e.balanceBlocked = :balanceBlocked AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByBalanceBlockedAndTenantId(Double balanceBlocked, String tenantId);
        @Query("SELECT e FROM Account e WHERE e.balanceInit = :balanceInit AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalanceInitAndCreatedById(Double balanceInit, String createdById);
        @Query("SELECT e FROM Account e WHERE e.balanceInit = :balanceInit AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalanceInitAndTenantName(Double balanceInit, String tenantName);

        @Query("SELECT e FROM Account e WHERE e.balanceInit = :balanceInit AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByBalanceInitAndTenantId(Double balanceInit, String tenantId);
        @Query("SELECT e FROM Account e WHERE e.balanceGoal = :balanceGoal AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalanceGoalAndCreatedById(Double balanceGoal, String createdById);
        @Query("SELECT e FROM Account e WHERE e.balanceGoal = :balanceGoal AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalanceGoalAndTenantName(Double balanceGoal, String tenantName);

        @Query("SELECT e FROM Account e WHERE e.balanceGoal = :balanceGoal AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByBalanceGoalAndTenantId(Double balanceGoal, String tenantId);
        @Query("SELECT e FROM Account e WHERE e.balanceLimit = :balanceLimit AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalanceLimitAndCreatedById(Double balanceLimit, String createdById);
        @Query("SELECT e FROM Account e WHERE e.balanceLimit = :balanceLimit AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByBalanceLimitAndTenantName(Double balanceLimit, String tenantName);

        @Query("SELECT e FROM Account e WHERE e.balanceLimit = :balanceLimit AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByBalanceLimitAndTenantId(Double balanceLimit, String tenantId);
        @Query("SELECT e FROM Account e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByDescriptionAndCreatedById(String description, String createdById);
        @Query("SELECT e FROM Account e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByDescriptionAndTenantName(String description, String tenantName);

        @Query("SELECT e FROM Account e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByDescriptionAndTenantId(String description, String tenantId);
        @Query("SELECT e FROM Account e WHERE e.isActive = :isActive AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByIsActiveAndCreatedById(Boolean isActive, String createdById);
        @Query("SELECT e FROM Account e WHERE e.isActive = :isActive AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

        @Query("SELECT e FROM Account e WHERE e.isActive = :isActive AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByIsActiveAndTenantId(Boolean isActive, String tenantId);
        @Query("SELECT e FROM Account e WHERE e.isDefault = :isDefault AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByIsDefaultAndCreatedById(Boolean isDefault, String createdById);
        @Query("SELECT e FROM Account e WHERE e.isDefault = :isDefault AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByIsDefaultAndTenantName(Boolean isDefault, String tenantName);

        @Query("SELECT e FROM Account e WHERE e.isDefault = :isDefault AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByIsDefaultAndTenantId(Boolean isDefault, String tenantId);
        @Query("SELECT e FROM Account e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM Account e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM Account e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM Account e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByLocalIdAndCreatedById(String localId, String createdById);
        @Query("SELECT e FROM Account e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByLocalIdAndTenantName(String localId, String tenantName);

        @Query("SELECT e FROM Account e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByLocalIdAndTenantId(String localId, String tenantId);
        @Query("""
        SELECT e FROM Account e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC)
        .toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
         AND (
                 e.createdBy.id = :createdById
                 OR EXISTS (
                      SELECT 1
                      FROM AccountUser au, User u
                      WHERE au.account = e.localId
                        AND (
                              (au.identity IS NOT NULL AND au.identity = u.username)
                           OR (au.email    IS NOT NULL AND au.email    = u.email)
                           OR (au.phone    IS NOT NULL AND au.phone    = u.telephone)
                        )
                 )
            )
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Account> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
        SELECT e FROM Account e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Account> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);

    @Query("""
            select case when count(e)>0 then true else false end
                 from Account  e
                     where e.id=:id
                        and (
                            e.createdBy.id = :userId
                            or exists (
                                select 1
                                    from AccountUser au, User u
                                    where au.account = e.localId
                                    and (
                                    (au.identity is not null and au.identity = u.username)
                                        or (au.email is not null and au.email = u.email)
                                        or (au.phone is not null and au.phone = u.telephone)
                                    )
                        )
            )
            """)
    boolean isOwner( @Param("id") String id,@Param("userId") String userId);


        @Query("SELECT e FROM Account e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM Account e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM Account e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM Account e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM Account e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Account> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM Account e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Account> findByTenantIdAndTenantId(String tenant, String tenantId);




}
