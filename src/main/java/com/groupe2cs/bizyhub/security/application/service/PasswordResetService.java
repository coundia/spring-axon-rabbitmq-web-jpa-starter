package com.groupe2cs.bizyhub.security.application.service;

import com.groupe2cs.bizyhub.security.application.command.CreatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.command.DeletePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.query.FindByPasswordResetTokenQuery;
import com.groupe2cs.bizyhub.security.domain.event.PasswordResetCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetExpiration;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetId;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetToken;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetUsername;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.domain.MailSender;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class PasswordResetService {

	private final UserRepository userRepo;
	private final PasswordEncoder encoder;
	private final CommandGateway commandGateway;
	private final QueryGateway queryGateway;
	private final MailSender mailSender;

	public String createToken(String email) {
		String token = UUID.randomUUID().toString();
		Instant expiration = Instant.now().plusSeconds(3600);

		var command = CreatePasswordResetCommand.builder()
				.token(PasswordResetToken.create(token))
				.username(PasswordResetUsername.create(email))
				.expiration(PasswordResetExpiration.create(expiration))
				.build();

		commandGateway.sendAndWait(command);
		return token;
	}

	@Transactional
	public boolean resetPassword(String token, String newPassword) {
		try {
			MetaRequest metaRequest = new MetaRequest();
			var query = new FindByPasswordResetTokenQuery(PasswordResetToken.create(token), metaRequest);
			var tokenEntity = queryGateway.query(query, PasswordResetResponse.class).get();

			if (tokenEntity == null || tokenEntity.getExpiration().isBefore(Instant.now())) return false;

			var user = userRepo.findByUsername(tokenEntity.getUsername()).orElse(null);
			if (user == null) return false;

			user.setPassword(encoder.encode(newPassword));

			var deleteCommand = DeletePasswordResetCommand.builder()
					.id(PasswordResetId.create(tokenEntity.getId()))
					.build();

			commandGateway.send(deleteCommand);
			return true;

		} catch (InterruptedException | ExecutionException e) {
			return false;
		}
	}

	@EventHandler
	public void on(PasswordResetCreatedEvent event) {
		this.mailSender.send(
				"noreply@pcoundia.com",
				event.getUsername().value(),
				"Password Reset",
				"Your token: " + event.getToken()
		);
	}
}
