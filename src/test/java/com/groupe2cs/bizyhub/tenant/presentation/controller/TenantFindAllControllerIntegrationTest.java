package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.application.command.CreateTenantCommand;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantPagedResponse;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class TenantFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private TenantRepository tenantRepository;

	@Test
	void it_should_return_only_user_tenants_for_normal_user() throws Exception {

		List<CreateTenantCommand> userCommands =
				TenantFixtures.randomManyViaCommand(commandGateway, 3, login("user", "user"));
		userCommands.forEach(cmd ->
				TenantFixtures.byIdWaitExist(tenantRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<TenantPagedResponse> response = this.getForEntity(
				"/v1/admin/queries/tenants?page=0&limit=1000000",
				TenantPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

	}

	@Test
	void it_should_return_all_tenants_for_admin() throws Exception {

		List<CreateTenantCommand> userCommands =
				TenantFixtures.randomManyViaCommand(commandGateway, 5, login("user", "user"));
		userCommands.forEach(cmd ->
				TenantFixtures.byIdWaitExist(tenantRepository, cmd.getId().value())
		);


		List<CreateTenantCommand> adminCommands =
				TenantFixtures.randomManyViaCommand(commandGateway, 5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				TenantFixtures.byIdWaitExist(tenantRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<TenantPagedResponse> response = this.getForEntity(
				"/v1/admin/queries/tenants?page=0&limit=1000000",
				TenantPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<TenantResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(TenantResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
