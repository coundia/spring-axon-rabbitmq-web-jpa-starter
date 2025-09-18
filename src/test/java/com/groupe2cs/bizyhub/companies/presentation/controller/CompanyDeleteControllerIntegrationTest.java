package com.groupe2cs.bizyhub.companies.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.*;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.companies.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class CompanyDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CompanyRepository companyRepository;

@Autowired
private CommandGateway commandGateway;


@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

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
