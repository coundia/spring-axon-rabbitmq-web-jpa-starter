package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TenantDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private TenantRepository tenantRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private TenantRepository tenantDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;

	@Test
	void it_should_be_able_to_delete_tenant() {
		String existingId = TenantFixtures.randomOneViaCommand(commandGateway, tenantRepository,
				tenantDataRepository,
				createdByDataRepository,
				getCurrentUser()).getId().value();

		TenantFixtures.byIdWaitExist(tenantRepository, existingId);

		String uri = "/v1/admin/commands/tenant/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Tenant found = TenantFixtures.byIdWaitNotExist(tenantRepository, existingId);
		assertThat(found).isNull();
	}
}
