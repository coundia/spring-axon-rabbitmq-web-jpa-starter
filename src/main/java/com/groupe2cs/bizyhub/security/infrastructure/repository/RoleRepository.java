package com.groupe2cs.bizyhub.security.infrastructure.repository;

	import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
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
public interface RoleRepository extends JpaRepository<Role, String> {

	@Query("SELECT e FROM Role e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<Role> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM Role e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Role> findByIdAndTenantId(String id, String tenantId);

	Page<Role> findByCreatedById(String createdById, Pageable pageable);
	Page<Role> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM Role e WHERE e.name = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Role> findByNameAndCreatedById(String name, String createdById);

	@Query("SELECT e FROM Role e WHERE e.name = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Role> findByName(String name);

	@Query("SELECT e FROM Role e WHERE e.name = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Role> findByNameAndTenantName(String name, String tenantName);

	@Query("SELECT e FROM Role e WHERE e.name = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Role> findByNameAndTenantId(String name, String tenantId);

	@Query("SELECT e FROM Role e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Role> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM Role e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Role> findByCreatedById(String createdBy);

	@Query("SELECT e FROM Role e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Role> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM Role e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Role> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM Role e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<Role> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM Role e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<Role> findByTenantId(String tenant);

	@Query("SELECT e FROM Role e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Role> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM Role e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<Role> findByTenantIdAndTenantId(String tenant, String tenantId);




}
