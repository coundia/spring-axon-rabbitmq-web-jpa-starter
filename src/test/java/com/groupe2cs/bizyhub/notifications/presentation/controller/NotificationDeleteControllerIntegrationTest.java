package com.groupe2cs.bizyhub.notifications.presentation.controller;

import com.groupe2cs.bizyhub.notifications.infrastructure.entity.Notification;
import com.groupe2cs.bizyhub.notifications.infrastructure.entity.NotificationFixtures;
import com.groupe2cs.bizyhub.notifications.infrastructure.repository.NotificationRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_notification() {
		String existingId = NotificationFixtures.randomOneViaCommand(commandGateway, notificationRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		NotificationFixtures.byIdWaitExist(notificationRepository, existingId);

		String uri = "/v1/commands/notification/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Notification found = NotificationFixtures.byIdWaitNotExist(notificationRepository, existingId);
		assertThat(found).isNull();
	}
}
