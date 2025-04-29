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

	@Query("SELECT e FROM Transaction e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Transaction> findByIdAndCreatedById(String id, String createdById);

	Page<Transaction> findByCreatedById(String createdById, Pageable pageable);

	Page<Transaction> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1  ORDER BY e.createdAtAudit DESC")
	Optional<Transaction> findByReference(String reference);

	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Transaction> findByReferenceAndCreatedById(String reference, String createdById);


	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Transaction> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Transaction> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByAmountAndCreatedById(Double amount, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Transaction> findByAmountAndTenantName(Double amount, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Transaction> findByAmountAndTenantId(Double amount, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Transaction> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Transaction> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Transaction e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Transaction> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Transaction> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC")
	Optional<Transaction> findByTenantIdAndTenantId(String tenant, String tenantId);


}
