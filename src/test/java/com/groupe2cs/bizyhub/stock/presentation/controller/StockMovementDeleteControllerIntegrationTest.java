package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockMovement;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockMovementFixtures;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockMovementRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class StockMovementDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private StockMovementRepository stockmovementRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_stockmovement() {
		String existingId = StockMovementFixtures.randomOneViaCommand(commandGateway, stockmovementRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		StockMovementFixtures.byIdWaitExist(stockmovementRepository, existingId);

		String uri = "/v1/commands/stockMovement/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		StockMovement found = StockMovementFixtures.byIdWaitNotExist(stockmovementRepository, existingId);
		assertThat(found).isNull();
	}
}
