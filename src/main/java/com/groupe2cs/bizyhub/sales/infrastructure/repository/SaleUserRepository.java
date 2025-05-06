package com.groupe2cs.bizyhub.sales.infrastructure.repository;

	import com.groupe2cs.bizyhub.sales.infrastructure.entity.SaleUser;
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
public interface SaleUserRepository extends JpaRepository<SaleUser, String> {

	@Query("SELECT e FROM SaleUser e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByIdAndCreatedById(String id, String createdById);
	Page<SaleUser> findByCreatedById(String createdById, Pageable pageable);
	Page<SaleUser> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM SaleUser e WHERE e.sales.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findBySalesIdAndCreatedById(String sales, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.sales.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findBySalesIdAndTenantName(String sales, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.sales.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findBySalesIdAndTenantId(String sales, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.users.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByUsersIdAndCreatedById(String users, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.users.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByUsersIdAndTenantName(String users, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.users.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByUsersIdAndTenantId(String users, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByUsernameAndCreatedById(String username, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByUsernameAndTenantId(String username, String tenantId);
	@Query("SELECT e FROM SaleUser e WHERE e.email = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<SaleUser> findByEmailAndCreatedById(String email, String createdById);

	@Query("SELECT e FROM SaleUser e WHERE e.email = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByEmailAndTenantName(String email, String tenantName);

	@Query("SELECT e FROM SaleUser e WHERE e.email = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<SaleUser> findByEmailAndTenantId(String email, String tenantId);
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
