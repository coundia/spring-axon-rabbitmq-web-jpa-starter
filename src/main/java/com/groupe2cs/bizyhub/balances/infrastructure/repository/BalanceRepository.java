package com.groupe2cs.bizyhub.balances.infrastructure.repository;

	import com.groupe2cs.bizyhub.balances.infrastructure.entity.Balance;
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
public interface BalanceRepository extends JpaRepository<Balance, String> {

	@Query("SELECT e FROM Balance e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<Balance> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Balance e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByIdAndTenantId(String id, String tenantId);

	Page<Balance> findByCreatedById(String createdById, Pageable pageable);
	Page<Balance> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM Balance e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.name = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByName(String name);

	@Query("SELECT e FROM Balance e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.currency = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByCurrencyAndCreatedById(String currency, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.currency = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByCurrency(String currency);

	@Query("SELECT e FROM Balance e WHERE e.currency = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByCurrencyAndTenantName(String currency, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.currency = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByCurrencyAndTenantId(String currency, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.currentBalance = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByCurrentBalanceAndCreatedById(Double currentBalance, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.currentBalance = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByCurrentBalance(Double currentBalance);

	@Query("SELECT e FROM Balance e WHERE e.currentBalance = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByCurrentBalanceAndTenantName(Double currentBalance, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.currentBalance = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByCurrentBalanceAndTenantId(Double currentBalance, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.previousBalance = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByPreviousBalanceAndCreatedById(Double previousBalance, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.previousBalance = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByPreviousBalance(Double previousBalance);

	@Query("SELECT e FROM Balance e WHERE e.previousBalance = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByPreviousBalanceAndTenantName(Double previousBalance, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.previousBalance = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByPreviousBalanceAndTenantId(Double previousBalance, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.lastUpdated = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByLastUpdatedAndCreatedById(java.time.Instant lastUpdated, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.lastUpdated = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByLastUpdated(java.time.Instant lastUpdated);

	@Query("SELECT e FROM Balance e WHERE e.lastUpdated = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByLastUpdatedAndTenantName(java.time.Instant lastUpdated, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.lastUpdated = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByLastUpdatedAndTenantId(java.time.Instant lastUpdated, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.isDefault = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByIsDefaultAndCreatedById(Boolean isDefault, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.isDefault = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByIsDefault(Boolean isDefault);

	@Query("SELECT e FROM Balance e WHERE e.isDefault = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByIsDefaultAndTenantName(Boolean isDefault, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.isDefault = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByIsDefaultAndTenantId(Boolean isDefault, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.ordre = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByOrdreAndCreatedById(Integer ordre, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.ordre = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByOrdre(Integer ordre);

	@Query("SELECT e FROM Balance e WHERE e.ordre = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByOrdreAndTenantName(Integer ordre, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.ordre = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByOrdreAndTenantId(Integer ordre, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.isArchived = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByIsArchivedAndCreatedById(Boolean isArchived, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.isArchived = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByIsArchived(Boolean isArchived);

	@Query("SELECT e FROM Balance e WHERE e.isArchived = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByIsArchivedAndTenantName(Boolean isArchived, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.isArchived = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByIsArchivedAndTenantId(Boolean isArchived, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.isAllowDebit = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByIsAllowDebitAndCreatedById(Boolean isAllowDebit, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.isAllowDebit = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByIsAllowDebit(Boolean isAllowDebit);

	@Query("SELECT e FROM Balance e WHERE e.isAllowDebit = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByIsAllowDebitAndTenantName(Boolean isAllowDebit, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.isAllowDebit = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByIsAllowDebitAndTenantId(Boolean isAllowDebit, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.isAllowCredit = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByIsAllowCreditAndCreatedById(Boolean isAllowCredit, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.isAllowCredit = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByIsAllowCredit(Boolean isAllowCredit);

	@Query("SELECT e FROM Balance e WHERE e.isAllowCredit = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByIsAllowCreditAndTenantName(Boolean isAllowCredit, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.isAllowCredit = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByIsAllowCreditAndTenantId(Boolean isAllowCredit, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.isExcluTotal = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByIsExcluTotalAndCreatedById(Boolean isExcluTotal, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.isExcluTotal = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByIsExcluTotal(Boolean isExcluTotal);

	@Query("SELECT e FROM Balance e WHERE e.isExcluTotal = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByIsExcluTotalAndTenantName(Boolean isExcluTotal, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.isExcluTotal = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByIsExcluTotalAndTenantId(Boolean isExcluTotal, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.activateNotification = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByActivateNotificationAndCreatedById(Boolean activateNotification, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.activateNotification = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByActivateNotification(Boolean activateNotification);

	@Query("SELECT e FROM Balance e WHERE e.activateNotification = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByActivateNotificationAndTenantName(Boolean activateNotification, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.activateNotification = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByActivateNotificationAndTenantId(Boolean activateNotification, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.syncedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findBySyncedAtAndCreatedById(java.time.Instant syncedAt, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.syncedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findBySyncedAt(java.time.Instant syncedAt);

	@Query("SELECT e FROM Balance e WHERE e.syncedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findBySyncedAtAndTenantName(java.time.Instant syncedAt, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.syncedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findBySyncedAtAndTenantId(java.time.Instant syncedAt, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.updatedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByUpdatedAt(java.time.Instant updatedAt);

	@Query("SELECT e FROM Balance e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByReferenceAndCreatedById(String reference, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.reference = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByReference(String reference);

	@Query("SELECT e FROM Balance e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByCreatedById(String createdBy);

	@Query("SELECT e FROM Balance e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Balance e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Balance> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Balance e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Balance> findByTenantId(String tenant);

	@Query("SELECT e FROM Balance e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Balance e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Balance> findByTenantIdAndTenantId(String tenant, String tenantId);




}
