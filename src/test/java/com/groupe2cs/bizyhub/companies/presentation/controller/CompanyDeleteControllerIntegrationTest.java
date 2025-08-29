package com.groupe2cs.bizyhub.companies.presentation.controller;

import com.groupe2cs.bizyhub.companies.infrastructure.entity.Company;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_company() {
		String existingId = CompanyFixtures.randomOneViaCommand(commandGateway, companyRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		CompanyFixtures.byIdWaitExist(companyRepository, existingId);

		String uri = "/v1/commands/company/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Company found = CompanyFixtures.byIdWaitNotExist(companyRepository, existingId);
		assertThat(found).isNull();
	}
}
