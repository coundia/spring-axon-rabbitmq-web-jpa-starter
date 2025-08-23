package com.groupe2cs.bizyhub.transactions.infrastructure.repository;

	import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionEntry;
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
public interface TransactionEntryRepository extends JpaRepository<TransactionEntry, String> {

	@Query("SELECT e FROM TransactionEntry e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<TransactionEntry> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM TransactionEntry e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<TransactionEntry> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM TransactionEntry e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<TransactionEntry> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM TransactionEntry e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<TransactionEntry> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByCodeAndCreatedById(String code, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByCodeAndTenantName(String code, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByCodeAndTenantId(String code, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByDescriptionAndCreatedById(String description, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByDescriptionAndTenantName(String description, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByDescriptionAndTenantId(String description, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE e.amount = :amount AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByAmountAndCreatedById(Double amount, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE e.amount = :amount AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByAmountAndTenantName(Double amount, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE e.amount = :amount AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByAmountAndTenantId(Double amount, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.typeEntry) LIKE LOWER(CONCAT('%', :typeEntry, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByTypeEntryAndCreatedById(String typeEntry, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.typeEntry) LIKE LOWER(CONCAT('%', :typeEntry, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByTypeEntryAndTenantName(String typeEntry, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.typeEntry) LIKE LOWER(CONCAT('%', :typeEntry, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByTypeEntryAndTenantId(String typeEntry, String tenantId);
        @Query("""
        SELECT e FROM TransactionEntry e
        WHERE e.dateTransaction >= :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.dateTransaction < :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<TransactionEntry> findByDateTransactionAndCreatedById(java.time.Instant dateTransaction, String createdById);

         @Query("""
        SELECT e FROM TransactionEntry e
        WHERE e.dateTransaction >= :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.dateTransaction < :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<TransactionEntry> findByDateTransactionAndTenantId(java.time.Instant dateTransaction, String tenantId);


        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByStatusAndCreatedById(String status, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByStatusAndTenantName(String status, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByStatusAndTenantId(String status, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.entityName) LIKE LOWER(CONCAT('%', :entityName, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByEntityNameAndCreatedById(String entityName, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.entityName) LIKE LOWER(CONCAT('%', :entityName, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByEntityNameAndTenantName(String entityName, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.entityName) LIKE LOWER(CONCAT('%', :entityName, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByEntityNameAndTenantId(String entityName, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.entityId) LIKE LOWER(CONCAT('%', :entityId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByEntityIdAndCreatedById(String entityId, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.entityId) LIKE LOWER(CONCAT('%', :entityId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByEntityIdAndTenantName(String entityId, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.entityId) LIKE LOWER(CONCAT('%', :entityId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByEntityIdAndTenantId(String entityId, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByAccountIdAndCreatedById(String account, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByAccountIdAndTenantName(String account, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByAccountIdAndTenantId(String account, String tenantId);
        @Query("""
        SELECT e FROM TransactionEntry e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.syncAt < :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<TransactionEntry> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
        SELECT e FROM TransactionEntry e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.syncAt < :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<TransactionEntry> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);


        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.category.id) LIKE LOWER(CONCAT('%', :category, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByCategoryIdAndCreatedById(String category, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.category.id) LIKE LOWER(CONCAT('%', :category, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByCategoryIdAndTenantName(String category, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.category.id) LIKE LOWER(CONCAT('%', :category, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByCategoryIdAndTenantId(String category, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.company.id) LIKE LOWER(CONCAT('%', :company, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByCompanyIdAndCreatedById(String company, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.company.id) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByCompanyIdAndTenantName(String company, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.company.id) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByCompanyIdAndTenantId(String company, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.customer.id) LIKE LOWER(CONCAT('%', :customer, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByCustomerIdAndCreatedById(String customer, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.customer.id) LIKE LOWER(CONCAT('%', :customer, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByCustomerIdAndTenantName(String customer, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.customer.id) LIKE LOWER(CONCAT('%', :customer, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByCustomerIdAndTenantId(String customer, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.debt.id) LIKE LOWER(CONCAT('%', :debt, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByDebtIdAndCreatedById(String debt, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.debt.id) LIKE LOWER(CONCAT('%', :debt, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByDebtIdAndTenantName(String debt, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.debt.id) LIKE LOWER(CONCAT('%', :debt, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByDebtIdAndTenantId(String debt, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionEntry> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM TransactionEntry e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionEntry> findByTenantIdAndTenantId(String tenant, String tenantId);




}
