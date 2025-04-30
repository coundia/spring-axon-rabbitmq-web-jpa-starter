package com.groupe2cs.bizyhub.transactions.infrastructure.repository;

import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

	@Query("SELECT e FROM Transaction e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByIdAndCreatedById(String id, String createdById);

	Page<Transaction> findByCreatedById(String createdById, Pageable pageable);

	Page<Transaction> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByAmountAndCreatedById(Double amount, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByAmountAndTenantName(Double amount, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByAmountAndTenantId(Double amount, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.dateOperation = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByDateOperationAndCreatedById(java.time.Instant dateOperation, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.dateOperation = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByDateOperationAndTenantName(java.time.Instant dateOperation, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.dateOperation = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByDateOperationAndTenantId(java.time.Instant dateOperation, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.description = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByDescriptionAndCreatedById(String description, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.description = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByDescriptionAndTenantName(String description, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.description = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByDescriptionAndTenantId(String description, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByReferenceAndCreatedById(String reference, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.isRecurring = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByIsRecurringAndCreatedById(Boolean isRecurring, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.isRecurring = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByIsRecurringAndTenantName(Boolean isRecurring, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.isRecurring = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByIsRecurringAndTenantId(Boolean isRecurring, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.isExcluToRapport = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByIsExcluToRapportAndCreatedById(Boolean isExcluToRapport, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.isExcluToRapport = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByIsExcluToRapportAndTenantName(Boolean isExcluToRapport, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.isExcluToRapport = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByIsExcluToRapportAndTenantId(Boolean isExcluToRapport, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.status = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByStatusAndCreatedById(String status, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.status = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByStatusAndTenantName(String status, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.status = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByStatusAndTenantId(String status, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.balance.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByBalanceIdAndCreatedById(String balance, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.balance.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByBalanceIdAndTenantName(String balance, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.balance.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByBalanceIdAndTenantId(String balance, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.category.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByCategoryIdAndCreatedById(String category, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.category.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByCategoryIdAndTenantName(String category, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.category.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByCategoryIdAndTenantId(String category, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.createdAt = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByCreatedAtAndCreatedById(java.time.Instant createdAt, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.createdAt = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByCreatedAtAndTenantName(java.time.Instant createdAt, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.createdAt = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Transaction> findByCreatedAtAndTenantId(java.time.Instant createdAt, String tenantId);

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


}
