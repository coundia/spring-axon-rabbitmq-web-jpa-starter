package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class UserFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void it_should_be_able_to_get_user_by_id() {
		User entity = UserFixtures.randomOne(userRepository);
		String existingId = entity.getId();

		String uri = "/v1/queries/user/id?id=" + existingId;
		ResponseEntity<UserResponse> response = this.getForEntity(uri, UserResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
