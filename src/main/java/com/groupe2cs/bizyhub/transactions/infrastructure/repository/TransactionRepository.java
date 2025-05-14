package com.groupe2cs.bizyhub.transactions.infrastructure.repository;

import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

	@Query("SELECT e FROM Transaction e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<Transaction> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM Transaction e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByIdAndTenantId(String id, String tenantId);

	Page<Transaction> findByCreatedById(String createdById, Pageable pageable);

	Page<Transaction> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByNameAndCreatedById(String valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.name = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByName(String name);

	@Query("SELECT e FROM Transaction e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByNameAndTenantId(String name, String tenantId);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByAmountAndCreatedById(Double valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByAmount(Double amount);

	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByAmountAndTenantName(Double amount, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.amount = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByAmountAndTenantId(Double amount, String tenantId);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByDetailsAndCreatedById(String valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.details = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByDetails(String details);

	@Query("SELECT e FROM Transaction e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByDetailsAndTenantId(String details, String tenantId);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByIsActiveAndCreatedById(Boolean valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.isActive = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByIsActive(Boolean isActive);

	@Query("SELECT e FROM Transaction e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByIsActiveAndTenantId(Boolean isActive, String tenantId);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByAccountIdAndCreatedById(String valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.account.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByAccountId(String account);

	@Query("SELECT e FROM Transaction e WHERE e.account.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByAccountIdAndTenantName(String account, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.account.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByAccountIdAndTenantId(String account, String tenantId);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByCategoryIdAndCreatedById(String valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.category.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByCategoryId(String category);

	@Query("SELECT e FROM Transaction e WHERE e.category.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByCategoryIdAndTenantName(String category, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.category.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByCategoryIdAndTenantId(String category, String tenantId);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByTypeTransactionRawAndCreatedById(String valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.typeTransactionRaw = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByTypeTransactionRaw(String typeTransactionRaw);

	@Query("SELECT e FROM Transaction e WHERE e.typeTransactionRaw = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByTypeTransactionRawAndTenantName(String typeTransactionRaw, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.typeTransactionRaw = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByTypeTransactionRawAndTenantId(String typeTransactionRaw, String tenantId);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByDateTransactionAndCreatedById(java.time.Instant valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.dateTransaction = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByDateTransaction(java.time.Instant dateTransaction);

	@Query("SELECT e FROM Transaction e WHERE e.dateTransaction = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByDateTransactionAndTenantName(java.time.Instant dateTransaction, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.dateTransaction = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByDateTransactionAndTenantId(java.time.Instant dateTransaction, String tenantId);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByUpdatedAtAndCreatedById(java.time.Instant valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.updatedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByUpdatedAt(java.time.Instant updatedAt);

	@Query("SELECT e FROM Transaction e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByReferenceAndCreatedById(String valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByReference(String reference);

	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByReferenceAndTenantId(String reference, String tenantId);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByCreatedByIdAndCreatedById(String valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByCreatedById(String createdBy);

	@Query("SELECT e FROM Transaction e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByCreatedByIdAndTenantId(String createdBy, String tenantId);


	@Query("""
			SELECT DISTINCT t FROM Transaction t
			LEFT JOIN AccountUser au ON au.account.id = t.account.id
			WHERE t.account.id = :valueId AND (t.createdBy.id = :userId OR au.user.id = :userId OR au.account.createdBy.id = :userId)
			""")
	List<Transaction> findByTenantIdAndCreatedById(String valueId, String userId);

	@Query("SELECT e FROM Transaction e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Transaction> findByTenantId(String tenant);

	@Query("SELECT e FROM Transaction e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Transaction e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Transaction> findByTenantIdAndTenantId(String tenant, String tenantId);

	@Query("""
			SELECT DISTINCT s FROM Transaction s
			LEFT JOIN TransactionUser su ON su.transaction = s
			WHERE s.tenant.id = :tenantId AND (s.createdBy.id = :userId OR su.user.id = :userId)
			""")
	Page<Transaction> findAllOwnedOrShared(@Param("userId") String userId, @Param("tenantId") String tenantId, Pageable pageable);


}
