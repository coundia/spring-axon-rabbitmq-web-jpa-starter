package com.groupe2cs.bizyhub.debts.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.debts.application.dto.*;
import com.groupe2cs.bizyhub.debts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.debts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.debts.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class DebtDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private DebtRepository debtRepository;

@Autowired
private CommandGateway commandGateway;


@Autowired
private com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository customerDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_delete_debt() {
	String existingId = DebtFixtures.randomOneViaCommand(commandGateway, debtRepository,
        customerDataRepository,
        createdByDataRepository,
        tenantDataRepository,
	getCurrentUser()).getId().value();

	DebtFixtures.byIdWaitExist(debtRepository, existingId);

	String uri = "/v1/commands/debt/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	Debt found = DebtFixtures.byIdWaitNotExist(debtRepository, existingId);
	assertThat(found).isNull();
	}
}
