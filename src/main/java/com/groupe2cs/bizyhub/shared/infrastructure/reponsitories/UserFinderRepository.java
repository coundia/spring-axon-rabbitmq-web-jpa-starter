// Spring Data repository for User entity with finders used by user resolution.
package com.groupe2cs.bizyhub.shared.infrastructure.reponsitories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;

@Repository
public interface UserFinderRepository extends JpaRepository<User, String> {
	Optional<User> findByEmailIgnoreCase(String email);
	Optional<User> findByTelephone(String telephone);
	Optional<User> findByUsernameIgnoreCase(String username);
	default Optional<User> findByAny(String token) {
		if (token == null || token.isBlank()) return Optional.empty();
		return findByEmailIgnoreCase(token)
				.or(() -> findByTelephone(token))
				.or(() -> findByUsernameIgnoreCase(token));
	}
}
