package com.groupe2cs.bizyhub.customers.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.customers.application.dto.*;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.*;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.customers.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_customer() {

		CustomerRequest requestDTO = new CustomerRequest();

		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setCode(UUID.randomUUID().toString());
		requestDTO.setFirstName(UUID.randomUUID().toString());
		requestDTO.setLastName(UUID.randomUUID().toString());
		requestDTO.setFullName(UUID.randomUUID().toString());
		requestDTO.setBalance(3163.25);
		requestDTO.setBalanceDebt(1400.09);
		requestDTO.setPhone(UUID.randomUUID().toString());
		requestDTO.setEmail(UUID.randomUUID().toString());
		requestDTO.setNotes(UUID.randomUUID().toString());
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setCompany(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value());
		requestDTO.setAddressLine1(UUID.randomUUID().toString());
		requestDTO.setAddressLine2(UUID.randomUUID().toString());
		requestDTO.setCity(UUID.randomUUID().toString());
		requestDTO.setRegion(UUID.randomUUID().toString());
		requestDTO.setCountry(UUID.randomUUID().toString());
		requestDTO.setPostalCode(UUID.randomUUID().toString());
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setIsActive(true);

 		String uri = "/v1/commands/customer";
		ResponseEntity<CustomerResponse> response = this.postForEntity(uri, requestDTO, CustomerResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getCode()).isEqualTo(requestDTO.getCode());
		assertThat(response.getBody().getFirstName()).isEqualTo(requestDTO.getFirstName());
		assertThat(response.getBody().getLastName()).isEqualTo(requestDTO.getLastName());
		assertThat(response.getBody().getFullName()).isEqualTo(requestDTO.getFullName());
		assertThat(response.getBody().getBalance()).isEqualTo(requestDTO.getBalance());
		assertThat(response.getBody().getBalanceDebt()).isEqualTo(requestDTO.getBalanceDebt());
		assertThat(response.getBody().getPhone()).isEqualTo(requestDTO.getPhone());
		assertThat(response.getBody().getEmail()).isEqualTo(requestDTO.getEmail());
		assertThat(response.getBody().getNotes()).isEqualTo(requestDTO.getNotes());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getCompany()).isEqualTo(requestDTO.getCompany());
		assertThat(response.getBody().getAddressLine1()).isEqualTo(requestDTO.getAddressLine1());
		assertThat(response.getBody().getAddressLine2()).isEqualTo(requestDTO.getAddressLine2());
		assertThat(response.getBody().getCity()).isEqualTo(requestDTO.getCity());
		assertThat(response.getBody().getRegion()).isEqualTo(requestDTO.getRegion());
		assertThat(response.getBody().getCountry()).isEqualTo(requestDTO.getCountry());
		assertThat(response.getBody().getPostalCode()).isEqualTo(requestDTO.getPostalCode());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
	}
}
