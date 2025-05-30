package com.groupe2cs.bizyhub.security.application.service;

import com.groupe2cs.bizyhub.security.application.command.CreatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.command.DeletePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.query.FindByPasswordResetTokenQuery;
import com.groupe2cs.bizyhub.security.domain.event.PasswordResetCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.domain.MailSender;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class PasswordResetService {

	//todo refactor (remove UserRepository) to use a query to get the user (full CQRS)
	private final UserRepository userRepo;
	private final PasswordEncoder encoder;
	private final CommandGateway commandGateway;
	private final QueryGateway queryGateway;
	private final MailSender mailSender;

	public String createToken(String email, MetaRequest metaRequest) {
		String token = UUID.randomUUID().toString();
		Instant expiration = Instant.now().plusSeconds(3600);

		var command = CreatePasswordResetCommand.builder()
				.token(PasswordResetToken.create(token))
				.username(PasswordResetUsername.create(email))
				.expiration(PasswordResetExpiration.create(expiration))
				.tenant(PasswordResetTenant.create(metaRequest.getTenantId()))
				.build();

		commandGateway.sendAndWait(command);
		return token;
	}

	@Transactional
	public boolean resetPassword(String token, String newPassword, MetaRequest metaRequest) {
		try {


			var query = new FindByPasswordResetTokenQuery(PasswordResetToken.create(token), metaRequest);
			var tokenEntity = queryGateway.query(
					query,
					ResponseTypes.multipleInstancesOf(PasswordResetResponse.class)
			).get().stream().findFirst().orElse(null);

			if (tokenEntity == null) {
				log.error("Token not found for token: {}", token);
				return false;
			}

			if (tokenEntity.getExpiration().isBefore(Instant.now())) {
				log.error("Token expired for token: {}", token);
				return false;
			}

			//todo move to full CQRS , by using a query to get the user
			var user =
					userRepo.findByUsernameAndTenantId(tokenEntity.getUsername(), metaRequest.getTenantId())
							.stream()
							.findFirst()
							.orElse(null);
			if (user == null) {
				log.info("User not found for username: {}", tokenEntity.getUsername());
				return false;
			}

			user.setPassword(encoder.encode(newPassword));

			//todo move to full CQRS , by using a command to delete the user
			var deleteCommand = DeletePasswordResetCommand.builder()
					.id(PasswordResetId.create(tokenEntity.getId()))
					.build();

			log.info("Deleting password reset token for user: {}", tokenEntity.getId());

			commandGateway.send(deleteCommand);

			log.info("Password reset successfully for user: {}", tokenEntity.getUsername());
			return true;

		} catch (InterruptedException | ExecutionException e) {
			log.error("Error while resetting password: {}", e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@EventHandler
	public void on(PasswordResetCreatedEvent event) {

		String email = event.getUsername().value();

		log.info("Password reset event triggered for email: {}", email);
		if (!mailSender.isValidEmail(email)) {
			email = "contact@pcoundia.com";
			log.info("Email is null or empty, using default email: {}", email);
		}

		log.info("Sending password reset email to: {}", event.getUsername().value());
		this.mailSender.send(
				"noreply@pcoundia.com",
				email,
				"Password Reset",
				"Your token: " + event.getToken()
		);
	}
}
