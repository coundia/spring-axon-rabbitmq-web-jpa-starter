package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.products.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private ProductRepository productRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;

@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_update_product() {

	String existingId = ProductFixtures.randomOneViaCommand(
	commandGateway,productRepository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser() ).getId().value();

	CreateProductCommand updated = ProductFixtures.randomOneViaCommand(commandGatewayUpdate,
    productRepository,
            createdByDataRepository,
            tenantDataRepository,
     getCurrentUser());

	ProductFixtures.byIdWaitExist(productRepository, existingId);
	ProductFixtures.byIdWaitExist(productRepository, updated.getId().value());

	ProductRequest requestDTO = new ProductRequest();
	 requestDTO.setName(UUID.randomUUID().toString());
	 requestDTO.setPrice(6516.56);
	 requestDTO.setDetails(UUID.randomUUID().toString());
	 requestDTO.setIsActive(true);
	 requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setReference(UUID.randomUUID().toString());

	String uri = "/v1/commands/product/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
