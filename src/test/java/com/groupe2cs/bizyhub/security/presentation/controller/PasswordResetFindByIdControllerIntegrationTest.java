package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;

public class PasswordResetFindByIdControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private PasswordResetRepository passwordresetRepository;

@Test
void it_should_be_able_to_get_passwordreset_by_id() {
	PasswordReset entity = PasswordResetFixtures.randomOne(passwordresetRepository);
	String existingId = entity.getId();

	String uri = "/v1/queries/passwordReset/id?id=" + existingId;
	ResponseEntity<PasswordResetResponse> response = this.getForEntity(uri, PasswordResetResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
