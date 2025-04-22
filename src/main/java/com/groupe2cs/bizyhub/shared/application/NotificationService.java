package com.groupe2cs.bizyhub.shared.application;

import com.groupe2cs.bizyhub.shared.domain.MailSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class
NotificationService {

	private final MailSender mailSender;

	public void notifyByEmail(String to, String subject, String content) {

		log.info("MAIL → To: {}, Subject: {}, Content: {}", to, subject, content);
		mailSender.send(to, subject, content);

	}
}
