package com.groupe2cs.bizyhub.units.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.units.application.command.*;
import com.groupe2cs.bizyhub.units.application.dto.*;
import com.groupe2cs.bizyhub.units.infrastructure.entity.UnitFixtures;
import com.groupe2cs.bizyhub.units.infrastructure.repository.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class UnitFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private UnitRepository unitRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_units_for_normal_user() throws Exception {

		List<CreateUnitCommand> userCommands =
				UnitFixtures.randomManyViaCommand(
						commandGateway, unitRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				UnitFixtures.byIdWaitExist(unitRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<UnitPagedResponse> response = this.getForEntity(
				"/v1/queries/units?page=0&limit=1000000",
				UnitPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<UnitResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(UnitResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_units_for_admin() throws Exception {

		List<CreateUnitCommand> userCommands =
				UnitFixtures.randomManyViaCommand(
						commandGateway,
						unitRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				UnitFixtures.byIdWaitExist(unitRepository, cmd.getId().value())
		);


		List<CreateUnitCommand> adminCommands =
				UnitFixtures.randomManyViaCommand(
						commandGateway, unitRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				UnitFixtures.byIdWaitExist(unitRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<UnitPagedResponse> response = this.getForEntity(
				"/v1/queries/units?page=0&limit=1000000",
				UnitPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<UnitResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(UnitResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
