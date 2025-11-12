package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRoleFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRoleDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private UserRoleRepository userroleRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository userDataRepository;
	@Autowired
	private RoleRepository roleDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_userrole() {
		String existingId = UserRoleFixtures.randomOneViaCommand(commandGateway, userroleRepository,
				userDataRepository,
				roleDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		UserRoleFixtures.byIdWaitExist(userroleRepository, existingId);

		String uri = "/v1/admin/commands/userRole/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		UserRole found = UserRoleFixtures.byIdWaitNotExist(userroleRepository, existingId);
		assertThat(found).isNull();
	}
}
