package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.sales.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class SaleDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private SaleRepository saleRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_delete_sale() {
	String existingId = SaleFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

	SaleFixtures.byIdWaitExist(saleRepository, existingId);

	String uri = "/v1/commands/sale/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	Sale found = SaleFixtures.byIdWaitNotExist(saleRepository, existingId);
	assertThat(found).isNull();
	}
}
