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

	@Query("SELECT e FROM Account e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Account> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM Account e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Account> findByIdAndTenantId(String id, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Account> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Account e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Account> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Account e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Account e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Account e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Account e WHERE LOWER(e.currency) LIKE LOWER(CONCAT('%', :currency, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByCurrencyAndCreatedById(String currency, String createdById);

	@Query("SELECT e FROM Account e WHERE LOWER(e.currency) LIKE LOWER(CONCAT('%', :currency, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByCurrencyAndTenantName(String currency, String tenantName);

	@Query("SELECT e FROM Account e WHERE LOWER(e.currency) LIKE LOWER(CONCAT('%', :currency, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByCurrencyAndTenantId(String currency, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.currentBalance = :currentBalance AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByCurrentBalanceAndCreatedById(Double currentBalance, String createdById);

	@Query("SELECT e FROM Account e WHERE e.currentBalance = :currentBalance AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByCurrentBalanceAndTenantName(Double currentBalance, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.currentBalance = :currentBalance AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByCurrentBalanceAndTenantId(Double currentBalance, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.previousBalance = :previousBalance AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByPreviousBalanceAndCreatedById(Double previousBalance, String createdById);

	@Query("SELECT e FROM Account e WHERE e.previousBalance = :previousBalance AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByPreviousBalanceAndTenantName(Double previousBalance, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.previousBalance = :previousBalance AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByPreviousBalanceAndTenantId(Double previousBalance, String tenantId);

	@Query("SELECT e FROM Account e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM Account e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM Account e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByDetailsAndTenantId(String details, String tenantId);

	@Query("SELECT e FROM Account e WHERE e.isActive = :isActive AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM Account e WHERE e.isActive = :isActive AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM Account e WHERE e.isActive = :isActive AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM Account e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Account e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Account e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Account e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Account e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Account e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Account> findByTenantIdAndTenantId(String tenant, String tenantId);

	@Query("""
			SELECT DISTINCT s FROM Account s
			LEFT JOIN AccountUser su ON su.account = s
			WHERE s.tenant.id = :tenantId AND (s.createdBy.id = :userId OR su.user.id = :userId)
			ORDER BY s.updatedAtAudit DESC, s.createdAtAudit  DESC
			""")
	Page<Account> findAllOwnedOrShared(@Param("userId") String userId, @Param("tenantId") String tenantId, Pageable pageable);


}
