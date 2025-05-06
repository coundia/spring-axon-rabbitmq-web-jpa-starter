package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.command.CreateSaleUserCommand;
import com.groupe2cs.bizyhub.sales.application.dto.SaleUserRequest;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.SaleUserFixtures;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleUserRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class SaleUserUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private SaleUserRepository saleuserRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository salesDataRepository;
	@Autowired
	private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository usersDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_saleuser() {

		String existingId = SaleUserFixtures.randomOneViaCommand(
				commandGateway, saleuserRepository,
				salesDataRepository,
				usersDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		CreateSaleUserCommand updated = SaleUserFixtures.randomOneViaCommand(commandGatewayUpdate,
				saleuserRepository,
				salesDataRepository,
				usersDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser());

		SaleUserFixtures.byIdWaitExist(saleuserRepository, existingId);
		SaleUserFixtures.byIdWaitExist(saleuserRepository, updated.getId().value());

		SaleUserRequest requestDTO = new SaleUserRequest();
		requestDTO.setSales(updated.getSales().value());
		requestDTO.setUsers(updated.getUsers().value());
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setIsActive(false);
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setReference(UUID.randomUUID().toString());

		String uri = "/v1/commands/saleUser/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
