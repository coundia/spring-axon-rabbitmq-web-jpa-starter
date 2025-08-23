package com.groupe2cs.bizyhub.categories.infrastructure.repository;

	import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
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
public interface CategoryRepository extends JpaRepository<Category, String> {

	@Query("SELECT e FROM Category e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Category> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Category e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Category> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM Category e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Category> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Category e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Category> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM Category e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByCodeAndCreatedById(String code, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByCodeAndTenantName(String code, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByCodeAndTenantId(String code, String tenantId);
        @Query("SELECT e FROM Category e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByNameAndCreatedById(String name, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByNameAndTenantName(String name, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByNameAndTenantId(String name, String tenantId);
        @Query("SELECT e FROM Category e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM Category e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByDescriptionAndCreatedById(String description, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByDescriptionAndTenantName(String description, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByDescriptionAndTenantId(String description, String tenantId);
        @Query("SELECT e FROM Category e WHERE LOWER(e.typeEntry) LIKE LOWER(CONCAT('%', :typeEntry, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByTypeEntryAndCreatedById(String typeEntry, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.typeEntry) LIKE LOWER(CONCAT('%', :typeEntry, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByTypeEntryAndTenantName(String typeEntry, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.typeEntry) LIKE LOWER(CONCAT('%', :typeEntry, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByTypeEntryAndTenantId(String typeEntry, String tenantId);
        @Query("SELECT e FROM Category e WHERE e.version = :version AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByVersionAndCreatedById(Integer version, String createdById);
        @Query("SELECT e FROM Category e WHERE e.version = :version AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByVersionAndTenantName(Integer version, String tenantName);

        @Query("SELECT e FROM Category e WHERE e.version = :version AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByVersionAndTenantId(Integer version, String tenantId);
        @Query("""
        SELECT e FROM Category e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.syncAt < :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Category> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
        SELECT e FROM Category e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.syncAt < :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().plusDays(1).atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Category> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);


        @Query("SELECT e FROM Category e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM Category e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM Category e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Category> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM Category e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Category> findByTenantIdAndTenantId(String tenant, String tenantId);




}
