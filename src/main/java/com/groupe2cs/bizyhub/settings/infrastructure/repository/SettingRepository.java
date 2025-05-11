package com.groupe2cs.bizyhub.settings.infrastructure.repository;

	import com.groupe2cs.bizyhub.settings.infrastructure.entity.Setting;
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
public interface SettingRepository extends JpaRepository<Setting, String> {

	@Query("SELECT e FROM Setting e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<Setting> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Setting e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByIdAndTenantId(String id, String tenantId);

	Page<Setting> findByCreatedById(String createdById, Pageable pageable);
	Page<Setting> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM Setting e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Setting> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.name = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Setting> findByName(String name);

	@Query("SELECT e FROM Setting e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.stringValue = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Setting> findByStringValueAndCreatedById(String stringValue, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.stringValue = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Setting> findByStringValue(String stringValue);

	@Query("SELECT e FROM Setting e WHERE e.stringValue = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByStringValueAndTenantName(String stringValue, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.stringValue = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByStringValueAndTenantId(String stringValue, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.description = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Setting> findByDescriptionAndCreatedById(String description, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.description = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Setting> findByDescription(String description);

	@Query("SELECT e FROM Setting e WHERE e.description = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByDescriptionAndTenantName(String description, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.description = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByDescriptionAndTenantId(String description, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Setting> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.isActive = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Setting> findByIsActive(Boolean isActive);

	@Query("SELECT e FROM Setting e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.updatedAt = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Setting> findByUpdatedAtAndCreatedById(java.time.Instant updatedAt, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.updatedAt = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Setting> findByUpdatedAt(java.time.Instant updatedAt);

	@Query("SELECT e FROM Setting e WHERE e.updatedAt = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByUpdatedAtAndTenantName(java.time.Instant updatedAt, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.updatedAt = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByUpdatedAtAndTenantId(java.time.Instant updatedAt, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.reference = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Setting> findByReferenceAndCreatedById(String reference, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.reference = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Setting> findByReference(String reference);

	@Query("SELECT e FROM Setting e WHERE e.reference = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByReferenceAndTenantName(String reference, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.reference = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByReferenceAndTenantId(String reference, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Setting> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Setting> findByCreatedById(String createdBy);

	@Query("SELECT e FROM Setting e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Setting> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Setting> findByTenantId(String tenant);

	@Query("SELECT e FROM Setting e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Setting> findByTenantIdAndTenantId(String tenant, String tenantId);




}
