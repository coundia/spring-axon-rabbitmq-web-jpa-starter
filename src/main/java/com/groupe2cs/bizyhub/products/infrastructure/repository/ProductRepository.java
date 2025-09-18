package com.groupe2cs.bizyhub.products.infrastructure.repository;

	import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
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
public interface ProductRepository extends JpaRepository<Product, String> {

	@Query("SELECT e FROM Product e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Product> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Product e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Product> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM Product e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Product> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Product e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Product> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM Product e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByLocalIdAndCreatedById(String localId, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByLocalIdAndTenantName(String localId, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByLocalIdAndTenantId(String localId, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByCodeAndCreatedById(String code, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByCodeAndTenantName(String code, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.code) LIKE LOWER(CONCAT('%', :code, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByCodeAndTenantId(String code, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByNameAndCreatedById(String name, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByNameAndTenantName(String name, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByNameAndTenantId(String name, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByDescriptionAndCreatedById(String description, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByDescriptionAndTenantName(String description, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByDescriptionAndTenantId(String description, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByStatusAndCreatedById(String status, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByStatusAndTenantName(String status, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByStatusAndTenantId(String status, String tenantId);
        @Query("SELECT e FROM Product e WHERE e.isPublic = :isPublic AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByIsPublicAndCreatedById(Boolean isPublic, String createdById);
        @Query("SELECT e FROM Product e WHERE e.isPublic = :isPublic AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByIsPublicAndTenantName(Boolean isPublic, String tenantName);

        @Query("SELECT e FROM Product e WHERE e.isPublic = :isPublic AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByIsPublicAndTenantId(Boolean isPublic, String tenantId);
        @Query("SELECT e FROM Product e WHERE e.hasSold = :hasSold AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByHasSoldAndCreatedById(Boolean hasSold, String createdById);
        @Query("SELECT e FROM Product e WHERE e.hasSold = :hasSold AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByHasSoldAndTenantName(Boolean hasSold, String tenantName);

        @Query("SELECT e FROM Product e WHERE e.hasSold = :hasSold AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByHasSoldAndTenantId(Boolean hasSold, String tenantId);
        @Query("SELECT e FROM Product e WHERE e.hasPrice = :hasPrice AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByHasPriceAndCreatedById(Boolean hasPrice, String createdById);
        @Query("SELECT e FROM Product e WHERE e.hasPrice = :hasPrice AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByHasPriceAndTenantName(Boolean hasPrice, String tenantName);

        @Query("SELECT e FROM Product e WHERE e.hasPrice = :hasPrice AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByHasPriceAndTenantId(Boolean hasPrice, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.level) LIKE LOWER(CONCAT('%', :level, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByLevelAndCreatedById(String level, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.level) LIKE LOWER(CONCAT('%', :level, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByLevelAndTenantName(String level, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.level) LIKE LOWER(CONCAT('%', :level, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByLevelAndTenantId(String level, String tenantId);
        @Query("SELECT e FROM Product e WHERE e.quantity = :quantity AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByQuantityAndCreatedById(Integer quantity, String createdById);
        @Query("SELECT e FROM Product e WHERE e.quantity = :quantity AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByQuantityAndTenantName(Integer quantity, String tenantName);

        @Query("SELECT e FROM Product e WHERE e.quantity = :quantity AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByQuantityAndTenantId(Integer quantity, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.barcode) LIKE LOWER(CONCAT('%', :barcode, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByBarcodeAndCreatedById(String barcode, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.barcode) LIKE LOWER(CONCAT('%', :barcode, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByBarcodeAndTenantName(String barcode, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.barcode) LIKE LOWER(CONCAT('%', :barcode, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByBarcodeAndTenantId(String barcode, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.company) LIKE LOWER(CONCAT('%', :company, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByCompanyAndCreatedById(String company, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.company) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByCompanyAndTenantName(String company, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.company) LIKE LOWER(CONCAT('%', :company, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByCompanyAndTenantId(String company, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.unit) LIKE LOWER(CONCAT('%', :unit, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByUnitAndCreatedById(String unit, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.unit) LIKE LOWER(CONCAT('%', :unit, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByUnitAndTenantName(String unit, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.unit) LIKE LOWER(CONCAT('%', :unit, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByUnitAndTenantId(String unit, String tenantId);
         @Query("""
        SELECT e FROM Product e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<Product> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);



        @Query("SELECT e FROM Product e WHERE LOWER(e.category) LIKE LOWER(CONCAT('%', :category, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByCategoryAndCreatedById(String category, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.category) LIKE LOWER(CONCAT('%', :category, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByCategoryAndTenantName(String category, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.category) LIKE LOWER(CONCAT('%', :category, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByCategoryAndTenantId(String category, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByAccountAndCreatedById(String account, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByAccountAndTenantName(String account, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByAccountAndTenantId(String account, String tenantId);
        @Query("SELECT e FROM Product e WHERE e.defaultPrice = :defaultPrice AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByDefaultPriceAndCreatedById(Double defaultPrice, String createdById);
        @Query("SELECT e FROM Product e WHERE e.defaultPrice = :defaultPrice AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByDefaultPriceAndTenantName(Double defaultPrice, String tenantName);

        @Query("SELECT e FROM Product e WHERE e.defaultPrice = :defaultPrice AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByDefaultPriceAndTenantId(Double defaultPrice, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.statuses) LIKE LOWER(CONCAT('%', :statuses, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByStatusesAndCreatedById(String statuses, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.statuses) LIKE LOWER(CONCAT('%', :statuses, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByStatusesAndTenantName(String statuses, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.statuses) LIKE LOWER(CONCAT('%', :statuses, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByStatusesAndTenantId(String statuses, String tenantId);
        @Query("SELECT e FROM Product e WHERE e.purchasePrice = :purchasePrice AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByPurchasePriceAndCreatedById(Double purchasePrice, String createdById);
        @Query("SELECT e FROM Product e WHERE e.purchasePrice = :purchasePrice AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByPurchasePriceAndTenantName(Double purchasePrice, String tenantName);

        @Query("SELECT e FROM Product e WHERE e.purchasePrice = :purchasePrice AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByPurchasePriceAndTenantId(Double purchasePrice, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM Product e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM Product e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<Product> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM Product e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<Product> findByTenantIdAndTenantId(String tenant, String tenantId);


	@Query("""
        SELECT e FROM Product  e
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
         List<Product> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
            select case when count(e)>0 then true else false end
                 from Product  e
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
