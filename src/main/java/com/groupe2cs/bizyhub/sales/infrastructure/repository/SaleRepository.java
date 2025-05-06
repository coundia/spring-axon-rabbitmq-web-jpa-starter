package com.groupe2cs.bizyhub.sales.infrastructure.repository;

	import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.*;
import java.util.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, String> {

	@Query("SELECT e FROM Sale e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByIdAndCreatedById(String id, String createdById);
	Page<Sale> findByCreatedById(String createdById, Pageable pageable);
	Page<Sale> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Sale e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Sale> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByNameAndTenantId(String name, String tenantId);
	@Query("SELECT e FROM Sale e WHERE e.amount = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Sale> findByAmountAndCreatedById(Double amount, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.amount = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByAmountAndTenantName(Double amount, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.amount = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByAmountAndTenantId(Double amount, String tenantId);
	@Query("SELECT e FROM Sale e WHERE e.details = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Sale> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByDetailsAndTenantId(String details, String tenantId);
	@Query("SELECT e FROM Sale e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Sale> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByIsActiveAndTenantId(Boolean isActive, String tenantId);
	@Query("SELECT e FROM Sale e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Sale> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);
	@Query("SELECT e FROM Sale e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Sale> findByReferenceAndCreatedById(String reference, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByReferenceAndTenantId(String reference, String tenantId);
	@Query("SELECT e FROM Sale e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Sale> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
	@Query("SELECT e FROM Sale e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Sale> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Sale e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Sale e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Sale> findByTenantIdAndTenantId(String tenant, String tenantId);


}
