package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockLevel;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockLevelFixtures;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockLevelRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class StockLevelDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private StockLevelRepository stocklevelRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_stocklevel() {
		String existingId = StockLevelFixtures.randomOneViaCommand(commandGateway, stocklevelRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		StockLevelFixtures.byIdWaitExist(stocklevelRepository, existingId);

		String uri = "/v1/commands/stockLevel/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		StockLevel found = StockLevelFixtures.byIdWaitNotExist(stocklevelRepository, existingId);
		assertThat(found).isNull();
	}
}
