package com.groupe2cs.bizyhub.transactions.infrastructure.repository;

	import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
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
public interface TransactionRepository extends JpaRepository<Transaction, String> {

	@Query("SELECT e FROM Transaction e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Transaction> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Transaction e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Transaction> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM Transaction e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Transaction> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Transaction e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Transaction> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByLocalIdAndCreatedById(String localId, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByLocalIdAndTenantName(String localId, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByLocalIdAndTenantId(String localId, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCodeAndCreatedById(String code, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCodeAndTenantName(String code, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByCodeAndTenantId(String code, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByDescriptionAndCreatedById(String description, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByDescriptionAndTenantName(String description, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByDescriptionAndTenantId(String description, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE e.amount = :amount AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByAmountAndCreatedById(Double amount, String createdById);
        @Query("SELECT e FROM Transaction e WHERE e.amount = :amount AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByAmountAndTenantName(Double amount, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE e.amount = :amount AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByAmountAndTenantId(Double amount, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.typeEntry) LIKE LOWER(CONCAT('%', :typeEntry, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByTypeEntryAndCreatedById(String typeEntry, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.typeEntry) LIKE LOWER(CONCAT('%', :typeEntry, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByTypeEntryAndTenantName(String typeEntry, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.typeEntry) LIKE LOWER(CONCAT('%', :typeEntry, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByTypeEntryAndTenantId(String typeEntry, String tenantId);
        @Query("""
        SELECT e FROM Transaction e
        WHERE e.dateTransaction >= :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Transaction> findByDateTransactionAndCreatedById(java.time.Instant dateTransaction, String createdById);

         @Query("""
        SELECT e FROM Transaction e
        WHERE e.dateTransaction >= :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Transaction> findByDateTransactionAndTenantId(java.time.Instant dateTransaction, String tenantId);


        @Query("SELECT e FROM Transaction e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByStatusAndCreatedById(String status, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByStatusAndTenantName(String status, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByStatusAndTenantId(String status, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.entityName) LIKE LOWER(CONCAT('%', :entityName, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByEntityNameAndCreatedById(String entityName, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.entityName) LIKE LOWER(CONCAT('%', :entityName, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByEntityNameAndTenantName(String entityName, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.entityName) LIKE LOWER(CONCAT('%', :entityName, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByEntityNameAndTenantId(String entityName, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.entityId) LIKE LOWER(CONCAT('%', :entityId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByEntityIdAndCreatedById(String entityId, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.entityId) LIKE LOWER(CONCAT('%', :entityId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByEntityIdAndTenantName(String entityId, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.entityId) LIKE LOWER(CONCAT('%', :entityId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByEntityIdAndTenantId(String entityId, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByAccountIdAndCreatedById(String account, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByAccountIdAndTenantName(String account, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByAccountIdAndTenantId(String account, String tenantId);
        @Query("""
        SELECT e FROM Transaction e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Transaction> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
        SELECT e FROM Transaction e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Transaction> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);


        @Query("SELECT e FROM Transaction e WHERE LOWER(e.category.id) LIKE LOWER(CONCAT('%', :category, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCategoryIdAndCreatedById(String category, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.category.id) LIKE LOWER(CONCAT('%', :category, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCategoryIdAndTenantName(String category, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.category.id) LIKE LOWER(CONCAT('%', :category, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByCategoryIdAndTenantId(String category, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.company.id) LIKE LOWER(CONCAT('%', :company, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCompanyIdAndCreatedById(String company, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.company.id) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCompanyIdAndTenantName(String company, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.company.id) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByCompanyIdAndTenantId(String company, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.customer.id) LIKE LOWER(CONCAT('%', :customer, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCustomerIdAndCreatedById(String customer, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.customer.id) LIKE LOWER(CONCAT('%', :customer, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCustomerIdAndTenantName(String customer, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.customer.id) LIKE LOWER(CONCAT('%', :customer, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByCustomerIdAndTenantId(String customer, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.debt.id) LIKE LOWER(CONCAT('%', :debt, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByDebtIdAndCreatedById(String debt, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.debt.id) LIKE LOWER(CONCAT('%', :debt, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByDebtIdAndTenantName(String debt, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.debt.id) LIKE LOWER(CONCAT('%', :debt, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByDebtIdAndTenantId(String debt, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByTenantIdAndTenantId(String tenant, String tenantId);




}
