package com.groupe2cs.bizyhub.tenant.infrastructure.repository;

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
public interface TenantRepository extends JpaRepository<Tenant, String> {

	@Query("SELECT t FROM Tenant t ")
	Page<Tenant> findAll(Pageable pageable);

	@Query("SELECT t FROM Tenant t WHERE t.id = :id")
	Optional<Tenant> findById(Tenant id);
	@Query("SELECT t FROM Tenant t WHERE t.name = :name")
	Optional<Tenant> findByName(String name);
	@Query("SELECT t FROM Tenant t WHERE t.description = :description")
	List<Tenant> findByDescription(String description);
	@Query("SELECT t FROM Tenant t WHERE t.domain = :domain")
	List<Tenant> findByDomain(String domain);
	@Query("SELECT t FROM Tenant t WHERE t.language = :language")
	List<Tenant> findByLanguage(String language);
	@Query("SELECT t FROM Tenant t WHERE t.active = :active")
	List<Tenant> findByActive(Boolean active);
	@Query("SELECT t FROM Tenant t WHERE t.createdBy = :createdBy")
	List<Tenant> findByCreatedBy(String createdBy);

}
