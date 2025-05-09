package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

	@Query("SELECT e FROM Role e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Role> findByIdAndCreatedById(String id, String createdById);

	Page<Role> findByCreatedById(String createdById, Pageable pageable);

	Page<Role> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM Role e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Role> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Role e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Role> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Role e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Role> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Role e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Role> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Role e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Role> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Role e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Role> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Role e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<Role> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Role e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Role> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Role e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<Role> findByTenantIdAndTenantId(String tenant, String tenantId);


}
