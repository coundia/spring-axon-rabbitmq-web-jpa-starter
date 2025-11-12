package com.groupe2cs.bizyhub.message.infrastructure.repository;

	import com.groupe2cs.bizyhub.message.infrastructure.entity.Message;
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
public interface MessageRepository extends JpaRepository<Message, String> {

	@Query("SELECT e FROM Message e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Message> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Message e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Message> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM Message e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Message> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Message e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Message> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM Message e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByCodeAndCreatedById(String code, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByCodeAndTenantName(String code, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByCodeAndTenantId(String code, String tenantId);
        @Query("SELECT e FROM Message e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByEmailAndCreatedById(String email, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByEmailAndTenantName(String email, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :email, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByEmailAndTenantId(String email, String tenantId);
        @Query("SELECT e FROM Message e WHERE LOWER(e.phone) LIKE LOWER(CONCAT('%', :phone, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByPhoneAndCreatedById(String phone, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.phone) LIKE LOWER(CONCAT('%', :phone, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByPhoneAndTenantName(String phone, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.phone) LIKE LOWER(CONCAT('%', :phone, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByPhoneAndTenantId(String phone, String tenantId);
        @Query("SELECT e FROM Message e WHERE LOWER(e.content) LIKE LOWER(CONCAT('%', :content, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByContentAndCreatedById(String content, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.content) LIKE LOWER(CONCAT('%', :content, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByContentAndTenantName(String content, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.content) LIKE LOWER(CONCAT('%', :content, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByContentAndTenantId(String content, String tenantId);
        @Query("SELECT e FROM Message e WHERE LOWER(e.plateforme) LIKE LOWER(CONCAT('%', :plateforme, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByPlateformeAndCreatedById(String plateforme, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.plateforme) LIKE LOWER(CONCAT('%', :plateforme, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByPlateformeAndTenantName(String plateforme, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.plateforme) LIKE LOWER(CONCAT('%', :plateforme, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByPlateformeAndTenantId(String plateforme, String tenantId);
        @Query("SELECT e FROM Message e WHERE LOWER(e.source) LIKE LOWER(CONCAT('%', :source, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findBySourceAndCreatedById(String source, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.source) LIKE LOWER(CONCAT('%', :source, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findBySourceAndTenantName(String source, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.source) LIKE LOWER(CONCAT('%', :source, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findBySourceAndTenantId(String source, String tenantId);
        @Query("SELECT e FROM Message e WHERE LOWER(e.agent) LIKE LOWER(CONCAT('%', :agent, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByAgentAndCreatedById(String agent, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.agent) LIKE LOWER(CONCAT('%', :agent, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByAgentAndTenantName(String agent, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.agent) LIKE LOWER(CONCAT('%', :agent, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByAgentAndTenantId(String agent, String tenantId);
        @Query("SELECT e FROM Message e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByStatusAndCreatedById(String status, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByStatusAndTenantName(String status, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByStatusAndTenantId(String status, String tenantId);
        @Query("SELECT e FROM Message e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByDescriptionAndCreatedById(String description, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByDescriptionAndTenantName(String description, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByDescriptionAndTenantId(String description, String tenantId);
        @Query("SELECT e FROM Message e WHERE e.isActive = :isActive AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByIsActiveAndCreatedById(Boolean isActive, String createdById);
        @Query("SELECT e FROM Message e WHERE e.isActive = :isActive AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByIsActiveAndTenantName(Boolean isActive, String tenantName);

        @Query("SELECT e FROM Message e WHERE e.isActive = :isActive AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByIsActiveAndTenantId(Boolean isActive, String tenantId);
        @Query("SELECT e FROM Message e WHERE e.isDefault = :isDefault AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByIsDefaultAndCreatedById(Boolean isDefault, String createdById);
        @Query("SELECT e FROM Message e WHERE e.isDefault = :isDefault AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByIsDefaultAndTenantName(Boolean isDefault, String tenantName);

        @Query("SELECT e FROM Message e WHERE e.isDefault = :isDefault AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByIsDefaultAndTenantId(Boolean isDefault, String tenantId);
        @Query("SELECT e FROM Message e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM Message e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByLocalIdAndCreatedById(String localId, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByLocalIdAndTenantName(String localId, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByLocalIdAndTenantId(String localId, String tenantId);
        @Query("""
        SELECT e FROM Message e
        WHERE e.depotAt >= :#{#depotAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Message> findByDepotAtAndCreatedById(java.time.Instant depotAt, String createdById);
         @Query("""
        SELECT e FROM Message e
        WHERE e.depotAt >= :#{#depotAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Message> findByDepotAtAndTenantId(java.time.Instant depotAt, String tenantId);



         @Query("""
        SELECT e FROM Message e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Message> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);



        @Query("SELECT e FROM Message e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM Message e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM Message e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Message> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM Message e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Message> findByTenantIdAndTenantId(String tenant, String tenantId);



    @Query("SELECT e FROM Message e WHERE e.tenant.id = :tenantId AND e.isPublic = true ORDER BY e.updatedAtAudit DESC, e.createdAtAudit DESC")
    Page<Message> findPublicByTenantId(String tenantId, Pageable pageable);


}
