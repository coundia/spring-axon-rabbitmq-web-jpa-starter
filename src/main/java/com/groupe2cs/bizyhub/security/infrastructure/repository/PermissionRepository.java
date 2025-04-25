package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

	@Query("SELECT t FROM Permission t ")
	Page<Permission> findAll(Pageable pageable);

	@Query("SELECT t FROM Permission t WHERE t.id = :id")
	Optional<Permission> findById(Permission id);
	@Query("SELECT t FROM Permission t WHERE t.name = :name")
	Optional<Permission> findByName(String name);
	@Query("SELECT t FROM Permission t WHERE t.createdBy = :createdBy")
	List<Permission> findByCreatedBy(String createdBy);
	@Query("SELECT t FROM Permission t WHERE t.tenant = :tenant")
	List<Permission> findByTenant(String tenant);

	Optional<Permission> findByCreatedByAndTenant(User createdBy, Tenant tenant);
}
