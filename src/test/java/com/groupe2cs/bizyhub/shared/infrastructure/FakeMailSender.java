package com.groupe2cs.bizyhub.shared.infrastructure;

import com.groupe2cs.bizyhub.shared.domain.MailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("test")
public class FakeMailSender implements MailSender {
	@Override
	public void send(String from, String to, String subject, String content) {
		log.info("FAKE MAIL → from: {}, To: {}, Subject: {}, Content: {}",from, to, subject, content);
	}
}
