package com.groupe2cs.bizyhub.debts.infrastructure.repository;

	import com.groupe2cs.bizyhub.debts.infrastructure.entity.Debt;
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
public interface DebtRepository extends JpaRepository<Debt, String> {

	@Query("SELECT e FROM Debt e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Debt> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Debt e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Debt> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM Debt e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Debt> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Debt e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Debt> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM Debt e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM Debt e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM Debt e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Debt> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM Debt e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByCodeAndCreatedById(String code, String createdById);
        @Query("SELECT e FROM Debt e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByCodeAndTenantName(String code, String tenantName);

        @Query("SELECT e FROM Debt e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Debt> findByCodeAndTenantId(String code, String tenantId);
        @Query("SELECT e FROM Debt e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByNotesAndCreatedById(String notes, String createdById);
        @Query("SELECT e FROM Debt e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByNotesAndTenantName(String notes, String tenantName);

        @Query("SELECT e FROM Debt e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Debt> findByNotesAndTenantId(String notes, String tenantId);
        @Query("SELECT e FROM Debt e WHERE e.balance = :balance AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByBalanceAndCreatedById(Double balance, String createdById);
        @Query("SELECT e FROM Debt e WHERE e.balance = :balance AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByBalanceAndTenantName(Double balance, String tenantName);

        @Query("SELECT e FROM Debt e WHERE e.balance = :balance AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Debt> findByBalanceAndTenantId(Double balance, String tenantId);
        @Query("SELECT e FROM Debt e WHERE e.balanceDebt = :balanceDebt AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByBalanceDebtAndCreatedById(Double balanceDebt, String createdById);
        @Query("SELECT e FROM Debt e WHERE e.balanceDebt = :balanceDebt AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByBalanceDebtAndTenantName(Double balanceDebt, String tenantName);

        @Query("SELECT e FROM Debt e WHERE e.balanceDebt = :balanceDebt AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Debt> findByBalanceDebtAndTenantId(Double balanceDebt, String tenantId);
        @Query("""
        SELECT e FROM Debt e
        WHERE e.dueDate >= :#{#dueDate.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.dueDate < :#{#dueDate.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Debt> findByDueDateAndCreatedById(java.time.Instant dueDate, String createdById);

         @Query("""
        SELECT e FROM Debt e
        WHERE e.dueDate >= :#{#dueDate.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.dueDate < :#{#dueDate.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Debt> findByDueDateAndTenantId(java.time.Instant dueDate, String tenantId);


        @Query("SELECT e FROM Debt e WHERE LOWER(e.statuses) LIKE LOWER(CONCAT('%', :statuses, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByStatusesAndCreatedById(String statuses, String createdById);
        @Query("SELECT e FROM Debt e WHERE LOWER(e.statuses) LIKE LOWER(CONCAT('%', :statuses, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByStatusesAndTenantName(String statuses, String tenantName);

        @Query("SELECT e FROM Debt e WHERE LOWER(e.statuses) LIKE LOWER(CONCAT('%', :statuses, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Debt> findByStatusesAndTenantId(String statuses, String tenantId);
        @Query("""
        SELECT e FROM Debt e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.syncAt < :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Debt> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
        SELECT e FROM Debt e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.syncAt < :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Debt> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);


        @Query("SELECT e FROM Debt e WHERE LOWER(e.customer.id) LIKE LOWER(CONCAT('%', :customer, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByCustomerIdAndCreatedById(String customer, String createdById);
        @Query("SELECT e FROM Debt e WHERE LOWER(e.customer.id) LIKE LOWER(CONCAT('%', :customer, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByCustomerIdAndTenantName(String customer, String tenantName);

        @Query("SELECT e FROM Debt e WHERE LOWER(e.customer.id) LIKE LOWER(CONCAT('%', :customer, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Debt> findByCustomerIdAndTenantId(String customer, String tenantId);
        @Query("SELECT e FROM Debt e WHERE e.isActive = :isActive AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByIsActiveAndCreatedById(Boolean isActive, String createdById);
        @Query("SELECT e FROM Debt e WHERE e.isActive = :isActive AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

        @Query("SELECT e FROM Debt e WHERE e.isActive = :isActive AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Debt> findByIsActiveAndTenantId(Boolean isActive, String tenantId);
        @Query("SELECT e FROM Debt e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM Debt e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM Debt e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Debt> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM Debt e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM Debt e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Debt> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM Debt e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Debt> findByTenantIdAndTenantId(String tenant, String tenantId);




}
