package com.groupe2cs.bizyhub.tenant.infrastructure.repository;

import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, String> {

	@Query("SELECT e FROM Tenant e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Tenant> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM Tenant e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Tenant> findByIdAndTenantId(String id, String tenantId);

	@Query("SELECT e FROM Tenant e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Tenant> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Tenant e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Tenant> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Tenant e WHERE e.name = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Tenant> findByName(String name);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByDescriptionAndCreatedById(String description, String createdById);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByDescriptionAndTenantName(String description, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByDescriptionAndTenantId(String description, String tenantId);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.domain) LIKE LOWER(CONCAT('%', :domain, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByDomainAndCreatedById(String domain, String createdById);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.domain) LIKE LOWER(CONCAT('%', :domain, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByDomainAndTenantName(String domain, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.domain) LIKE LOWER(CONCAT('%', :domain, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByDomainAndTenantId(String domain, String tenantId);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.language) LIKE LOWER(CONCAT('%', :language, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByLanguageAndCreatedById(String language, String createdById);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.language) LIKE LOWER(CONCAT('%', :language, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByLanguageAndTenantName(String language, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.language) LIKE LOWER(CONCAT('%', :language, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByLanguageAndTenantId(String language, String tenantId);

	@Query("SELECT e FROM Tenant e WHERE e.active = :active AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByActiveAndCreatedById(Boolean active, String createdById);

	@Query("SELECT e FROM Tenant e WHERE e.active = :active AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByActiveAndTenantName(Boolean active, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE e.active = :active AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByActiveAndTenantId(Boolean active, String tenantId);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByTenantIdAndTenantId(String tenant, String tenantId);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Tenant e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Tenant> findByCreatedByIdAndTenantId(String createdBy, String tenantId);


}
