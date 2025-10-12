// Service that resolves a userId (String) from identifiant/telephone/email/username or returns guest's id.
package com.groupe2cs.bizyhub.shared.application;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.groupe2cs.bizyhub.shared.infrastructure.reponsitories.UserFinderRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;

@Service
public class UserResolverService {

	private static final String GUEST_USERNAME = "guest";

	private final UserFinderRepository users;

	public UserResolverService(UserFinderRepository users) {
		this.users = users;
	}

	private static String firstNonBlank(String a, String b) {
		if (nonBlank(a)) return a.trim();
		if (nonBlank(b)) return b.trim();
		return null;
	}

	private static boolean nonBlank(String s) {
		return s != null && !s.trim().isEmpty();
	}

	private static String guessPhone(String s) {
		if (!nonBlank(s)) return null;
		String t = s.trim();
		if (t.startsWith("+")) return t;
		if (t.matches("\\d[\\d\\s-]{6,}")) return t.replaceAll("[^\\d+]", "");
		return null;
	}

	private static String guessEmail(String s) {
		if (!nonBlank(s)) return null;
		String t = s.trim();
		if (t.contains("@")) return t;
		return null;
	}

	private static String guessUsername(String s) {
		if (!nonBlank(s)) return null;
		String t = s.trim();
		if (!t.contains("@") && !t.matches("[+\\d].*")) return t;
		return null;
	}

	private static String normalizePhone(String p) {
		if (!nonBlank(p)) return null;
		String digitsPlus = p.replaceAll("[^\\d+]", "");
		if (digitsPlus.startsWith("00")) return "+" + digitsPlus.substring(2);
		if (!digitsPlus.startsWith("+") && digitsPlus.length() >= 9) return "+" + digitsPlus;
		return digitsPlus;
	}

	@SafeVarargs
	private static <T> Optional<T> firstPresent(SupplierWithOptional<T>... suppliers) {
		for (SupplierWithOptional<T> s : suppliers) {
			Optional<T> v = s.get();
			if (v.isPresent()) return v;
		}
		return Optional.empty();
	}

	@Transactional(readOnly = true)
	public String resolveUserId(String identifiant, String telephone, String mail, String username) {
		String tel = normalizePhone(firstNonBlank(telephone, guessPhone(identifiant)));
		String email = firstNonBlank(mail, guessEmail(identifiant));
		String user = firstNonBlank(username, guessUsername(identifiant));

		Optional<User> match =
				firstPresent(
						() -> nonBlank(email) ? users.findByEmailIgnoreCase(email) : Optional.empty(),
						() -> nonBlank(tel) ? users.findByTelephone(tel) : Optional.empty(),
						() -> nonBlank(user) ? users.findByUsernameIgnoreCase(user) : Optional.empty(),
						() -> nonBlank(identifiant) ? users.findByAny(identifiant) : Optional.empty()
				);

		return match.map(User::getId).orElseGet(this::ensureGuestId);
	}

	@Transactional
	protected String ensureGuestId() {
		return users.findByUsernameIgnoreCase(GUEST_USERNAME)
				.map(User::getId)
				.orElseGet(() -> {
					User guest = new User();
					guest.setUsername(GUEST_USERNAME);
					guest.setEmail(null);
					guest.setTelephone(null);
					guest.setEnabled(true);
					return users.save(guest).getId();
				});
	}

	@FunctionalInterface
	private interface SupplierWithOptional<T> {
		Optional<T> get();
	}
}
