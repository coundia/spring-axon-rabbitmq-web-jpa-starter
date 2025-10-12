package com.groupe2cs.bizyhub.fileManager.infrastructure.repository;

import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.FileManager;
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
public interface FileManagerRepository extends JpaRepository<FileManager, String> {

	@Query("SELECT e FROM FileManager e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<FileManager> findByIdAndCreatedById(String id, String createdById);

	@Query("SELECT e FROM FileManager e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<FileManager> findByIdAndTenantId(String id, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<FileManager> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM FileManager e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<FileManager> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByDetailsAndCreatedById(String details, String createdById);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByDetailsAndTenantName(String details, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.details) LIKE LOWER(CONCAT('%', :details, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByDetailsAndTenantId(String details, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.objectId) LIKE LOWER(CONCAT('%', :objectId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByObjectIdAndCreatedById(String objectId, String createdById);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.objectId) LIKE LOWER(CONCAT('%', :objectId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByObjectIdAndTenantName(String objectId, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.objectId) LIKE LOWER(CONCAT('%', :objectId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByObjectIdAndTenantId(String objectId, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.objectName) LIKE LOWER(CONCAT('%', :objectName, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByObjectNameAndCreatedById(String objectName, String createdById);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.objectName) LIKE LOWER(CONCAT('%', :objectName, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByObjectNameAndTenantName(String objectName, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.objectName) LIKE LOWER(CONCAT('%', :objectName, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByObjectNameAndTenantId(String objectName, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.originalName) LIKE LOWER(CONCAT('%', :originalName, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByOriginalNameAndCreatedById(String originalName, String createdById);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.originalName) LIKE LOWER(CONCAT('%', :originalName, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByOriginalNameAndTenantName(String originalName, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.originalName) LIKE LOWER(CONCAT('%', :originalName, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByOriginalNameAndTenantId(String originalName, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.mimeType) LIKE LOWER(CONCAT('%', :mimeType, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByMimeTypeAndCreatedById(String mimeType, String createdById);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.mimeType) LIKE LOWER(CONCAT('%', :mimeType, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByMimeTypeAndTenantName(String mimeType, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.mimeType) LIKE LOWER(CONCAT('%', :mimeType, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByMimeTypeAndTenantId(String mimeType, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE e.size = :size AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findBySizeAndCreatedById(Long size, String createdById);

	@Query("SELECT e FROM FileManager e WHERE e.size = :size AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findBySizeAndTenantName(Long size, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE e.size = :size AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findBySizeAndTenantId(Long size, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.path) LIKE LOWER(CONCAT('%', :path, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByPathAndCreatedById(String path, String createdById);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.path) LIKE LOWER(CONCAT('%', :path, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByPathAndTenantName(String path, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.path) LIKE LOWER(CONCAT('%', :path, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByPathAndTenantId(String path, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.uri) LIKE LOWER(CONCAT('%', :uri, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByUriAndCreatedById(String uri, String createdById);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.uri) LIKE LOWER(CONCAT('%', :uri, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByUriAndTenantName(String uri, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.uri) LIKE LOWER(CONCAT('%', :uri, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByUriAndTenantId(String uri, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE e.isPublic = :isPublic AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByIsPublicAndCreatedById(Boolean isPublic, String createdById);

	@Query("SELECT e FROM FileManager e WHERE e.isPublic = :isPublic AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByIsPublicAndTenantName(Boolean isPublic, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE e.isPublic = :isPublic AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByIsPublicAndTenantId(Boolean isPublic, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM FileManager e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<FileManager> findByTenantIdAndTenantId(String tenant, String tenantId);


}
