package com.groupe2cs.bizyhub.shared.infrastructure;


import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.groupe2cs.bizyhub.shared.domain.MailSender;

@Service
@RequiredArgsConstructor
@Slf4j
public class AsyncMailService {
	private final MailSender mailSender;

	@Async("mailExecutor")
	public CompletableFuture<Void> send(String from, String to, String subject, String htmlBody) {
		try {
			log.info("Sending mail to: {}", to);
			log.info("Mail subject: {}", subject);
			log.info("Mail body: {}", htmlBody);
			mailSender.send(from, to, subject, htmlBody);
		} catch (Exception ex) {
			log.error("Mail send failed: {}", ex.getMessage(), ex);
		}
		return CompletableFuture.completedFuture(null);
	}
}
