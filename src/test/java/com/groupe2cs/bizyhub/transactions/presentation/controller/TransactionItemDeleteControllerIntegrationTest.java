package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class TransactionItemDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private TransactionItemRepository transactionitemRepository;

@Autowired
private CommandGateway commandGateway;


@Autowired
private com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository transactionDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.units.infrastructure.repository.UnitRepository unitDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_delete_transactionitem() {
	String existingId = TransactionItemFixtures.randomOneViaCommand(commandGateway, transactionitemRepository,
        transactionDataRepository,
        productDataRepository,
        unitDataRepository,
        createdByDataRepository,
        tenantDataRepository,
	getCurrentUser()).getId().value();

	TransactionItemFixtures.byIdWaitExist(transactionitemRepository, existingId);

	String uri = "/v1/commands/transactionItem/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	TransactionItem found = TransactionItemFixtures.byIdWaitNotExist(transactionitemRepository, existingId);
	assertThat(found).isNull();
	}
}
