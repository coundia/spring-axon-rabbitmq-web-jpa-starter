package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

	@Query("SELECT t FROM Role t ")
	Page<Role> findAll(Pageable pageable);

	@Query("SELECT t FROM Role t WHERE t.id = :id")
	Optional<Role> findById(Role id);

	@Query("SELECT t FROM Role t WHERE t.name = :name")
	Optional<Role> findByName(String name);

}
