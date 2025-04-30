package com.groupe2cs.bizyhub.settings.infrastructure.repository;

import com.groupe2cs.bizyhub.settings.infrastructure.entity.Setting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SettingRepository extends JpaRepository<Setting, String> {

	@Query("SELECT e FROM Setting e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByIdAndCreatedById(String id, String createdById);

	Page<Setting> findByCreatedById(String createdById, Pageable pageable);

	Page<Setting> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM Setting e WHERE e.name = ?1  ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByName(String name);

	@Query("SELECT e FROM Setting e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByNameAndCreatedById(String name, String createdById);


	@Query("SELECT e FROM Setting e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.stringValue = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Setting> findByStringValueAndCreatedById(String stringValue, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.stringValue = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByStringValueAndTenantName(String stringValue, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.stringValue = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByStringValueAndTenantId(String stringValue, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.description = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Setting> findByDescriptionAndCreatedById(String description, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.description = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByDescriptionAndTenantName(String description, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.description = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByDescriptionAndTenantId(String description, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.isActive = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Setting> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.isActive = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.isActive = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Setting> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Setting> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Setting> findByTenantIdAndTenantId(String tenant, String tenantId);


}
