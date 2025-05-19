package com.groupe2cs.bizyhub.notifications.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.notifications.application.dto.*;
import com.groupe2cs.bizyhub.notifications.infrastructure.entity.*;
import com.groupe2cs.bizyhub.notifications.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.notifications.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class NotificationUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private NotificationRepository notificationRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;

@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_update_notification() {

	String existingId = NotificationFixtures.randomOneViaCommand(
	commandGateway,notificationRepository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser() ).getId().value();

	CreateNotificationCommand updated = NotificationFixtures.randomOneViaCommand(commandGatewayUpdate,
    notificationRepository,
            createdByDataRepository,
            tenantDataRepository,
     getCurrentUser());

	NotificationFixtures.byIdWaitExist(notificationRepository, existingId);
	NotificationFixtures.byIdWaitExist(notificationRepository, updated.getId().value());

	NotificationRequest requestDTO = new NotificationRequest();
	 requestDTO.setDeviceToken(UUID.randomUUID().toString());
	 requestDTO.setTitle(UUID.randomUUID().toString());
	 requestDTO.setMessage(UUID.randomUUID().toString());
	 requestDTO.setStatus(UUID.randomUUID().toString());
	 requestDTO.setReserved(UUID.randomUUID().toString());
	 requestDTO.setErrorMessage(UUID.randomUUID().toString());
	 requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setReference(UUID.randomUUID().toString());

	String uri = "/v1/commands/notification/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
