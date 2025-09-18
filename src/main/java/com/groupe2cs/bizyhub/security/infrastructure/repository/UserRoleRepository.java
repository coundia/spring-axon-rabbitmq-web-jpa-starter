package com.groupe2cs.bizyhub.security.infrastructure.repository;

	import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
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
public interface UserRoleRepository extends JpaRepository<UserRole, String> {

	@Query("SELECT e FROM UserRole e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC limit 1 ")
	Optional<UserRole> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM UserRole e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	List<UserRole> findByIdAndTenantId(String id, String tenantId);

    @Query("SELECT e FROM UserRole e WHERE e.createdBy.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<UserRole> findByCreatedById(String createdById, Pageable pageable);

	@Query("SELECT e FROM UserRole e WHERE e.tenant.id = ?1 ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC ")
	Page<UserRole> findAllByTenantId(String tenantId, Pageable pageable);

        @Query("SELECT e FROM UserRole e WHERE LOWER(e.user.id) LIKE LOWER(CONCAT('%', :user, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<UserRole> findByUserIdAndCreatedById(String user, String createdById);
        @Query("SELECT e FROM UserRole e WHERE LOWER(e.user.id) LIKE LOWER(CONCAT('%', :user, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<UserRole> findByUserIdAndTenantName(String user, String tenantName);

        @Query("SELECT e FROM UserRole e WHERE LOWER(e.user.id) LIKE LOWER(CONCAT('%', :user, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<UserRole> findByUserIdAndTenantId(String user, String tenantId);
        @Query("SELECT e FROM UserRole e WHERE LOWER(e.role.id) LIKE LOWER(CONCAT('%', :role, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<UserRole> findByRoleIdAndCreatedById(String role, String createdById);
        @Query("SELECT e FROM UserRole e WHERE LOWER(e.role.id) LIKE LOWER(CONCAT('%', :role, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<UserRole> findByRoleIdAndTenantName(String role, String tenantName);

        @Query("SELECT e FROM UserRole e WHERE LOWER(e.role.id) LIKE LOWER(CONCAT('%', :role, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<UserRole> findByRoleIdAndTenantId(String role, String tenantId);
        @Query("SELECT e FROM UserRole e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<UserRole> findByCreatedByIdAndCreatedById(String createdBy, String createdById);
        @Query("SELECT e FROM UserRole e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<UserRole> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

        @Query("SELECT e FROM UserRole e WHERE LOWER(e.createdBy.id) LIKE LOWER(CONCAT('%', :createdBy, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<UserRole> findByCreatedByIdAndTenantId(String createdBy, String tenantId);
        @Query("SELECT e FROM UserRole e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.createdBy.id = :createdById ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<UserRole> findByTenantIdAndCreatedById(String tenant, String createdById);
        @Query("SELECT e FROM UserRole e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.name = :tenantName ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
        List<UserRole> findByTenantIdAndTenantName(String tenant, String tenantName);

        @Query("SELECT e FROM UserRole e WHERE LOWER(e.tenant.id) LIKE LOWER(CONCAT('%', :tenant, '%')) AND e.tenant.id = :tenantId ORDER BY e.updatedAtAudit DESC, e.createdAtAudit  DESC")
       List<UserRole> findByTenantIdAndTenantId(String tenant, String tenantId);





}
