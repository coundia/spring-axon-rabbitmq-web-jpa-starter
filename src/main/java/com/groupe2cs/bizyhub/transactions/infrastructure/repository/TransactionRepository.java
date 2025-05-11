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

	@Query("SELECT e FROM Transaction e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByIdAndCreatedById(String id, String createdById);
	Page<Transaction> findByCreatedById(String createdById, Pageable pageable);
	Page<Transaction> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Transaction e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByNameAndTenantId(String name, String tenantId);
	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByAmountAndCreatedById(Double amount, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByAmountAndTenantName(Double amount, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByAmountAndTenantId(Double amount, String tenantId);
	@Query("SELECT e FROM Transaction e WHERE e.details = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByDetailsAndTenantId(String details, String tenantId);
	@Query("SELECT e FROM Transaction e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByIsActiveAndTenantId(Boolean isActive, String tenantId);
	@Query("SELECT e FROM Transaction e WHERE e.account.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByAccountIdAndCreatedById(String account, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.account.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByAccountIdAndTenantName(String account, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.account.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByAccountIdAndTenantId(String account, String tenantId);
	@Query("SELECT e FROM Transaction e WHERE e.category.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByCategoryIdAndCreatedById(String category, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.category.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByCategoryIdAndTenantName(String category, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.category.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByCategoryIdAndTenantId(String category, String tenantId);
	@Query("SELECT e FROM Transaction e WHERE e.typeTransactionRaw = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByTypeTransactionRawAndCreatedById(String typeTransactionRaw, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.typeTransactionRaw = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByTypeTransactionRawAndTenantName(String typeTransactionRaw, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.typeTransactionRaw = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByTypeTransactionRawAndTenantId(String typeTransactionRaw, String tenantId);
	@Query("SELECT e FROM Transaction e WHERE e.dateTransaction = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByDateTransactionAndCreatedById(java.time.Instant dateTransaction, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.dateTransaction = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByDateTransactionAndTenantName(java.time.Instant dateTransaction, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.dateTransaction = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByDateTransactionAndTenantId(java.time.Instant dateTransaction, String tenantId);
	@Query("SELECT e FROM Transaction e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);
	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByReferenceAndCreatedById(String reference, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByReferenceAndTenantId(String reference, String tenantId);
	@Query("SELECT e FROM Transaction e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
	@Query("SELECT e FROM Transaction e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByTenantIdAndTenantId(String tenant, String tenantId);

    @Query("""
    SELECT DISTINCT s FROM Transaction s
    LEFT JOIN TransactionUser su ON su.transaction = s
    WHERE s.tenant.id = :tenantId AND (s.createdBy.id = :userId OR su.user.id = :userId)
    """)
	Page<Transaction> findAllOwnedOrShared(@Param("userId") String userId, @Param("tenantId") String tenantId, Pageable pageable);



}
