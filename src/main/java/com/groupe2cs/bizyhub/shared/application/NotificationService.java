package com.groupe2cs.bizyhub.shared.application;

import com.groupe2cs.bizyhub.shared.domain.MailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService  {

private final MailSender mailSender;

	public void notifyByEmail(String from,String to, String subject, String content) {

		log.info("MAIL → From: {}, To: {}, Subject: {}, Content: {}",from, to, subject, content);
		mailSender.send(from, to, subject, content);

	}
}
