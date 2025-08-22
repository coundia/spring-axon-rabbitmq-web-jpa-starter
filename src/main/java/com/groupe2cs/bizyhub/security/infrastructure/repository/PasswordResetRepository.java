package com.groupe2cs.bizyhub.security.infrastructure.repository;

	import com.groupe2cs.bizyhub.security.infrastructure.entity.PasswordReset;
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
public interface PasswordResetRepository extends JpaRepository<PasswordReset, String> {

	@Query("SELECT e FROM PasswordReset e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<PasswordReset> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM PasswordReset e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<PasswordReset> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM PasswordReset e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<PasswordReset> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM PasswordReset e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<PasswordReset> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.token) LIKE LOWER(CONCAT('%', :token, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<PasswordReset> findByTokenAndCreatedById(String token, String createdById);
        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.token) LIKE LOWER(CONCAT('%', :token, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<PasswordReset> findByTokenAndTenantName(String token, String tenantName);

        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.token) LIKE LOWER(CONCAT('%', :token, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<PasswordReset> findByTokenAndTenantId(String token, String tenantId);
        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<PasswordReset> findByUsernameAndCreatedById(String username, String createdById);
        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<PasswordReset> findByUsernameAndTenantName(String username, String tenantName);

        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<PasswordReset> findByUsernameAndTenantId(String username, String tenantId);
        @Query("""
        SELECT e FROM PasswordReset e
        WHERE e.expiration >= :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.expiration < :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<PasswordReset> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);

         @Query("""
        SELECT e FROM PasswordReset e
        WHERE e.expiration >= :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.expiration < :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<PasswordReset> findByExpirationAndTenantId(java.time.Instant expiration, String tenantId);


        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<PasswordReset> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<PasswordReset> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<PasswordReset> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<PasswordReset> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<PasswordReset> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM PasswordReset e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<PasswordReset> findByTenantIdAndTenantId(String tenant, String tenantId);




}
