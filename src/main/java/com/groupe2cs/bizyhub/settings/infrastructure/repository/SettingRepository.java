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

	@Query("SELECT e FROM Setting e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Setting> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Setting> findByIdAndTenantId(String id, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Setting> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Setting e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Setting> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.value) LIKE LOWER(CONCAT('%', :value, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByValueAndCreatedById(String value, String createdById);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.value) LIKE LOWER(CONCAT('%', :value, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByValueAndTenantName(String value, String tenantName);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.value) LIKE LOWER(CONCAT('%', :value, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByValueAndTenantId(String value, String tenantId);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.locale) LIKE LOWER(CONCAT('%', :locale, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByLocaleAndCreatedById(String locale, String createdById);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.locale) LIKE LOWER(CONCAT('%', :locale, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByLocaleAndTenantName(String locale, String tenantName);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.locale) LIKE LOWER(CONCAT('%', :locale, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByLocaleAndTenantId(String locale, String tenantId);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByDetailsAndTenantId(String details, String tenantId);

	@Query("SELECT e FROM Setting e WHERE e.isActive = :isActive AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByIsActiveAndCreatedById(Boolean isActive, String createdById);

	@Query("SELECT e FROM Setting e WHERE e.isActive = :isActive AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

	@Query("SELECT e FROM Setting e WHERE e.isActive = :isActive AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByIsActiveAndTenantId(Boolean isActive, String tenantId);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Setting e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Setting> findByTenantIdAndTenantId(String tenant, String tenantId);


}
