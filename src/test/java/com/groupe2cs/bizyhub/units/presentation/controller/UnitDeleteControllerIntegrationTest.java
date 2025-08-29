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
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private UnitRepository unitRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_unit() {
		String existingId = UnitFixtures.randomOneViaCommand(commandGateway, unitRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		UnitFixtures.byIdWaitExist(unitRepository, existingId);

		String uri = "/v1/commands/unit/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Unit found = UnitFixtures.byIdWaitNotExist(unitRepository, existingId);
		assertThat(found).isNull();
	}
}
