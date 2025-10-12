package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelResponse;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockLevelFixtures;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockLevelRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class StockLevelFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private StockLevelRepository repository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_get_stocklevel_by_id() {

		String existingId = StockLevelFixtures.randomOneViaCommand(
				commandGateway, repository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		StockLevelFixtures.byIdWaitExist(repository, existingId);

		String uri = "/v1/queries/stockLevel/id?id=" + existingId;
		ResponseEntity<StockLevelResponse> response = this.getForEntity(uri, StockLevelResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
