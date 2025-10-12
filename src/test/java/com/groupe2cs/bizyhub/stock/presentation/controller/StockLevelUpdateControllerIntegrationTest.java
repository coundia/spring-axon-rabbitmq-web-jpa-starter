package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.stock.application.command.CreateStockLevelCommand;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockLevelFixtures;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockLevelRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class StockLevelUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private StockLevelRepository stocklevelRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_stocklevel() {

		String existingId = StockLevelFixtures.randomOneViaCommand(
				commandGateway, stocklevelRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		).getId().value();

		CreateStockLevelCommand updated = StockLevelFixtures.randomOneViaCommand(
				commandGatewayUpdate, stocklevelRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		);

		StockLevelFixtures.byIdWaitExist(stocklevelRepository, existingId);
		StockLevelFixtures.byIdWaitExist(stocklevelRepository, updated.getId().value());

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("remoteId", UUID.randomUUID().toString());
		body.add("localId", UUID.randomUUID().toString());
		body.add("stockOnHand", 9);
		body.add("stockAllocated", 34);
		body.add("account", UUID.randomUUID().toString());
		body.add("productVariant", UUID.randomUUID().toString());
		body.add("syncAt", java.time.Instant.now().plusSeconds(3600));
		body.add("company", UUID.randomUUID().toString());

		HttpHeaders multipartHeaders = new HttpHeaders();
		multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

		String uri = "/api/v1/commands/stockLevel/" + existingId;
		ResponseEntity<String> response = testRestTemplate.exchange(
				uri,
				HttpMethod.PUT,
				requestEntity,
				String.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
