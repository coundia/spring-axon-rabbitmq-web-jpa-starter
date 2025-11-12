package com.groupe2cs.bizyhub.categories.infrastructure.repository;

import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

	@Query("SELECT e FROM Category e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByLocalIdAndCreatedById(String localId, String createdById);

	@Query("SELECT e FROM Category e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByLocalIdAndTenantName(String localId, String tenantName);

	@Query("SELECT e FROM Category e WHERE LOWER(e.localId) LIKE LOWER(CONCAT('%', :localId, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByLocalIdAndTenantId(String localId, String tenantId);

	@Query("SELECT e FROM Category e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByAccountAndCreatedById(String account, String createdById);

	@Query("SELECT e FROM Category e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByAccountAndTenantName(String account, String tenantName);

	@Query("SELECT e FROM Category e WHERE LOWER(e.account) LIKE LOWER(CONCAT('%', :account, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByAccountAndTenantId(String account, String tenantId);

	@Query("SELECT e FROM Category e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByStatusAndCreatedById(String status, String createdById);

	@Query("SELECT e FROM Category e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByStatusAndTenantName(String status, String tenantName);

	@Query("SELECT e FROM Category e WHERE LOWER(e.status) LIKE LOWER(CONCAT('%', :status, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByStatusAndTenantId(String status, String tenantId);

	@Query("SELECT e FROM Category e WHERE e.isPublic = :isPublic AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByIsPublicAndCreatedById(Boolean isPublic, String createdById);

	@Query("SELECT e FROM Category e WHERE e.isPublic = :isPublic AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByIsPublicAndTenantName(Boolean isPublic, String tenantName);

	@Query("SELECT e FROM Category e WHERE e.isPublic = :isPublic AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
	List<Category> findByIsPublicAndTenantId(Boolean isPublic, String tenantId);

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


	@Query("""
			SELECT e FROM Category  e
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
	List<Category> findBySyncAtAndCreatedById(java.time.Instant syncAt, String createdById);

	@Query("""
			select case when count(e)>0 then true else false end
			     from Category  e
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
	boolean isOwner(@Param("id") String id, @Param("userId") String userId);


	@Query("SELECT e FROM Category e WHERE e.tenant.id = :tenantId AND e.isPublic = true ORDER BY e.updatedAtAudit DESC, e.createdAtAudit DESC")
	Page<Category> findPublicByTenantId(String tenantId, Pageable pageable);


}
