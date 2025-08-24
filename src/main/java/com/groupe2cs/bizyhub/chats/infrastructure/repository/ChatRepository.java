package com.groupe2cs.bizyhub.chats.infrastructure.repository;

	import com.groupe2cs.bizyhub.chats.infrastructure.entity.Chat;
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
public interface ChatRepository extends JpaRepository<Chat, String> {

	@Query("SELECT e FROM Chat e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Chat> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Chat e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Chat> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM Chat e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Chat> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Chat e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Chat> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM Chat e WHERE LOWER(e.messages) LIKE LOWER(CONCAT('%', :messages, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByMessagesAndCreatedById(String messages, String createdById);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.messages) LIKE LOWER(CONCAT('%', :messages, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByMessagesAndTenantName(String messages, String tenantName);

        @Query("SELECT e FROM Chat e WHERE LOWER(e.messages) LIKE LOWER(CONCAT('%', :messages, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Chat> findByMessagesAndTenantId(String messages, String tenantId);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.responsesJson) LIKE LOWER(CONCAT('%', :responsesJson, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByResponsesJsonAndCreatedById(String responsesJson, String createdById);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.responsesJson) LIKE LOWER(CONCAT('%', :responsesJson, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByResponsesJsonAndTenantName(String responsesJson, String tenantName);

        @Query("SELECT e FROM Chat e WHERE LOWER(e.responsesJson) LIKE LOWER(CONCAT('%', :responsesJson, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Chat> findByResponsesJsonAndTenantId(String responsesJson, String tenantId);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.responses) LIKE LOWER(CONCAT('%', :responses, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByResponsesAndCreatedById(String responses, String createdById);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.responses) LIKE LOWER(CONCAT('%', :responses, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByResponsesAndTenantName(String responses, String tenantName);

        @Query("SELECT e FROM Chat e WHERE LOWER(e.responses) LIKE LOWER(CONCAT('%', :responses, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Chat> findByResponsesAndTenantId(String responses, String tenantId);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.state) LIKE LOWER(CONCAT('%', :state, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByStateAndCreatedById(String state, String createdById);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.state) LIKE LOWER(CONCAT('%', :state, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByStateAndTenantName(String state, String tenantName);

        @Query("SELECT e FROM Chat e WHERE LOWER(e.state) LIKE LOWER(CONCAT('%', :state, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Chat> findByStateAndTenantId(String state, String tenantId);
        @Query("""
        SELECT e FROM Chat e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Chat> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
        SELECT e FROM Chat e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Chat> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);


        @Query("SELECT e FROM Chat e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM Chat e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Chat> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByAccountIdAndCreatedById(String account, String createdById);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByAccountIdAndTenantName(String account, String tenantName);

        @Query("SELECT e FROM Chat e WHERE LOWER(e.account.id) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Chat> findByAccountIdAndTenantId(String account, String tenantId);
        @Query("""
        SELECT e FROM Chat e
        WHERE e.dateTransaction >= :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Chat> findByDateTransactionAndCreatedById(java.time.Instant dateTransaction, String createdById);

         @Query("""
        SELECT e FROM Chat e
        WHERE e.dateTransaction >= :#{#dateTransaction.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Chat> findByDateTransactionAndTenantId(java.time.Instant dateTransaction, String tenantId);


        @Query("SELECT e FROM Chat e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM Chat e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Chat> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM Chat e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Chat> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM Chat e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Chat> findByTenantIdAndTenantId(String tenant, String tenantId);




}
