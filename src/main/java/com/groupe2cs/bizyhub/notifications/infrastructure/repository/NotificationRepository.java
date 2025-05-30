package com.groupe2cs.bizyhub.notifications.infrastructure.repository;

import com.groupe2cs.bizyhub.notifications.infrastructure.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {

	@Query("SELECT e FROM Notification e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<Notification> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM Notification e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<Notification> findByIdAndTenantId(String id, String tenantId);

	@Query("SELECT e FROM Notification e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Notification> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM Notification e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<Notification> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.deviceToken) LIKE LOWER(CONCAT('%', :deviceToken, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByDeviceTokenAndCreatedById(String deviceToken, String createdById);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.deviceToken) LIKE LOWER(CONCAT('%', :deviceToken, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByDeviceTokenAndTenantName(String deviceToken, String tenantName);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.deviceToken) LIKE LOWER(CONCAT('%', :deviceToken, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByDeviceTokenAndTenantId(String deviceToken, String tenantId);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.title) LIKE LOWER(CONCAT('%', :title, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByTitleAndCreatedById(String title, String createdById);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.title) LIKE LOWER(CONCAT('%', :title, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByTitleAndTenantName(String title, String tenantName);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.title) LIKE LOWER(CONCAT('%', :title, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByTitleAndTenantId(String title, String tenantId);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.message) LIKE LOWER(CONCAT('%', :message, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByMessageAndCreatedById(String message, String createdById);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.message) LIKE LOWER(CONCAT('%', :message, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByMessageAndTenantName(String message, String tenantName);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.message) LIKE LOWER(CONCAT('%', :message, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByMessageAndTenantId(String message, String tenantId);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByStatusAndCreatedById(String status, String createdById);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByStatusAndTenantName(String status, String tenantName);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByStatusAndTenantId(String status, String tenantId);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.reserved) LIKE LOWER(CONCAT('%', :reserved, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByReservedAndCreatedById(String reserved, String createdById);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.reserved) LIKE LOWER(CONCAT('%', :reserved, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByReservedAndTenantName(String reserved, String tenantName);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.reserved) LIKE LOWER(CONCAT('%', :reserved, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByReservedAndTenantId(String reserved, String tenantId);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.errorMessage) LIKE LOWER(CONCAT('%', :errorMessage, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByErrorMessageAndCreatedById(String errorMessage, String createdById);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.errorMessage) LIKE LOWER(CONCAT('%', :errorMessage, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByErrorMessageAndTenantName(String errorMessage, String tenantName);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.errorMessage) LIKE LOWER(CONCAT('%', :errorMessage, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByErrorMessageAndTenantId(String errorMessage, String tenantId);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Notification e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Notification> findByTenantIdAndTenantId(String tenant, String tenantId);


}
