package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.presentation.controller.UserFixtures;
import com.groupe2cs.bizyhub.tenant.presentation.controller.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class TenantFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private TenantRepository tenantRepository;

private void waitForTenant(String TenantId) {
long timeout = Duration.ofSeconds(5).toMillis();
long start = System.currentTimeMillis();
while (System.currentTimeMillis() - start < timeout) {
if (tenantRepository.findById(TenantId).isPresent()) {
return;
}
try {
Thread.sleep(100);
} catch (InterruptedException ignored) {
}
}
throw new RuntimeException("Tenant not found after timeout: " + TenantId);
}

@Test
void it_should_be_able_to_get_all_Tenants_as_admin() {
var userId = login("admin", "admin");

//TenantFixtures.deleteAll(tenantRepository);

List<CreateTenantCommand> commands = TenantFixtures
	.randomManyViaCommand(commandGateway, 5, userId);

	commands.forEach(cmd -> waitForTenant(cmd.getId().value()));

	String uri = "/v1/queries/tenants";
	ResponseEntity<TenantPagedResponse> response = this.getForEntity(uri, TenantPagedResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getContent()).hasSizeGreaterThanOrEqualTo(5);
		}

		@Test
		void it_should_only_return_user_Tenants_as_normal_user() {
		var userId = login("user", "user");

		List<CreateTenantCommand> list1 = TenantFixtures.randomManyViaCommand(commandGateway, 3, userId);
			List<CreateTenantCommand> list2 = TenantFixtures.randomManyViaCommand(commandGateway, 2, userId);

				list1.forEach(cmd -> waitForTenant(cmd.getId().value()));
				list2.forEach(cmd -> waitForTenant(cmd.getId().value()));

				String uri = "/v1/queries/tenants";
				ResponseEntity<TenantPagedResponse> response = this.getForEntity(uri, TenantPagedResponse.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody()).isNotNull();
					assertThat(response.getBody().getContent())
					.allSatisfy(Tenant -> assertThat(Tenant.getCreatedBy()).isEqualTo(userId));
					}
					}
