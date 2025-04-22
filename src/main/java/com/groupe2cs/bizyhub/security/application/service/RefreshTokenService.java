package com.groupe2cs.bizyhub.security.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

	private final Map<String, String> store = new ConcurrentHashMap<>();

	@Value("${security.jwt.refreshExpiration}")
	private long refreshExpiration;

	public void saveRefreshToken(String username, String token) {
		store.put(username, token);
	}

	public boolean isValid(String username, String token) {
		return token.equals(store.get(username));
	}

	public void invalidate(String username) {
		store.remove(username);
	}
}
