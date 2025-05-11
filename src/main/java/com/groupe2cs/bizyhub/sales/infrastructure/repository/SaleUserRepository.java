package com.groupe2cs.bizyhub.sales.infrastructure.repository;

	import com.groupe2cs.bizyhub.sales.infrastructure.entity.SaleUser;
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
public interface SaleUserRepository extends JpaRepository<SaleUser, String> {

	@Query("SELECT e FROM SaleUser e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<SaleUser> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM SaleUser e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByIdAndTenantId(String id, String tenantId);

	Page<SaleUser> findByCreatedById(String createdById, Pageable pageable);
	Page<SaleUser> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM SaleUser e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<SaleUser> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.name = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<SaleUser> findByName(String name);

	@Query("SELECT e FROM SaleUser e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM SaleUser e WHERE e.sale.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<SaleUser> findBySaleIdAndCreatedById(String sale, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.sale.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<SaleUser> findBySaleId(String sale);

	@Query("SELECT e FROM SaleUser e WHERE e.sale.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findBySaleIdAndTenantName(String sale, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.sale.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findBySaleIdAndTenantId(String sale, String tenantId);

	@Query("SELECT e FROM SaleUser e WHERE e.user.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<SaleUser> findByUserIdAndCreatedById(String user, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.user.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<SaleUser> findByUserId(String user);

	@Query("SELECT e FROM SaleUser e WHERE e.user.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByUserIdAndTenantName(String user, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.user.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByUserIdAndTenantId(String user, String tenantId);

	@Query("SELECT e FROM SaleUser e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<SaleUser> findByUsernameAndCreatedById(String username, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.username = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<SaleUser> findByUsername(String username);

	@Query("SELECT e FROM SaleUser e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByUsernameAndTenantId(String username, String tenantId);

	@Query("SELECT e FROM SaleUser e WHERE e.details = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<SaleUser> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.details = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<SaleUser> findByDetails(String details);

	@Query("SELECT e FROM SaleUser e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByDetailsAndTenantId(String details, String tenantId);

	@Query("SELECT e FROM SaleUser e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<SaleUser> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.isActive = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<SaleUser> findByIsActive(Boolean isActive);

	@Query("SELECT e FROM SaleUser e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM SaleUser e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<SaleUser> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.updatedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<SaleUser> findByUpdatedAt(java.time.Instant updatedAt);

	@Query("SELECT e FROM SaleUser e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);

	@Query("SELECT e FROM SaleUser e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<SaleUser> findByReferenceAndCreatedById(String reference, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.reference = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<SaleUser> findByReference(String reference);

	@Query("SELECT e FROM SaleUser e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM SaleUser e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<SaleUser> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<SaleUser> findByCreatedById(String createdBy);

	@Query("SELECT e FROM SaleUser e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM SaleUser e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<SaleUser> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<SaleUser> findByTenantId(String tenant);

	@Query("SELECT e FROM SaleUser e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<SaleUser> findByTenantIdAndTenantId(String tenant, String tenantId);




}
