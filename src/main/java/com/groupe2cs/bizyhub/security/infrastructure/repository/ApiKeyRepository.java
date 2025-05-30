package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApiKeyRepository extends JpaRepository<ApiKey, String> {

	@Query("SELECT e FROM ApiKey e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<ApiKey> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<ApiKey> findByIdAndTenantId(String id, String tenantId);

	@Query("SELECT e FROM ApiKey e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<ApiKey> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM ApiKey e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<ApiKey> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.appKey) LIKE LOWER(CONCAT('%', :appKey, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByAppKeyAndCreatedById(String appKey, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.appKey) LIKE LOWER(CONCAT('%', :appKey, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByAppKeyAndTenantName(String appKey, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.appKey) LIKE LOWER(CONCAT('%', :appKey, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByAppKeyAndTenantId(String appKey, String tenantId);

	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByUsernameAndCreatedById(String username, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByUsernameAndTenantId(String username, String tenantId);

	@Query("SELECT e FROM ApiKey e WHERE e.active = :active AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByActiveAndCreatedById(Boolean active, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE e.active = :active AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByActiveAndTenantName(Boolean active, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE e.active = :active AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByActiveAndTenantId(Boolean active, String tenantId);

	@Query("""
			SELECT e FROM ApiKey e
			WHERE e.createdAt >= :#{#createdAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			AND e.createdAt < :#{#createdAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			AND e.createdBy.id = :createdById
			ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
			""")
	List<ApiKey> findByCreatedAtAndCreatedById(java.time.Instant createdAt, String createdById);

	@Query("""
			SELECT e FROM ApiKey e
			WHERE e.createdAt >= :#{#createdAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			AND e.createdAt < :#{#createdAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			AND e.tenant.id = :tenantId
			ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
			""")
	List<ApiKey> findByCreatedAtAndTenantId(java.time.Instant createdAt, String tenantId);


	@Query("""
			SELECT e FROM ApiKey e
			WHERE e.expiration >= :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			AND e.expiration < :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			AND e.createdBy.id = :createdById
			ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
			""")
	List<ApiKey> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);

	@Query("""
			SELECT e FROM ApiKey e
			WHERE e.expiration >= :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			AND e.expiration < :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			AND e.tenant.id = :tenantId
			ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
			""")
	List<ApiKey> findByExpirationAndTenantId(java.time.Instant expiration, String tenantId);


	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM ApiKey e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<ApiKey> findByTenantIdAndTenantId(String tenant, String tenantId);


}
