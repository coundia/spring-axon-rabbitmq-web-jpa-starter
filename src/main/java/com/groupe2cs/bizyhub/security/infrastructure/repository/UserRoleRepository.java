package com.groupe2cs.bizyhub.security.infrastructure.repository;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {

	@Query("SELECT t FROM UserRole t ")
	Page<UserRole> findAll(Pageable pageable);

	@Query("SELECT t FROM UserRole t WHERE t.id = :id")
	Optional<UserRole> findById(UserRole id);

	@Query("SELECT t FROM UserRole t WHERE t.user = :user")
	List<UserRole> findByUser(String user);

	@Query("SELECT t FROM UserRole t WHERE t.role = :role")
	List<UserRole> findByRole(String role);

	Optional<UserRole> findByUserAndRole(User user, Role role);
}
