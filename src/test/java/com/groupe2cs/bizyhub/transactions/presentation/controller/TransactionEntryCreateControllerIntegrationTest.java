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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionEntryCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository categoryDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository customerDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.debts.infrastructure.repository.DebtRepository debtDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_transactionentry() {

		TransactionEntryRequest requestDTO = new TransactionEntryRequest();

		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setCode(UUID.randomUUID().toString());
		requestDTO.setDescription(UUID.randomUUID().toString());
		requestDTO.setAmount(7404.41);
		requestDTO.setTypeEntry(UUID.randomUUID().toString());
		requestDTO.setDateTransaction(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setEntityName(UUID.randomUUID().toString());
		requestDTO.setEntityId(UUID.randomUUID().toString());
		requestDTO.setAccount(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(commandGateway,accountDataRepository, user).getId().value());
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setCategory(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(commandGateway,categoryDataRepository, user).getId().value());
		requestDTO.setCompany(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value());
		requestDTO.setCustomer(com.groupe2cs.bizyhub.customers.infrastructure.entity.CustomerFixtures.randomOneViaCommand(commandGateway,customerDataRepository, user).getId().value());
		requestDTO.setDebt(com.groupe2cs.bizyhub.debts.infrastructure.entity.DebtFixtures.randomOneViaCommand(commandGateway,debtDataRepository, user).getId().value());

 		String uri = "/v1/commands/transactionEntry";
		ResponseEntity<TransactionEntryResponse> response = this.postForEntity(uri, requestDTO, TransactionEntryResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getCode()).isEqualTo(requestDTO.getCode());
		assertThat(response.getBody().getDescription()).isEqualTo(requestDTO.getDescription());
		assertThat(response.getBody().getAmount()).isEqualTo(requestDTO.getAmount());
		assertThat(response.getBody().getTypeEntry()).isEqualTo(requestDTO.getTypeEntry());
		assertThat(response.getBody().getDateTransaction()).isEqualTo(requestDTO.getDateTransaction());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getEntityName()).isEqualTo(requestDTO.getEntityName());
		assertThat(response.getBody().getEntityId()).isEqualTo(requestDTO.getEntityId());
		assertThat(response.getBody().getAccount()).isEqualTo(requestDTO.getAccount());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
		assertThat(response.getBody().getCategory()).isEqualTo(requestDTO.getCategory());
		assertThat(response.getBody().getCompany()).isEqualTo(requestDTO.getCompany());
		assertThat(response.getBody().getCustomer()).isEqualTo(requestDTO.getCustomer());
		assertThat(response.getBody().getDebt()).isEqualTo(requestDTO.getDebt());
	}
}
