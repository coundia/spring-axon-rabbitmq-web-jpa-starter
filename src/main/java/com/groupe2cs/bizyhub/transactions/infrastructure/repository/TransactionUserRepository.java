package com.groupe2cs.bizyhub.transactions.infrastructure.repository;

import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionUserRepository extends JpaRepository<TransactionUser, String> {

	@Query("SELECT e FROM TransactionUser e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<TransactionUser> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM TransactionUser e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByIdAndTenantId(String id, String tenantId);

	Page<TransactionUser> findByCreatedById(String createdById, Pageable pageable);

	Page<TransactionUser> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM TransactionUser e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<TransactionUser> findByNameAndCreatedById(String name, String createdById);


	@Query("SELECT e FROM TransactionUser e WHERE e.name = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<TransactionUser> findByName(String name);

	@Query("SELECT e FROM TransactionUser e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE e.transaction.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<TransactionUser> findByTransactionIdAndCreatedById(String transaction, String createdById);


	@Query("SELECT e FROM TransactionUser e WHERE e.transaction.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<TransactionUser> findByTransactionId(String transaction);

	@Query("SELECT e FROM TransactionUser e WHERE e.transaction.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByTransactionIdAndTenantName(String transaction, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE e.transaction.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByTransactionIdAndTenantId(String transaction, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE e.user.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<TransactionUser> findByUserIdAndCreatedById(String user, String createdById);


	@Query("SELECT e FROM TransactionUser e WHERE e.user.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<TransactionUser> findByUserId(String user);

	@Query("SELECT e FROM TransactionUser e WHERE e.user.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByUserIdAndTenantName(String user, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE e.user.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByUserIdAndTenantId(String user, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<TransactionUser> findByUsernameAndCreatedById(String username, String createdById);


	@Query("SELECT e FROM TransactionUser e WHERE e.username = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<TransactionUser> findByUsername(String username);

	@Query("SELECT e FROM TransactionUser e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByUsernameAndTenantId(String username, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE e.details = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<TransactionUser> findByDetailsAndCreatedById(String details, String createdById);


	@Query("SELECT e FROM TransactionUser e WHERE e.details = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<TransactionUser> findByDetails(String details);

	@Query("SELECT e FROM TransactionUser e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByDetailsAndTenantId(String details, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<TransactionUser> findByIsActiveAndCreatedById(Boolean isActive, String createdById);


	@Query("SELECT e FROM TransactionUser e WHERE e.isActive = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<TransactionUser> findByIsActive(Boolean isActive);

	@Query("SELECT e FROM TransactionUser e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<TransactionUser> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);


	@Query("SELECT e FROM TransactionUser e WHERE e.updatedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<TransactionUser> findByUpdatedAt(java.time.Instant updatedAt);

	@Query("SELECT e FROM TransactionUser e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<TransactionUser> findByReferenceAndCreatedById(String reference, String createdById);


	@Query("SELECT e FROM TransactionUser e WHERE e.reference = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<TransactionUser> findByReference(String reference);

	@Query("SELECT e FROM TransactionUser e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<TransactionUser> findByCreatedByIdAndCreatedById(String createdBy, String createdById);


	@Query("SELECT e FROM TransactionUser e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<TransactionUser> findByCreatedById(String createdBy);

	@Query("SELECT e FROM TransactionUser e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<TransactionUser> findByTenantIdAndCreatedById(String tenant, String createdById);


	@Query("SELECT e FROM TransactionUser e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<TransactionUser> findByTenantId(String tenant);

	@Query("SELECT e FROM TransactionUser e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<TransactionUser> findByTenantIdAndTenantId(String tenant, String tenantId);


}
