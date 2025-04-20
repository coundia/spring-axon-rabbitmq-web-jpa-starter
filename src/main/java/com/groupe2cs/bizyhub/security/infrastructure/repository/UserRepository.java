package com.groupe2cs.bizyhub.security.infrastructure.repository;

	import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query("SELECT t FROM User t ")
	Page<User> findAll(Pageable pageable);

	@Query("SELECT t FROM User t WHERE t.id = :id")
	Optional<User> findById(User id);
	@Query("SELECT t FROM User t WHERE t.username = :username")
	Optional<User> findByUsername(String username);
	@Query("SELECT t FROM User t WHERE t.password = :password")
	List<User> findByPassword(String password);
	@Query("SELECT t FROM User t WHERE t.email = :email")
	Optional<User> findByEmail(String email);

}
