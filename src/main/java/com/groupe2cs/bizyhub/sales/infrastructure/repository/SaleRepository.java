package com.groupe2cs.bizyhub.sales.infrastructure.repository;

	import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
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
public interface SaleRepository extends JpaRepository<Sale, String> {

	@Query("SELECT e FROM Sale e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<Sale> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Sale e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByIdAndTenantId(String id, String tenantId);

	Page<Sale> findByCreatedById(String createdById, Pageable pageable);
	Page<Sale> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM Sale e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Sale> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.name = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Sale> findByName(String name);

	@Query("SELECT e FROM Sale e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Sale e WHERE e.amount = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Sale> findByAmountAndCreatedById(Double amount, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.amount = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Sale> findByAmount(Double amount);

	@Query("SELECT e FROM Sale e WHERE e.amount = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByAmountAndTenantName(Double amount, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.amount = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByAmountAndTenantId(Double amount, String tenantId);

	@Query("SELECT e FROM Sale e WHERE e.details = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Sale> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.details = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Sale> findByDetails(String details);

	@Query("SELECT e FROM Sale e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByDetailsAndTenantId(String details, String tenantId);

	@Query("SELECT e FROM Sale e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Sale> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.isActive = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Sale> findByIsActive(Boolean isActive);

	@Query("SELECT e FROM Sale e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM Sale e WHERE e.account.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Sale> findByAccountIdAndCreatedById(String account, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.account.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Sale> findByAccountId(String account);

	@Query("SELECT e FROM Sale e WHERE e.account.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByAccountIdAndTenantName(String account, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.account.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByAccountIdAndTenantId(String account, String tenantId);

	@Query("SELECT e FROM Sale e WHERE e.category.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Sale> findByCategoryIdAndCreatedById(String category, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.category.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Sale> findByCategoryId(String category);

	@Query("SELECT e FROM Sale e WHERE e.category.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByCategoryIdAndTenantName(String category, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.category.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByCategoryIdAndTenantId(String category, String tenantId);

	@Query("SELECT e FROM Sale e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Sale> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.updatedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Sale> findByUpdatedAt(java.time.Instant updatedAt);

	@Query("SELECT e FROM Sale e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);

	@Query("SELECT e FROM Sale e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Sale> findByReferenceAndCreatedById(String reference, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.reference = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Sale> findByReference(String reference);

	@Query("SELECT e FROM Sale e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM Sale e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Sale> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Sale> findByCreatedById(String createdBy);

	@Query("SELECT e FROM Sale e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Sale e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Sale> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Sale> findByTenantId(String tenant);

	@Query("SELECT e FROM Sale e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Sale> findByTenantIdAndTenantId(String tenant, String tenantId);

    @Query("""
    SELECT DISTINCT s FROM Sale s
    LEFT JOIN SaleUser su ON su.sale = s
    WHERE s.tenant.id = :tenantId AND (s.createdBy.id = :userId OR su.user.id = :userId)
    """)
	Page<Sale> findAllOwnedOrShared(@Param("userId") String userId, @Param("tenantId") String tenantId, Pageable pageable);



}
