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

        @Query("""
        SELECT DISTINCT t FROM Transaction t
        LEFT JOIN AccountUser au ON au.account.id = t.account.id
        WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
        """)
        List<Transaction> findByNameAndCreatedById(String valueId, String userId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByNameAndTenantName(String name, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByNameAndTenantId(String name, String tenantId);
        @Query("""
        SELECT DISTINCT t FROM Transaction t
        LEFT JOIN AccountUser au ON au.account.id = t.account.id
        WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
        """)
        List<Transaction> findByAmountAndCreatedById(Double valueId, String userId);
        @Query("SELECT e FROM Transaction e WHERE e.amount = :amount AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByAmountAndTenantName(Double amount, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE e.amount = :amount AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByAmountAndTenantId(Double amount, String tenantId);
        @Query("""
        SELECT DISTINCT t FROM Transaction t
        LEFT JOIN AccountUser au ON au.account.id = t.account.id
        WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
        """)
        List<Transaction> findByDetailsAndCreatedById(String valueId, String userId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByDetailsAndTenantName(String details, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByDetailsAndTenantId(String details, String tenantId);
        @Query("""
        SELECT DISTINCT t FROM Transaction t
        LEFT JOIN AccountUser au ON au.account.id = t.account.id
        WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
        """)
        List<Transaction> findByIsActiveAndCreatedById(Boolean valueId, String userId);
        @Query("SELECT e FROM Transaction e WHERE e.isActive = :isActive AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE e.isActive = :isActive AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByIsActiveAndTenantId(Boolean isActive, String tenantId);
        @Query("""
        SELECT DISTINCT t FROM Transaction t
        LEFT JOIN AccountUser au ON au.account.id = t.account.id
        WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
        """)
        List<Transaction> findByAccountIdAndCreatedById(String valueId, String userId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByAccountIdAndTenantName(String account, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByAccountIdAndTenantId(String account, String tenantId);
        @Query("""
        SELECT DISTINCT t FROM Transaction t
        LEFT JOIN AccountUser au ON au.account.id = t.account.id
        WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
        """)
        List<Transaction> findByCategoryIdAndCreatedById(String valueId, String userId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.category.id) LIKE LOWER(CONCAT('%', :category, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCategoryIdAndTenantName(String category, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.category.id) LIKE LOWER(CONCAT('%', :category, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByCategoryIdAndTenantId(String category, String tenantId);
        @Query("""
        SELECT DISTINCT t FROM Transaction t
        LEFT JOIN AccountUser au ON au.account.id = t.account.id
        WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
        """)
        List<Transaction> findByTypeTransactionRawAndCreatedById(String valueId, String userId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.typeTransactionRaw) LIKE LOWER(CONCAT('%', :typeTransactionRaw, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByTypeTransactionRawAndTenantName(String typeTransactionRaw, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.typeTransactionRaw) LIKE LOWER(CONCAT('%', :typeTransactionRaw, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByTypeTransactionRawAndTenantId(String typeTransactionRaw, String tenantId);
        @Query("""
        SELECT e FROM Transaction e
        WHERE e.dateTransaction >= :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.dateTransaction < :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Transaction> findByDateTransactionAndCreatedById(java.time.Instant dateTransaction, String createdById);

         @Query("""
        SELECT e FROM Transaction e
        WHERE e.dateTransaction >= :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.dateTransaction < :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Transaction> findByDateTransactionAndTenantId(java.time.Instant dateTransaction, String tenantId);


        @Query("""
        SELECT DISTINCT t FROM Transaction t
        LEFT JOIN AccountUser au ON au.account.id = t.account.id
        WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
        """)
        List<Transaction> findByCreatedByIdAndCreatedById(String valueId, String userId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("""
        SELECT DISTINCT t FROM Transaction t
        LEFT JOIN AccountUser au ON au.account.id = t.account.id
        WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
        """)
        List<Transaction> findByTenantIdAndCreatedById(String valueId, String userId);
        @Query("SELECT e FROM Transaction e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Transaction> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM Transaction e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Transaction> findByTenantIdAndTenantId(String tenant, String tenantId);

    @Query("""
    SELECT DISTINCT s FROM Transaction s
    LEFT JOIN TransactionUser su ON su.transaction = s
    WHERE s.tenant.id = :tenantId AND (s.createdBy.id = :userId OR su.user.id = :userId)
    ORDER BY s.updatedAtAudit DESC, s.createdAtAudit  DESC
    """)
	Page<Transaction> findAllOwnedOrShared(@Param("userId") String userId, @Param("tenantId") String tenantId, Pageable pageable);





}
