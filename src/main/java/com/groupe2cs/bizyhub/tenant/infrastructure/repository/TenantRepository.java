package com.groupe2cs.bizyhub.tenant.infrastructure.repository;

	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
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
public interface TenantRepository extends JpaRepository<Tenant, String> {

	@Query("SELECT e FROM Tenant e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByIdAndCreatedById(String id, String createdById);
	Page<Tenant> findByCreatedById(String createdById, Pageable pageable);
	Page<Tenant> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM Tenant e WHERE e.name = ?1  ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByName(String name);

	@Query("SELECT e FROM Tenant e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByNameAndCreatedById(String name, String createdById);


	@Query("SELECT e FROM Tenant e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByNameAndTenantId(String name, String tenantId);
	@Query("SELECT e FROM Tenant e WHERE e.description = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Tenant> findByDescriptionAndCreatedById(String description, String createdById);

	@Query("SELECT e FROM Tenant e WHERE e.description = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByDescriptionAndTenantName(String description, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE e.description = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByDescriptionAndTenantId(String description, String tenantId);
	@Query("SELECT e FROM Tenant e WHERE e.domain = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Tenant> findByDomainAndCreatedById(String domain, String createdById);

	@Query("SELECT e FROM Tenant e WHERE e.domain = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByDomainAndTenantName(String domain, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE e.domain = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByDomainAndTenantId(String domain, String tenantId);
	@Query("SELECT e FROM Tenant e WHERE e.language = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Tenant> findByLanguageAndCreatedById(String language, String createdById);

	@Query("SELECT e FROM Tenant e WHERE e.language = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByLanguageAndTenantName(String language, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE e.language = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByLanguageAndTenantId(String language, String tenantId);
	@Query("SELECT e FROM Tenant e WHERE e.active = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Tenant> findByActiveAndCreatedById(Boolean active, String createdById);

	@Query("SELECT e FROM Tenant e WHERE e.active = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByActiveAndTenantName(Boolean active, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE e.active = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByActiveAndTenantId(Boolean active, String tenantId);
	@Query("SELECT e FROM Tenant e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Tenant> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Tenant e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByTenantIdAndTenantId(String tenant, String tenantId);
	@Query("SELECT e FROM Tenant e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Tenant> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Tenant e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Tenant> findByCreatedByIdAndTenantId(String createdBy, String tenantId);


}
