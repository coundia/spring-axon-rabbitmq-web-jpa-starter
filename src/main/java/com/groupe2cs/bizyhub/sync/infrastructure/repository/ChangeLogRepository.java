package com.groupe2cs.bizyhub.sync.infrastructure.repository;

	import com.groupe2cs.bizyhub.sync.infrastructure.entity.ChangeLog;
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
public interface ChangeLogRepository extends JpaRepository<ChangeLog, String> {

	@Query("SELECT e FROM ChangeLog e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<ChangeLog> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM ChangeLog e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<ChangeLog> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM ChangeLog e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<ChangeLog> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM ChangeLog e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<ChangeLog> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.entityTable) LIKE LOWER(CONCAT('%', :entityTable, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByEntityTableAndCreatedById(String entityTable, String createdById);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.entityTable) LIKE LOWER(CONCAT('%', :entityTable, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByEntityTableAndTenantName(String entityTable, String tenantName);

        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.entityTable) LIKE LOWER(CONCAT('%', :entityTable, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<ChangeLog> findByEntityTableAndTenantId(String entityTable, String tenantId);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.entityId) LIKE LOWER(CONCAT('%', :entityId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByEntityIdAndCreatedById(String entityId, String createdById);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.entityId) LIKE LOWER(CONCAT('%', :entityId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByEntityIdAndTenantName(String entityId, String tenantName);

        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.entityId) LIKE LOWER(CONCAT('%', :entityId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<ChangeLog> findByEntityIdAndTenantId(String entityId, String tenantId);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.operation) LIKE LOWER(CONCAT('%', :operation, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByOperationAndCreatedById(String operation, String createdById);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.operation) LIKE LOWER(CONCAT('%', :operation, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByOperationAndTenantName(String operation, String tenantName);

        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.operation) LIKE LOWER(CONCAT('%', :operation, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<ChangeLog> findByOperationAndTenantId(String operation, String tenantId);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.payload) LIKE LOWER(CONCAT('%', :payload, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByPayloadAndCreatedById(String payload, String createdById);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.payload) LIKE LOWER(CONCAT('%', :payload, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByPayloadAndTenantName(String payload, String tenantName);

        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.payload) LIKE LOWER(CONCAT('%', :payload, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<ChangeLog> findByPayloadAndTenantId(String payload, String tenantId);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByStatusAndCreatedById(String status, String createdById);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByStatusAndTenantName(String status, String tenantName);

        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<ChangeLog> findByStatusAndTenantId(String status, String tenantId);
        @Query("""
        SELECT e FROM ChangeLog e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.syncAt < :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<ChangeLog> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
        SELECT e FROM ChangeLog e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.syncAt < :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<ChangeLog> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);


        @Query("SELECT e FROM ChangeLog e WHERE e.attempts = :attempts AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByAttemptsAndCreatedById(Integer attempts, String createdById);
        @Query("SELECT e FROM ChangeLog e WHERE e.attempts = :attempts AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByAttemptsAndTenantName(Integer attempts, String tenantName);

        @Query("SELECT e FROM ChangeLog e WHERE e.attempts = :attempts AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<ChangeLog> findByAttemptsAndTenantId(Integer attempts, String tenantId);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.error) LIKE LOWER(CONCAT('%', :error, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByErrorAndCreatedById(String error, String createdById);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.error) LIKE LOWER(CONCAT('%', :error, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByErrorAndTenantName(String error, String tenantName);

        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.error) LIKE LOWER(CONCAT('%', :error, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<ChangeLog> findByErrorAndTenantId(String error, String tenantId);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<ChangeLog> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<ChangeLog> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM ChangeLog e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<ChangeLog> findByTenantIdAndTenantId(String tenant, String tenantId);




}
