package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class PasswordResetDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private PasswordResetRepository passwordresetRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_delete_passwordreset() {
	String existingId = PasswordResetFixtures.randomOneViaCommand(commandGateway).getId().value();
	String uri = "/v1/commands/passwordReset/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	PasswordReset found = PasswordResetFixtures.byIdWaitNotExist(passwordresetRepository, existingId);
	assertThat(found).isNull();
	}
}
