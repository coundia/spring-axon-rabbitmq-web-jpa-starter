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

	@Query("SELECT e FROM TransactionUser e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<TransactionUser> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM TransactionUser e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<TransactionUser> findByIdAndTenantId(String id, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<TransactionUser> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM TransactionUser e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<TransactionUser> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.transaction.id) LIKE LOWER(CONCAT('%', :transaction, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByTransactionIdAndCreatedById(String transaction, String createdById);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.transaction.id) LIKE LOWER(CONCAT('%', :transaction, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByTransactionIdAndTenantName(String transaction, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.transaction.id) LIKE LOWER(CONCAT('%', :transaction, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByTransactionIdAndTenantId(String transaction, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.user.id) LIKE LOWER(CONCAT('%', :user, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByUserIdAndCreatedById(String user, String createdById);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.user.id) LIKE LOWER(CONCAT('%', :user, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByUserIdAndTenantName(String user, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.user.id) LIKE LOWER(CONCAT('%', :user, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByUserIdAndTenantId(String user, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByUsernameAndCreatedById(String username, String createdById);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByUsernameAndTenantId(String username, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByDetailsAndTenantId(String details, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE e.isActive = :isActive AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM TransactionUser e WHERE e.isActive = :isActive AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE e.isActive = :isActive AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM TransactionUser e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<TransactionUser> findByTenantIdAndTenantId(String tenant, String tenantId);


}
