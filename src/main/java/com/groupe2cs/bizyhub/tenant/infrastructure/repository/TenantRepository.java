package com.groupe2cs.bizyhub.tenant.infrastructure.repository;

import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, String> {

	Page<Tenant> findAll(Pageable pageable);

	Optional<Tenant> findById(String id);

	Optional<Tenant> findByIdAndCreatedById(String id, String createdById);

	Page<Tenant> findByCreatedById(Pageable pageable, String createdById);


	Optional<Tenant> findByNameAndCreatedById(String name, String createdById);

	Optional<Tenant> findByName(String name);

	List<Tenant> findByDescriptionAndCreatedById(String description, String createdById);

	List<Tenant> findByDomainAndCreatedById(String domain, String createdById);

	List<Tenant> findByLanguageAndCreatedById(String language, String createdById);

	List<Tenant> findByActiveAndCreatedById(Boolean active, String createdById);

	List<Tenant> findByCreatedByIdAndCreatedById(String createdBy, String createdById);


}
