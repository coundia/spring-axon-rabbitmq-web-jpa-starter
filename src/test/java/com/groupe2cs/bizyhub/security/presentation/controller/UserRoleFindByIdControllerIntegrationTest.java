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

public class UserRoleFindByIdControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private UserRoleRepository userroleRepository;

@Test
void it_should_be_able_to_get_userrole_by_id() {
	UserRole entity = UserRoleFixtures.randomOne(userroleRepository);
	String existingId = entity.getId();

	String uri = "/v1/queries/userrole/by-id?id=" + existingId;
	ResponseEntity<UserRoleResponse> response = this.getForEntity(uri, UserRoleResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
