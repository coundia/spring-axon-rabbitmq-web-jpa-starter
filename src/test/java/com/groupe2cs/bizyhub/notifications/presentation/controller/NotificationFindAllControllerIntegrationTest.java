package com.groupe2cs.bizyhub.notifications.presentation.controller;

import com.groupe2cs.bizyhub.notifications.application.command.CreateNotificationCommand;
import com.groupe2cs.bizyhub.notifications.application.dto.NotificationPagedResponse;
import com.groupe2cs.bizyhub.notifications.application.dto.NotificationResponse;
import com.groupe2cs.bizyhub.notifications.infrastructure.entity.NotificationFixtures;
import com.groupe2cs.bizyhub.notifications.infrastructure.repository.NotificationRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class NotificationFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_notifications_for_normal_user() throws Exception {

		List<CreateNotificationCommand> userCommands =
				NotificationFixtures.randomManyViaCommand(
						commandGateway, notificationRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				NotificationFixtures.byIdWaitExist(notificationRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<NotificationPagedResponse> response = this.getForEntity(
				"/v1/queries/notifications?page=0&limit=1000000",
				NotificationPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<NotificationResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(NotificationResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_notifications_for_admin() throws Exception {

		List<CreateNotificationCommand> userCommands =
				NotificationFixtures.randomManyViaCommand(
						commandGateway,
						notificationRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				NotificationFixtures.byIdWaitExist(notificationRepository, cmd.getId().value())
		);


		List<CreateNotificationCommand> adminCommands =
				NotificationFixtures.randomManyViaCommand(
						commandGateway, notificationRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				NotificationFixtures.byIdWaitExist(notificationRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<NotificationPagedResponse> response = this.getForEntity(
				"/v1/queries/notifications?page=0&limit=1000000",
				NotificationPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<NotificationResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(NotificationResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
