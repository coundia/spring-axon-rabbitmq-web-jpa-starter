package com.groupe2cs.bizyhub.security.application.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

	private final Map<String, TokenEntry> store = new ConcurrentHashMap<>();

	@Value("${security.jwt.refreshExpirationTime}")
	private long refreshExpiration;

	public void saveRefreshToken(String username, String token) {
		var expiration = Instant.now().plusMillis(refreshExpiration);
		store.put(username, new TokenEntry(token, expiration));
	}

	public boolean isValid(String username, String token) {
		TokenEntry entry = store.get(username);
		if (entry == null || Instant.now().isAfter(entry.expiration)) {
			store.remove(username);
			return false;
		}
		return token.equals(entry.token);
	}

	public void invalidate(String username) {
		store.remove(username);
	}

	private record TokenEntry(String token, Instant expiration) {
	}
}
