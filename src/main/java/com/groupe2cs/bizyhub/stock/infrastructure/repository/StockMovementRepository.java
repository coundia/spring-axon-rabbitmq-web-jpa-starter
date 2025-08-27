package com.groupe2cs.bizyhub.stock.infrastructure.repository;

	import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockMovement;
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
public interface StockMovementRepository extends JpaRepository<StockMovement, String> {

	@Query("SELECT e FROM StockMovement e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<StockMovement> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM StockMovement e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<StockMovement> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM StockMovement e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<StockMovement> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM StockMovement e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<StockMovement> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.typeStockMovement) LIKE LOWER(CONCAT('%', :typeStockMovement, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByTypeStockMovementAndCreatedById(String typeStockMovement, String createdById);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.typeStockMovement) LIKE LOWER(CONCAT('%', :typeStockMovement, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByTypeStockMovementAndTenantName(String typeStockMovement, String tenantName);

        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.typeStockMovement) LIKE LOWER(CONCAT('%', :typeStockMovement, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockMovement> findByTypeStockMovementAndTenantId(String typeStockMovement, String tenantId);
        @Query("SELECT e FROM StockMovement e WHERE e.quantity = :quantity AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByQuantityAndCreatedById(Integer quantity, String createdById);
        @Query("SELECT e FROM StockMovement e WHERE e.quantity = :quantity AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByQuantityAndTenantName(Integer quantity, String tenantName);

        @Query("SELECT e FROM StockMovement e WHERE e.quantity = :quantity AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockMovement> findByQuantityAndTenantId(Integer quantity, String tenantId);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockMovement> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByLocalIdAndCreatedById(String localId, String createdById);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByLocalIdAndTenantName(String localId, String tenantName);

        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockMovement> findByLocalIdAndTenantId(String localId, String tenantId);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.company) LIKE LOWER(CONCAT('%', :company, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByCompanyAndCreatedById(String company, String createdById);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.company) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByCompanyAndTenantName(String company, String tenantName);

        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.company) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockMovement> findByCompanyAndTenantId(String company, String tenantId);
        @Query("""
        SELECT e FROM StockMovement e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.createdBy.id = :createdById
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<StockMovement> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
        SELECT e FROM StockMovement e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<StockMovement> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);


        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.productVariant) LIKE LOWER(CONCAT('%', :productVariant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByProductVariantAndCreatedById(String productVariant, String createdById);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.productVariant) LIKE LOWER(CONCAT('%', :productVariant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByProductVariantAndTenantName(String productVariant, String tenantName);

        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.productVariant) LIKE LOWER(CONCAT('%', :productVariant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockMovement> findByProductVariantAndTenantId(String productVariant, String tenantId);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.orderLineId) LIKE LOWER(CONCAT('%', :orderLineId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByOrderLineIdAndCreatedById(String orderLineId, String createdById);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.orderLineId) LIKE LOWER(CONCAT('%', :orderLineId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByOrderLineIdAndTenantName(String orderLineId, String tenantName);

        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.orderLineId) LIKE LOWER(CONCAT('%', :orderLineId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockMovement> findByOrderLineIdAndTenantId(String orderLineId, String tenantId);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.discriminator) LIKE LOWER(CONCAT('%', :discriminator, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByDiscriminatorAndCreatedById(String discriminator, String createdById);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.discriminator) LIKE LOWER(CONCAT('%', :discriminator, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByDiscriminatorAndTenantName(String discriminator, String tenantName);

        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.discriminator) LIKE LOWER(CONCAT('%', :discriminator, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockMovement> findByDiscriminatorAndTenantId(String discriminator, String tenantId);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockMovement> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<StockMovement> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM StockMovement e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<StockMovement> findByTenantIdAndTenantId(String tenant, String tenantId);




}
