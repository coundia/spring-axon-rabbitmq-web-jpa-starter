package com.groupe2cs.bizyhub.security.infrastructure.repository;

	import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
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
public interface UserRepository extends JpaRepository<User, String> {

	@Query("SELECT e FROM User e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC limit 1 ")
	Optional<User> findByIdAndCreatedById(String id, String createdById);
	@Query("SELECT e FROM User e WHERE e.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<User> findByIdAndTenantId(String id, String tenantId);

	Page<User> findByCreatedById(String createdById, Pageable pageable);
	Page<User> findAllByTenantId(String tenantId, Pageable pageable);


	@Query("SELECT e FROM User e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<User> findByUsernameAndCreatedById(String username, String createdById);


	@Query("SELECT e FROM User e WHERE e.username = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<User> findByUsername(String username);

	@Query("SELECT e FROM User e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<User> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM User e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<User> findByUsernameAndTenantId(String username, String tenantId);

	@Query("SELECT e FROM User e WHERE e.password = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<User> findByPasswordAndCreatedById(String password, String createdById);


	@Query("SELECT e FROM User e WHERE e.password = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<User> findByPassword(String password);

	@Query("SELECT e FROM User e WHERE e.password = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<User> findByPasswordAndTenantName(String password, String tenantName);

	@Query("SELECT e FROM User e WHERE e.password = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<User> findByPasswordAndTenantId(String password, String tenantId);

	@Query("SELECT e FROM User e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<User> findByCreatedByIdAndCreatedById(String createdBy, String createdById);


	@Query("SELECT e FROM User e WHERE e.createdBy.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<User> findByCreatedById(String createdBy);

	@Query("SELECT e FROM User e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<User> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM User e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<User> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM User e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.updatedAtAudit DESC")
	List<User> findByTenantIdAndCreatedById(String tenant, String createdById);


	@Query("SELECT e FROM User e WHERE e.tenant.id = ?1  ORDER BY e.updatedAtAudit DESC ")
	Optional<User> findByTenantId(String tenant);

	@Query("SELECT e FROM User e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<User> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM User e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.updatedAtAudit DESC ")
	List<User> findByTenantIdAndTenantId(String tenant, String tenantId);




}
