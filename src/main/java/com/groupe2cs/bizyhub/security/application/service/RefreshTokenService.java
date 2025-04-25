package com.groupe2cs.bizyhub.security.application.service;

import com.groupe2cs.bizyhub.security.application.command.CreateRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteRefreshTokenCommand;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenResponse;
import com.groupe2cs.bizyhub.security.application.query.FindByRefreshTokenUsernameQuery;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenExpiration;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenToken;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenUsername;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class RefreshTokenService {

	private final JwtDecoder jwtDecoder;
	private final CommandGateway commandGateway;
	private final QueryGateway queryGateway;

	public void save(String token) {
		try {
			Jwt jwt = jwtDecoder.decode(token);
			String username = jwt.getSubject();
			Instant expiration = jwt.getExpiresAt();

			try {
				CompletableFuture<RefreshTokenResponse> future = queryGateway.query(
						new FindByRefreshTokenUsernameQuery(RefreshTokenUsername.create(username)),
						RefreshTokenResponse.class
				);

				RefreshTokenResponse existing = future.join();
				if (existing != null) {
					commandGateway.sendAndWait(new DeleteRefreshTokenCommand(RefreshTokenId.create(existing.getId())));
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.info("No existing refresh token found for {}. Proceeding to save new.", username);
			}

			commandGateway.sendAndWait(CreateRefreshTokenCommand.builder()
					.token(RefreshTokenToken.create(token))
					.username(RefreshTokenUsername.create(username))
					.expiration(RefreshTokenExpiration.create(expiration))
					.build());

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while saving refresh token: {}", e.getMessage(), e);
		}
	}

	public boolean isValid(String username, String token) {
		try {
			CompletableFuture<RefreshTokenResponse> future = queryGateway.query(
					new FindByRefreshTokenUsernameQuery(RefreshTokenUsername.create(username)),
					RefreshTokenResponse.class
			);

			RefreshTokenResponse response = future.join();

			if (Instant.now().isAfter(response.getExpiration())) {
				commandGateway.sendAndWait(new DeleteRefreshTokenCommand(RefreshTokenId.create(response.getId())));
				return false;
			}

			return response.getToken().equals(token);
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("Refresh token validation failed for {}: {}", username, e.getMessage());
			return false;
		}
	}

	public void invalidate(String username) {
		queryGateway.query(
				new FindByRefreshTokenUsernameQuery(RefreshTokenUsername.create(username)),
				RefreshTokenResponse.class
		).handle((response, ex) -> {
			if (ex != null || response == null) {
				log.info("No refresh token to invalidate for {}", username);
				return null;
			}
			commandGateway.sendAndWait(new DeleteRefreshTokenCommand(RefreshTokenId.create(response.getId())));
			log.info("Refresh token invalidated for {}", username);
			return null;
		});
	}
}
