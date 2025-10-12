package com.groupe2cs.bizyhub.shared.application;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidationService {
	private final UserRepository userRepository;

	public void shouldBePremiumUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow();

		boolean isBan = Boolean.TRUE.equals(user.getIsBan());
		boolean isPremium = Boolean.TRUE.equals(user.getIsPremium());

		if (isBan) {
			throw new RuntimeException("Utilisateur banni.");
		}

		if (!isPremium) {
			throw new RuntimeException("Réservé aux utilisateurs premium.");
		}
	}
}
