package com.groupe2cs.bizyhub.shared.infrastructure;

import com.groupe2cs.bizyhub.shared.domain.MailSender;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

public class MailSenderTest {

	@Test
	void it_should_send_email_with_correct_content() {
		JavaMailSender mailSender = mock(JavaMailSender.class);

		MimeMessage mimeMessage = new MimeMessage((jakarta.mail.Session) null);
		when(mailSender.createMimeMessage()).thenReturn(mimeMessage);

		MailSender service = new MailSenderImpl(mailSender);

		service.send("noreply@example.com", "to@example.com", "subject", "content");

		verify(mailSender, times(1)).send(any(MimeMessage.class));
	}
}
