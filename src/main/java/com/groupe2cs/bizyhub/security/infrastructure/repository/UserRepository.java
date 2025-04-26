package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, String> {

	@Query("SELECT t FROM CustomUser t ")
	Page<CustomUser> findAll(Pageable pageable);

	@Query("SELECT t FROM CustomUser t WHERE t.id = :id")
	Optional<CustomUser> findById(CustomUser id);

	@Query("SELECT t FROM CustomUser t WHERE t.username = :username")
	Optional<CustomUser> findByUsername(String username);

	@Query("SELECT t FROM CustomUser t WHERE t.password = :password")
	List<CustomUser> findByPassword(String password);

	@Query("SELECT t FROM CustomUser t WHERE t.createdBy = :createdBy")
	List<CustomUser> findByCreatedBy(String createdBy);

	@Query("SELECT t FROM CustomUser t WHERE t.tenant = :tenant")
	List<CustomUser> findByTenant(String tenant);

	Optional<CustomUser> findByCreatedByAndTenant(CustomUser createdBy, Tenant tenant);
}
