package com.groupe2cs.bizyhub.shared.infrastructure;

import com.groupe2cs.bizyhub.shared.domain.MailSender;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Primary
@Service
@RequiredArgsConstructor
public class MailSenderImpl implements MailSender {

	private final JavaMailSender mailSender;


	@Override
	public void send(String from, String to, String subject, String content) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			helper.setFrom(from);
			mailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException("Mail sending failed", e);
		}
	}
}
