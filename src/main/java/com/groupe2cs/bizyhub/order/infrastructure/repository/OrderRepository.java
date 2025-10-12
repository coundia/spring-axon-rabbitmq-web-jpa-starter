package com.groupe2cs.bizyhub.order.infrastructure.repository;

import com.groupe2cs.bizyhub.order.infrastructure.entity.Order;
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
public interface OrderRepository extends JpaRepository<Order, String> {

	@Query("SELECT e FROM Order e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Order> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM Order e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Order> findByIdAndTenantId(String id, String tenantId);

	@Query("SELECT e FROM Order e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Order> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Order e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Order> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Order e WHERE LOWER(e.productId) LIKE LOWER(CONCAT('%', :productId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByProductIdAndCreatedById(String productId, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.productId) LIKE LOWER(CONCAT('%', :productId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByProductIdAndTenantName(String productId, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.productId) LIKE LOWER(CONCAT('%', :productId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByProductIdAndTenantId(String productId, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.userId) LIKE LOWER(CONCAT('%', :userId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByUserIdAndCreatedById(String userId, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.userId) LIKE LOWER(CONCAT('%', :userId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByUserIdAndTenantName(String userId, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.userId) LIKE LOWER(CONCAT('%', :userId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByUserIdAndTenantId(String userId, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.identifiant) LIKE LOWER(CONCAT('%', :identifiant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByIdentifiantAndCreatedById(String identifiant, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.identifiant) LIKE LOWER(CONCAT('%', :identifiant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByIdentifiantAndTenantName(String identifiant, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.identifiant) LIKE LOWER(CONCAT('%', :identifiant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByIdentifiantAndTenantId(String identifiant, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.telephone) LIKE LOWER(CONCAT('%', :telephone, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByTelephoneAndCreatedById(String telephone, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.telephone) LIKE LOWER(CONCAT('%', :telephone, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByTelephoneAndTenantName(String telephone, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.telephone) LIKE LOWER(CONCAT('%', :telephone, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByTelephoneAndTenantId(String telephone, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.mail) LIKE LOWER(CONCAT('%', :mail, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByMailAndCreatedById(String mail, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.mail) LIKE LOWER(CONCAT('%', :mail, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByMailAndTenantName(String mail, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.mail) LIKE LOWER(CONCAT('%', :mail, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByMailAndTenantId(String mail, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.ville) LIKE LOWER(CONCAT('%', :ville, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByVilleAndCreatedById(String ville, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.ville) LIKE LOWER(CONCAT('%', :ville, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByVilleAndTenantName(String ville, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.ville) LIKE LOWER(CONCAT('%', :ville, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByVilleAndTenantId(String ville, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByRemoteIdAndCreatedById(String remoteId, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByRemoteIdAndTenantName(String remoteId, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.remoteId) LIKE LOWER(CONCAT('%', :remoteId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByRemoteIdAndTenantId(String remoteId, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByLocalIdAndCreatedById(String localId, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByLocalIdAndTenantName(String localId, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByLocalIdAndTenantId(String localId, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByStatusAndCreatedById(String status, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByStatusAndTenantName(String status, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByStatusAndTenantId(String status, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.buyerName) LIKE LOWER(CONCAT('%', :buyerName, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByBuyerNameAndCreatedById(String buyerName, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.buyerName) LIKE LOWER(CONCAT('%', :buyerName, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByBuyerNameAndTenantName(String buyerName, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.buyerName) LIKE LOWER(CONCAT('%', :buyerName, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByBuyerNameAndTenantId(String buyerName, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.address) LIKE LOWER(CONCAT('%', :address, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByAddressAndCreatedById(String address, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.address) LIKE LOWER(CONCAT('%', :address, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByAddressAndTenantName(String address, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.address) LIKE LOWER(CONCAT('%', :address, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByAddressAndTenantId(String address, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByNotesAndCreatedById(String notes, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByNotesAndTenantName(String notes, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.notes) LIKE LOWER(CONCAT('%', :notes, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByNotesAndTenantId(String notes, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.message) LIKE LOWER(CONCAT('%', :message, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByMessageAndCreatedById(String message, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.message) LIKE LOWER(CONCAT('%', :message, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByMessageAndTenantName(String message, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.message) LIKE LOWER(CONCAT('%', :message, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByMessageAndTenantId(String message, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.typeOrder) LIKE LOWER(CONCAT('%', :typeOrder, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByTypeOrderAndCreatedById(String typeOrder, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.typeOrder) LIKE LOWER(CONCAT('%', :typeOrder, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByTypeOrderAndTenantName(String typeOrder, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.typeOrder) LIKE LOWER(CONCAT('%', :typeOrder, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByTypeOrderAndTenantId(String typeOrder, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.paymentMethod) LIKE LOWER(CONCAT('%', :paymentMethod, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByPaymentMethodAndCreatedById(String paymentMethod, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.paymentMethod) LIKE LOWER(CONCAT('%', :paymentMethod, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByPaymentMethodAndTenantName(String paymentMethod, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.paymentMethod) LIKE LOWER(CONCAT('%', :paymentMethod, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByPaymentMethodAndTenantId(String paymentMethod, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.deliveryMethod) LIKE LOWER(CONCAT('%', :deliveryMethod, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByDeliveryMethodAndCreatedById(String deliveryMethod, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.deliveryMethod) LIKE LOWER(CONCAT('%', :deliveryMethod, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByDeliveryMethodAndTenantName(String deliveryMethod, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.deliveryMethod) LIKE LOWER(CONCAT('%', :deliveryMethod, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByDeliveryMethodAndTenantId(String deliveryMethod, String tenantId);

	@Query("SELECT e FROM Order e WHERE e.amountCents = :amountCents AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByAmountCentsAndCreatedById(Double amountCents, String createdById);

	@Query("SELECT e FROM Order e WHERE e.amountCents = :amountCents AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByAmountCentsAndTenantName(Double amountCents, String tenantName);

	@Query("SELECT e FROM Order e WHERE e.amountCents = :amountCents AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByAmountCentsAndTenantId(Double amountCents, String tenantId);

	@Query("SELECT e FROM Order e WHERE e.quantity = :quantity AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByQuantityAndCreatedById(Integer quantity, String createdById);

	@Query("SELECT e FROM Order e WHERE e.quantity = :quantity AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByQuantityAndTenantName(Integer quantity, String tenantName);

	@Query("SELECT e FROM Order e WHERE e.quantity = :quantity AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByQuantityAndTenantId(Integer quantity, String tenantId);

	@Query("""
			SELECT e FROM Order e
			WHERE e.dateCommand >= :#{#dateCommand.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			AND e.createdBy.id = :createdById
			ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
			""")
	List<Order> findByDateCommandAndCreatedById(java.time.Instant dateCommand, String createdById);

	@Query("""
			SELECT e FROM Order e
			WHERE e.dateCommand >= :#{#dateCommand.atZone(T(java.time.ZoneOffset).UTC).toLocalDate().atStartOfDay(T(java.time.ZoneOffset).UTC).toInstant()}
			AND e.tenant.id = :tenantId
			ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC
			""")
	List<Order> findByDateCommandAndTenantId(java.time.Instant dateCommand, String tenantId);


	@Query("SELECT e FROM Order e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Order e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Order e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Order e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Order> findByTenantIdAndTenantId(String tenant, String tenantId);


}
