package com.groupe2cs.bizyhub.stock.infrastructure.repository;

	import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockLevel;
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
public interface StockLevelRepository extends JpaRepository<StockLevel, String> {

	@Query("SELECT e FROM StockLevel e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<StockLevel> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM StockLevel e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<StockLevel> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM StockLevel e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<StockLevel> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM StockLevel e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<StockLevel> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockLevel> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByLocalIdAndCreatedById(String localId, String createdById);
        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByLocalIdAndTenantName(String localId, String tenantName);

        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockLevel> findByLocalIdAndTenantId(String localId, String tenantId);
        @Query("SELECT e FROM StockLevel e WHERE e.stockOnHand = :stockOnHand AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByStockOnHandAndCreatedById(Integer stockOnHand, String createdById);
        @Query("SELECT e FROM StockLevel e WHERE e.stockOnHand = :stockOnHand AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByStockOnHandAndTenantName(Integer stockOnHand, String tenantName);

        @Query("SELECT e FROM StockLevel e WHERE e.stockOnHand = :stockOnHand AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockLevel> findByStockOnHandAndTenantId(Integer stockOnHand, String tenantId);
        @Query("SELECT e FROM StockLevel e WHERE e.stockAllocated = :stockAllocated AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByStockAllocatedAndCreatedById(Integer stockAllocated, String createdById);
        @Query("SELECT e FROM StockLevel e WHERE e.stockAllocated = :stockAllocated AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByStockAllocatedAndTenantName(Integer stockAllocated, String tenantName);

        @Query("SELECT e FROM StockLevel e WHERE e.stockAllocated = :stockAllocated AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockLevel> findByStockAllocatedAndTenantId(Integer stockAllocated, String tenantId);
        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.productVariant) LIKE LOWER(CONCAT('%', :productVariant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByProductVariantAndCreatedById(String productVariant, String createdById);
        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.productVariant) LIKE LOWER(CONCAT('%', :productVariant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByProductVariantAndTenantName(String productVariant, String tenantName);

        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.productVariant) LIKE LOWER(CONCAT('%', :productVariant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockLevel> findByProductVariantAndTenantId(String productVariant, String tenantId);
        @Query("""
        SELECT e FROM StockLevel e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<StockLevel> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
        SELECT e FROM StockLevel e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<StockLevel> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);


        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.company) LIKE LOWER(CONCAT('%', :company, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByCompanyAndCreatedById(String company, String createdById);
        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.company) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByCompanyAndTenantName(String company, String tenantName);

        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.company) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockLevel> findByCompanyAndTenantId(String company, String tenantId);
        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockLevel> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockLevel> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM StockLevel e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockLevel> findByTenantIdAndTenantId(String tenant, String tenantId);




}
