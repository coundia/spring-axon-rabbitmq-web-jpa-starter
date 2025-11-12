package com.groupe2cs.bizyhub.companies.presentation.controller;

import com.groupe2cs.bizyhub.companies.application.command.CreateCompanyCommand;
import com.groupe2cs.bizyhub.companies.application.dto.CompanyPagedResponse;
import com.groupe2cs.bizyhub.companies.application.dto.CompanyResponse;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class CompanyFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_companys_for_normal_user() throws Exception {

		List<CreateCompanyCommand> userCommands =
				CompanyFixtures.randomManyViaCommand(
						commandGateway, companyRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				CompanyFixtures.byIdWaitExist(companyRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<CompanyPagedResponse> response = this.getForEntity(
				"/v1/queries/companys?page=0&limit=1000000",
				CompanyPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<CompanyResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(CompanyResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_companys_for_admin() throws Exception {

		List<CreateCompanyCommand> userCommands =
				CompanyFixtures.randomManyViaCommand(
						commandGateway,
						companyRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				CompanyFixtures.byIdWaitExist(companyRepository, cmd.getId().value())
		);


		List<CreateCompanyCommand> adminCommands =
				CompanyFixtures.randomManyViaCommand(
						commandGateway, companyRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				CompanyFixtures.byIdWaitExist(companyRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<CompanyPagedResponse> response = this.getForEntity(
				"/v1/queries/companys?page=0&limit=1000000",
				CompanyPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<CompanyResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(CompanyResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
