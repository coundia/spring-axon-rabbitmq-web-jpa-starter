package com.groupe2cs.bizyhub.shared.presentation;

import com.groupe2cs.bizyhub.shared.application.NotificationService;
import com.groupe2cs.bizyhub.shared.domain.MailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.beans.factory.annotation.Value;

@Tag(name = "Notification", description = "Send a test mail")
@RestController
@RequestMapping("/api/v1/test-mail")
@RequiredArgsConstructor
public class SendTestsMailController {

private final NotificationService notificationService;

@Value("${spring.mail.username:'noreply@pcoundia.com'}")
private String from;

@Operation(
summary = "Send test mail",
description = "Send a test email to the given address",
parameters = {
@Parameter(
name = "to",
description = "Recipient email address",
required = true,
examples = {
@ExampleObject(name = "Example", value = "contact@pcoundia.com")
}
)
}
)
@PostMapping
public ResponseEntity<Void> sendTestMail(@RequestParam String to) {
	notificationService.notifyByEmail(
	from,
	to,
	"Test Email",
	"<h1>This is a test email</h1><p>Sent from BizyHub</p>"
	);

	return ResponseEntity.ok().build();
	}
}
