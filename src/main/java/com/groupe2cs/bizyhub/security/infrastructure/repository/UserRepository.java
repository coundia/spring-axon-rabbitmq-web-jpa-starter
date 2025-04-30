package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, String> {

	@Query("SELECT e FROM CustomUser e WHERE e.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<CustomUser> findByIdAndCreatedById(String id, String createdById);

	Page<CustomUser> findByCreatedById(String createdById, Pageable pageable);

	Page<CustomUser> findAllByTenantId(String tenantId, Pageable pageable);

	@Query("SELECT e FROM CustomUser e WHERE e.username = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<CustomUser> findByUsernameAndCreatedById(String username, String createdById);

	@Query("SELECT e FROM CustomUser e WHERE e.username = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<CustomUser> findByUsernameAndTenantName(String username, String tenantName);

	@Query("SELECT e FROM CustomUser e WHERE e.username = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<CustomUser> findByUsernameAndTenantId(String username, String tenantId);

	@Query("SELECT e FROM CustomUser e WHERE e.password = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<CustomUser> findByPasswordAndCreatedById(String password, String createdById);

	@Query("SELECT e FROM CustomUser e WHERE e.password = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<CustomUser> findByPasswordAndTenantName(String password, String tenantName);

	@Query("SELECT e FROM CustomUser e WHERE e.password = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<CustomUser> findByPasswordAndTenantId(String password, String tenantId);

	@Query("SELECT e FROM CustomUser e WHERE e.createdBy.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<CustomUser> findByCreatedByIdAndCreatedById(String createdBy, String createdById);

	@Query("SELECT e FROM CustomUser e WHERE e.createdBy.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<CustomUser> findByCreatedByIdAndTenantName(String createdBy, String tenantName);

	@Query("SELECT e FROM CustomUser e WHERE e.createdBy.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<CustomUser> findByCreatedByIdAndTenantId(String createdBy, String tenantId);

	@Query("SELECT e FROM CustomUser e WHERE e.tenant.id = ?1 and e.createdBy.id = ?2 ORDER BY e.createdAtAudit DESC")
	List<CustomUser> findByTenantIdAndCreatedById(String tenant, String createdById);

	@Query("SELECT e FROM CustomUser e WHERE e.tenant.id = ?1 and e.tenant.name = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<CustomUser> findByTenantIdAndTenantName(String tenant, String tenantName);

	@Query("SELECT e FROM CustomUser e WHERE e.tenant.id = ?1 and e.tenant.id = ?2 ORDER BY e.createdAtAudit DESC limit 1 ")
	Optional<CustomUser> findByTenantIdAndTenantId(String tenant, String tenantId);


}
