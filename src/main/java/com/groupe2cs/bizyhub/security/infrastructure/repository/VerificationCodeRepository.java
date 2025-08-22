package com.groupe2cs.bizyhub.security.infrastructure.repository;

	import com.groupe2cs.bizyhub.security.infrastructure.entity.VerificationCode;
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
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, String> {

	@Query("SELECT e FROM VerificationCode e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<VerificationCode> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM VerificationCode e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<VerificationCode> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM VerificationCode e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<VerificationCode> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM VerificationCode e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<VerificationCode> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.token) LIKE LOWER(CONCAT('%', :token, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByTokenAndCreatedById(String token, String createdById);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.token) LIKE LOWER(CONCAT('%', :token, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByTokenAndTenantName(String token, String tenantName);

        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.token) LIKE LOWER(CONCAT('%', :token, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<VerificationCode> findByTokenAndTenantId(String token, String tenantId);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByUsernameAndCreatedById(String username, String createdById);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByUsernameAndTenantName(String username, String tenantName);

        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.username) LIKE LOWER(CONCAT('%', :username, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<VerificationCode> findByUsernameAndTenantId(String username, String tenantId);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByEmailAndCreatedById(String email, String createdById);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByEmailAndTenantName(String email, String tenantName);

        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<VerificationCode> findByEmailAndTenantId(String email, String tenantId);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByCodeAndCreatedById(String code, String createdById);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByCodeAndTenantName(String code, String tenantName);

        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<VerificationCode> findByCodeAndTenantId(String code, String tenantId);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByStatusAndCreatedById(String status, String createdById);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByStatusAndTenantName(String status, String tenantName);

        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<VerificationCode> findByStatusAndTenantId(String status, String tenantId);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.source) LIKE LOWER(CONCAT('%', :source, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findBySourceAndCreatedById(String source, String createdById);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.source) LIKE LOWER(CONCAT('%', :source, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findBySourceAndTenantName(String source, String tenantName);

        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.source) LIKE LOWER(CONCAT('%', :source, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<VerificationCode> findBySourceAndTenantId(String source, String tenantId);
        @Query("""
        SELECT e FROM VerificationCode e
        WHERE e.expiration >= :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.expiration < :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<VerificationCode> findByExpirationAndCreatedById(java.time.Instant expiration, String createdById);

         @Query("""
        SELECT e FROM VerificationCode e
        WHERE e.expiration >= :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.expiration < :#{#expiration.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<VerificationCode> findByExpirationAndTenantId(java.time.Instant expiration, String tenantId);


        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<VerificationCode> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<VerificationCode> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM VerificationCode e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<VerificationCode> findByTenantIdAndTenantId(String tenant, String tenantId);




}
