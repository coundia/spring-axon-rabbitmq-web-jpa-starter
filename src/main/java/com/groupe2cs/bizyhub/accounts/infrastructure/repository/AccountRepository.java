package com.groupe2cs.bizyhub.accounts.infrastructure.repository;

import com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	@Query("SELECT e FROM Account e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<Account> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM Account e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByIdAndTenantId(String id, String tenantId);

	Page<Account> findByCreatedById(String createdById, Pageable pageable);

	Page<Account> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM Account e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Account> findByNameAndCreatedById(String name, String createdById);


	@Query("SELECT e FROM Account e WHERE e.name = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Account> findByName(String name);

	@Query("SELECT e FROM Account e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.currency = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Account> findByCurrencyAndCreatedById(String currency, String createdById);


	@Query("SELECT e FROM Account e WHERE e.currency = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Account> findByCurrency(String currency);

	@Query("SELECT e FROM Account e WHERE e.currency = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByCurrencyAndTenantName(String currency, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.currency = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByCurrencyAndTenantId(String currency, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.currentBalance = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Account> findByCurrentBalanceAndCreatedById(Double currentBalance, String createdById);


	@Query("SELECT e FROM Account e WHERE e.currentBalance = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Account> findByCurrentBalance(Double currentBalance);

	@Query("SELECT e FROM Account e WHERE e.currentBalance = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByCurrentBalanceAndTenantName(Double currentBalance, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.currentBalance = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByCurrentBalanceAndTenantId(Double currentBalance, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.previousBalance = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Account> findByPreviousBalanceAndCreatedById(Double previousBalance, String createdById);


	@Query("SELECT e FROM Account e WHERE e.previousBalance = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Account> findByPreviousBalance(Double previousBalance);

	@Query("SELECT e FROM Account e WHERE e.previousBalance = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByPreviousBalanceAndTenantName(Double previousBalance, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.previousBalance = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByPreviousBalanceAndTenantId(Double previousBalance, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.details = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Account> findByDetailsAndCreatedById(String details, String createdById);


	@Query("SELECT e FROM Account e WHERE e.details = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Account> findByDetails(String details);

	@Query("SELECT e FROM Account e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByDetailsAndTenantId(String details, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Account> findByIsActiveAndCreatedById(Boolean isActive, String createdById);


	@Query("SELECT e FROM Account e WHERE e.isActive = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Account> findByIsActive(Boolean isActive);

	@Query("SELECT e FROM Account e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Account> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);


	@Query("SELECT e FROM Account e WHERE e.updatedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Account> findByUpdatedAt(java.time.Instant updatedAt);

	@Query("SELECT e FROM Account e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Account> findByReferenceAndCreatedById(String reference, String createdById);


	@Query("SELECT e FROM Account e WHERE e.reference = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Account> findByReference(String reference);

	@Query("SELECT e FROM Account e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Account> findByCreatedByIdAndCreatedById(String createdBy, String createdById);


	@Query("SELECT e FROM Account e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Account> findByCreatedById(String createdBy);

	@Query("SELECT e FROM Account e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Account> findByTenantIdAndCreatedById(String tenant, String createdById);


	@Query("SELECT e FROM Account e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Account> findByTenantId(String tenant);

	@Query("SELECT e FROM Account e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Account> findByTenantIdAndTenantId(String tenant, String tenantId);

	@Query("""
			SELECT DISTINCT s FROM Account s
			LEFT JOIN AccountUser su ON su.account = s
			WHERE s.tenant.id = :tenantId AND (s.createdBy.id = :userId OR su.user.id = :userId)
			""")
	Page<Account> findAllOwnedOrShared(@Param("userId") String userId, @Param("tenantId") String tenantId, Pageable pageable);


}
