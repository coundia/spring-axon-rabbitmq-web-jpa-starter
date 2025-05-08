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

	@Query("SELECT e FROM SaleUser e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByIdAndCreatedById(String id, String createdById);
	Page<SaleUser> findByCreatedById(String createdById, Pageable pageable);
	Page<SaleUser> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM SaleUser e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByNameAndTenantId(String name, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.sale.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findBySaleIdAndCreatedById(String sale, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.sale.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findBySaleIdAndTenantName(String sale, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.sale.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findBySaleIdAndTenantId(String sale, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.user.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByUserIdAndCreatedById(String user, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.user.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByUserIdAndTenantName(String user, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.user.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByUserIdAndTenantId(String user, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByUsernameAndCreatedById(String username, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByUsernameAndTenantId(String username, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.details = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.details = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.details = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByDetailsAndTenantId(String details, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByIsActiveAndTenantId(Boolean isActive, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByReferenceAndCreatedById(String reference, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByReferenceAndTenantId(String reference, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByTenantIdAndTenantId(String tenant, String tenantId);




}
