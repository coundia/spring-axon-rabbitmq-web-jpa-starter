package com.groupe2cs.bizyhub.stock.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.stock.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class StockLevelCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productVariantDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_stocklevel() {

		StockLevelRequest requestDTO = new StockLevelRequest();

		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setLocalId(UUID.randomUUID().toString());
		requestDTO.setStockOnHand(98);
		requestDTO.setStockAllocated(39);
		requestDTO.setProductVariant(com.groupe2cs.bizyhub.products.infrastructure.entity.ProductFixtures.randomOneViaCommand(commandGateway,productVariantDataRepository, user).getId().value());
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setCompany(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value());

 		String uri = "/v1/commands/stockLevel";
		ResponseEntity<StockLevelResponse> response = this.postForEntity(uri, requestDTO, StockLevelResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getLocalId()).isEqualTo(requestDTO.getLocalId());
		assertThat(response.getBody().getStockOnHand()).isEqualTo(requestDTO.getStockOnHand());
		assertThat(response.getBody().getStockAllocated()).isEqualTo(requestDTO.getStockAllocated());
		assertThat(response.getBody().getProductVariant()).isEqualTo(requestDTO.getProductVariant());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
		assertThat(response.getBody().getCompany()).isEqualTo(requestDTO.getCompany());
	}
}
