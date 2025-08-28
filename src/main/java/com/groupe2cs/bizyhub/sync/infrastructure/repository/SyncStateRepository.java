package com.groupe2cs.bizyhub.sync.infrastructure.repository;

	import com.groupe2cs.bizyhub.sync.infrastructure.entity.SyncState;
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
public interface SyncStateRepository extends JpaRepository<SyncState, String> {

	@Query("SELECT e FROM SyncState e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<SyncState> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM SyncState e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<SyncState> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM SyncState e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<SyncState> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM SyncState e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<SyncState> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM SyncState e WHERE LOWER(e.entityTable) LIKE LOWER(CONCAT('%', :entityTable, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByEntityTableAndCreatedById(String entityTable, String createdById);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.entityTable) LIKE LOWER(CONCAT('%', :entityTable, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByEntityTableAndTenantName(String entityTable, String tenantName);

        @Query("SELECT e FROM SyncState e WHERE LOWER(e.entityTable) LIKE LOWER(CONCAT('%', :entityTable, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<SyncState> findByEntityTableAndTenantId(String entityTable, String tenantId);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM SyncState e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<SyncState> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByLocalIdAndCreatedById(String localId, String createdById);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByLocalIdAndTenantName(String localId, String tenantName);

        @Query("SELECT e FROM SyncState e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<SyncState> findByLocalIdAndTenantId(String localId, String tenantId);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByAccountAndCreatedById(String account, String createdById);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByAccountAndTenantName(String account, String tenantName);

        @Query("SELECT e FROM SyncState e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<SyncState> findByAccountAndTenantId(String account, String tenantId);
         @Query("""
        SELECT e FROM SyncState e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<SyncState> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);



        @Query("""
        SELECT e FROM SyncState e
        WHERE e.lastSyncAt >= :#{#lastSyncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<SyncState> findByLastSyncAtAndCreatedById(java.time.Instant lastSyncAt, String createdById);
         @Query("""
        SELECT e FROM SyncState e
        WHERE e.lastSyncAt >= :#{#lastSyncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<SyncState> findByLastSyncAtAndTenantId(java.time.Instant lastSyncAt, String tenantId);



        @Query("SELECT e FROM SyncState e WHERE LOWER(e.lastCursor) LIKE LOWER(CONCAT('%', :lastCursor, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByLastCursorAndCreatedById(String lastCursor, String createdById);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.lastCursor) LIKE LOWER(CONCAT('%', :lastCursor, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByLastCursorAndTenantName(String lastCursor, String tenantName);

        @Query("SELECT e FROM SyncState e WHERE LOWER(e.lastCursor) LIKE LOWER(CONCAT('%', :lastCursor, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<SyncState> findByLastCursorAndTenantId(String lastCursor, String tenantId);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM SyncState e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<SyncState> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM SyncState e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<SyncState> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM SyncState e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<SyncState> findByTenantIdAndTenantId(String tenant, String tenantId);


	@Query("""
        SELECT e FROM SyncState  e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
         AND (
                 e.createdBy.id = :createdById
                 OR EXISTS (
                      SELECT 1
                      FROM AccountUser au, User u
                      WHERE au.account = e.account
                        AND (
                              (au.identity IS NOT NULL AND au.identity = u.username)
                           OR (au.email    IS NOT NULL AND au.email    = u.email)
                           OR (au.phone    IS NOT NULL AND au.phone    = u.telephone)
                        )
                 )
            )
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<SyncState> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
            select case when count(e)>0 then true else false end
                 from SyncState  e
                     where e.id=:id
                        and (
                            e.createdBy.id = :userId
                            or exists (
                                select 1
                                    from AccountUser au, User u
                                    where au.account = e.account
                                    and (
                                    (au.identity is not null and au.identity = u.username)
                                        or (au.email is not null and au.email = u.email)
                                        or (au.phone is not null and au.phone = u.telephone)
                                    )
                        )
            )
            """)
    boolean isOwner( @Param("id") String id,@Param("userId") String userId);



}
