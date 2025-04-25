package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, String> {

	@Query("SELECT t FROM RolePermission t ")
	Page<RolePermission> findAll(Pageable pageable);

	@Query("SELECT t FROM RolePermission t WHERE t.id = :id")
	Optional<RolePermission> findById(RolePermission id);
	@Query("SELECT t FROM RolePermission t WHERE t.role = :role")
	List<RolePermission> findByRole(String role);
	@Query("SELECT t FROM RolePermission t WHERE t.permission = :permission")
	List<RolePermission> findByPermission(String permission);
	@Query("SELECT t FROM RolePermission t WHERE t.createdBy = :createdBy")
	List<RolePermission> findByCreatedBy(String createdBy);
	@Query("SELECT t FROM RolePermission t WHERE t.tenant = :tenant")
	List<RolePermission> findByTenant(String tenant);

}
