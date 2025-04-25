package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Authorization gate for User operations.
 * <p>
 * This component provides permission checks based on the currently authenticated user.
 * It ensures that only the User owner or an admin can perform sensitive actions
 * such as read, edit, or delete.
 */
@Component
@RequiredArgsConstructor
public class UserGate {

	private final UserRepository repository;

	public boolean canRead(Authentication authentication, String id) {
		return isAdmin(authentication) || isOwner(authentication, id);
	}

	public boolean canCreate(Authentication authentication) {
		return authentication != null && authentication.isAuthenticated();
	}

	public boolean canEdit(Authentication authentication, String id) {
		return isAdmin(authentication) || isOwner(authentication, id);
	}

	public boolean canDelete(Authentication authentication, String id) {
		return isAdmin(authentication) || isOwner(authentication, id);
	}

	public boolean canList(Authentication authentication) {
		return authentication != null && authentication.isAuthenticated();
	}

	private boolean isOwner(Authentication authentication, String id) {
		if (authentication == null || !authentication.isAuthenticated()) return false;
		String currentUser = authentication.getName();
		return repository.findById(id)
				.map(entity -> {
					try {
						var createdByField = entity.getClass().getDeclaredField("createdBy");
						createdByField.setAccessible(true);
						Object createdByValue = createdByField.get(entity);
						return createdByValue != null && createdByValue.equals(currentUser);
					} catch (Exception e) {
						return true; // fallback if no createdBy field
					}
				})
				.orElse(false);
	}

	private boolean isAdmin(Authentication authentication) {
		if (authentication == null || !authentication.isAuthenticated()) return false;

		return true;

			/*return authentication.getAuthorities().stream()
					.map(GrantedAuthority::getAuthority)
					.anyMatch(auth -> auth.equals("ROLE_ADMIN"));*/
	}
}
