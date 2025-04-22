package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class RolePermissionFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private RolePermissionRepository rolepermissionRepository;

	@Test
	void it_should_be_able_to_get_rolepermission_by_id() {
		RolePermission entity = RolePermissionFixtures.randomOne(rolepermissionRepository);
		String existingId = entity.getId();

		String uri = "/v1/queries/rolePermission/id?id=" + existingId;
		ResponseEntity<RolePermissionResponse> response = this.getForEntity(uri, RolePermissionResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
