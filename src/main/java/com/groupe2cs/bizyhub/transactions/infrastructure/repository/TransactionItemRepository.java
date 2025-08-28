package com.groupe2cs.bizyhub.transactions.infrastructure.repository;

	import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionItem;
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
public interface TransactionItemRepository extends JpaRepository<TransactionItem, String> {

	@Query("SELECT e FROM TransactionItem e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<TransactionItem> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM TransactionItem e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<TransactionItem> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM TransactionItem e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<TransactionItem> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM TransactionItem e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<TransactionItem> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.transaction) LIKE LOWER(CONCAT('%', :transaction, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByTransactionAndCreatedById(String transaction, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.transaction) LIKE LOWER(CONCAT('%', :transaction, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByTransactionAndTenantName(String transaction, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.transaction) LIKE LOWER(CONCAT('%', :transaction, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByTransactionAndTenantId(String transaction, String tenantId);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.product) LIKE LOWER(CONCAT('%', :product, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByProductAndCreatedById(String product, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.product) LIKE LOWER(CONCAT('%', :product, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByProductAndTenantName(String product, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.product) LIKE LOWER(CONCAT('%', :product, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByProductAndTenantId(String product, String tenantId);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.label) LIKE LOWER(CONCAT('%', :label, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByLabelAndCreatedById(String label, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.label) LIKE LOWER(CONCAT('%', :label, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByLabelAndTenantName(String label, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.label) LIKE LOWER(CONCAT('%', :label, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByLabelAndTenantId(String label, String tenantId);
        @Query("SELECT e FROM TransactionItem e WHERE e.quantity = :quantity AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByQuantityAndCreatedById(Integer quantity, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE e.quantity = :quantity AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByQuantityAndTenantName(Integer quantity, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE e.quantity = :quantity AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByQuantityAndTenantId(Integer quantity, String tenantId);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.unit) LIKE LOWER(CONCAT('%', :unit, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByUnitAndCreatedById(String unit, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.unit) LIKE LOWER(CONCAT('%', :unit, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByUnitAndTenantName(String unit, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.unit) LIKE LOWER(CONCAT('%', :unit, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByUnitAndTenantId(String unit, String tenantId);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByAccountAndCreatedById(String account, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByAccountAndTenantName(String account, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByAccountAndTenantId(String account, String tenantId);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByRemoteIdAndCreatedById(String remoteId, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByRemoteIdAndTenantName(String remoteId, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByRemoteIdAndTenantId(String remoteId, String tenantId);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByLocalIdAndCreatedById(String localId, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByLocalIdAndTenantName(String localId, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByLocalIdAndTenantId(String localId, String tenantId);
         @Query("""
        SELECT e FROM TransactionItem e
        WHERE e.syncAt >= :#{#syncAt.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
        AND e.tenant.id = :tenantId
        ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
        """)
         List<TransactionItem> findBySyncAtAndTenantId(java.time.Instant syncAt, String tenantId);



        @Query("SELECT e FROM TransactionItem e WHERE e.unitPrice = :unitPrice AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByUnitPriceAndCreatedById(Double unitPrice, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE e.unitPrice = :unitPrice AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByUnitPriceAndTenantName(Double unitPrice, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE e.unitPrice = :unitPrice AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByUnitPriceAndTenantId(Double unitPrice, String tenantId);
        @Query("SELECT e FROM TransactionItem e WHERE e.total = :total AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByTotalAndCreatedById(Double total, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE e.total = :total AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByTotalAndTenantName(Double total, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE e.total = :total AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByTotalAndTenantId(Double total, String tenantId);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByNotesAndCreatedById(String notes, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByNotesAndTenantName(String notes, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByNotesAndTenantId(String notes, String tenantId);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<TransactionItem> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM TransactionItem e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<TransactionItem> findByTenantIdAndTenantId(String tenant, String tenantId);


	@Query("""
        SELECT e FROM TransactionItem  e
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
         List<TransactionItem> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

         @Query("""
            select case when count(e)>0 then true else false end
                 from TransactionItem  e
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
