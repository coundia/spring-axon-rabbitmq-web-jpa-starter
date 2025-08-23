package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeUpdatedEvent;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.entity.VerificationCode;
import com.groupe2cs.bizyhub.security.infrastructure.repository.VerificationCodeRepository;
import com.groupe2cs.bizyhub.shared.domain.MailSender;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllowReplay(value = false)
@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
@ProcessingGroup("VerificationCode")
public class VerificationEventHandler {

	private final MailSender mailSender;

	@EventHandler
	public void on(VerificationCodeCreatedEvent event) {
		log.info("Handling VerificationCodeCreatedEvent: {}", event);
		try {

			String email = event.getEmail() == null ? null : event.getEmail().value();
			String code = event.getCode() == null ? null : event.getCode().value();
			String phone = event.getPhone() == null ? null : event.getPhone().value();

			if (email != null) {
				// Send email with the code
				log.info("Sending verification code {} to email {}", code, email);
				// Implement email sending logic here

				log.info("Password reset event triggered for email: {}", email);
				if (!mailSender.isValidEmail(email)) {
					email = "contact@pcoundia.com";
					log.info("Email is null or empty, using default email: {}", email);
				}

				log.info("Sending password reset email to: {}", event.getUsername().value());
				this.mailSender.send(
						"noreply@pcoundia.com",
						email,
						"Code d'accès",
						code
				);
			}
			if (phone != null) {
				// Send SMS with the code
				log.info("Sending verification code {} to phone {}", code, phone);
				// Implement SMS sending logic here

			}


		} catch (Exception e) {
			log.error("Error saving VerificationCode: {}", e.getMessage(), e);
			throw e;
		}
	}

}
