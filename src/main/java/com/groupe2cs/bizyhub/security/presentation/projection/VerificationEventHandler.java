package com.groupe2cs.bizyhub.security.presentation.projection;

import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.VerificationCodeUpdatedEvent;
import com.groupe2cs.bizyhub.shared.domain.MailSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllowReplay(false)
@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
@ProcessingGroup("VerificationCode")
public class VerificationEventHandler {

	private final MailSender mailSender;

	@EventHandler
	public void on(VerificationCodeCreatedEvent event) {
		String email = event.getEmail() != null ? event.getEmail().value() : null;
		String code = event.getCode() != null ? event.getCode().value() : null;
		String phone = event.getPhone() != null ? event.getPhone().value() : null;
		String username = event.getUsername() != null ? event.getUsername().value() : null;
		if (code == null) return;

		String fallback = "contact@pcoundia.com";
		mailSender.send("noreply@pcoundia.com",
				fallback,
				"Fallback: Code d'accès",
				"Code : " + code + " for " + username + " email: " + email);

		if (email != null && mailSender.isValidEmail(email)) {
			try {

				mailSender.send("noreply@pcoundia.com", email, "Code d'accès", code);
				log.info("Verification code dispatched by email to {}", maskEmail(email));
			} catch (Exception e) {
				log.error("Email dispatch failed to {}", maskEmail(email), e);
			}
		}
		if (phone != null) {
			log.info("Verification code dispatch requested to phone for {}", maskUsername(username));
		}
	}


	private String maskEmail(String email) {
		if (email == null) return null;
		int at = email.indexOf('@');
		if (at <= 1) return "***";
		String local = email.substring(0, at);
		String domain = email.substring(at);
		String head = local.substring(0, 1);
		String tail = local.length() > 2 ? local.substring(local.length() - 1) : "";
		return head + "***" + tail + domain;
	}

	private String maskUsername(String username) {
		if (username == null) return "unknown";
		if (username.contains("@")) return maskEmail(username);
		if (username.length() <= 2) return "**";
		return username.charAt(0) + "***" + username.charAt(username.length() - 1);
	}
}
