package com.groupe2cs.bizyhub.balances.infrastructure.repository;

import com.groupe2cs.bizyhub.balances.infrastructure.entity.Balance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, String> {

	@Query("SELECT e FROM Balance e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByIdAndCreatedById(String id, String createdById);

	Page<Balance> findByCreatedById(String createdById, Pageable pageable);

	Page<Balance> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Balance e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.currency = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByCurrencyAndCreatedById(String currency, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.currency = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByCurrencyAndTenantName(String currency, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.currency = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByCurrencyAndTenantId(String currency, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.currentBalance = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByCurrentBalanceAndCreatedById(Double currentBalance, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.currentBalance = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByCurrentBalanceAndTenantName(Double currentBalance, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.currentBalance = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByCurrentBalanceAndTenantId(Double currentBalance, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.previousBalance = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByPreviousBalanceAndCreatedById(Double previousBalance, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.previousBalance = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByPreviousBalanceAndTenantName(Double previousBalance, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.previousBalance = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByPreviousBalanceAndTenantId(Double previousBalance, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.lastUpdated = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByLastUpdatedAndCreatedById(java.time.Instant lastUpdated, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.lastUpdated = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByLastUpdatedAndTenantName(java.time.Instant lastUpdated, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.lastUpdated = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByLastUpdatedAndTenantId(java.time.Instant lastUpdated, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.isDefault = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByIsDefaultAndCreatedById(Boolean isDefault, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.isDefault = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByIsDefaultAndTenantName(Boolean isDefault, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.isDefault = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByIsDefaultAndTenantId(Boolean isDefault, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.ordre = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByOrdreAndCreatedById(Integer ordre, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.ordre = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByOrdreAndTenantName(Integer ordre, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.ordre = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByOrdreAndTenantId(Integer ordre, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.isArchived = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByIsArchivedAndCreatedById(Boolean isArchived, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.isArchived = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByIsArchivedAndTenantName(Boolean isArchived, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.isArchived = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByIsArchivedAndTenantId(Boolean isArchived, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.isAllowDebit = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByIsAllowDebitAndCreatedById(Boolean isAllowDebit, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.isAllowDebit = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByIsAllowDebitAndTenantName(Boolean isAllowDebit, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.isAllowDebit = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByIsAllowDebitAndTenantId(Boolean isAllowDebit, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.isAllowCredit = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByIsAllowCreditAndCreatedById(Boolean isAllowCredit, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.isAllowCredit = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByIsAllowCreditAndTenantName(Boolean isAllowCredit, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.isAllowCredit = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByIsAllowCreditAndTenantId(Boolean isAllowCredit, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.isExcluTotal = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByIsExcluTotalAndCreatedById(Boolean isExcluTotal, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.isExcluTotal = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByIsExcluTotalAndTenantName(Boolean isExcluTotal, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.isExcluTotal = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByIsExcluTotalAndTenantId(Boolean isExcluTotal, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.activateNotification = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByActivateNotificationAndCreatedById(Boolean activateNotification, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.activateNotification = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByActivateNotificationAndTenantName(Boolean activateNotification, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.activateNotification = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByActivateNotificationAndTenantId(Boolean activateNotification, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.syncedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findBySyncedAtAndCreatedById(java.time.Instant syncedAt, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.syncedAt = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findBySyncedAtAndTenantName(java.time.Instant syncedAt, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.syncedAt = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findBySyncedAtAndTenantId(java.time.Instant syncedAt, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Balance> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Balance> findByTenantIdAndTenantId(String tenant, String tenantId);


}
