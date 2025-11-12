package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.categories.application.command.CreateCategoryCommand;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_category() {

		String existingId = CategoryFixtures.randomOneViaCommand(
				commandGateway, categoryRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		).getId().value();

		CreateCategoryCommand updated = CategoryFixtures.randomOneViaCommand(
				commandGatewayUpdate, categoryRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		);

		CategoryFixtures.byIdWaitExist(categoryRepository, existingId);
		CategoryFixtures.byIdWaitExist(categoryRepository, updated.getId().value());

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("code", UUID.randomUUID().toString());
		body.add("name", UUID.randomUUID().toString());
		body.add("remoteId", UUID.randomUUID().toString());
		body.add("localId", UUID.randomUUID().toString());
		body.add("account", UUID.randomUUID().toString());
		body.add("status", UUID.randomUUID().toString());
		body.add("isPublic", false);
		body.add("description", UUID.randomUUID().toString());
		body.add("typeEntry", UUID.randomUUID().toString());
		body.add("version", 47);
		body.add("syncAt", java.time.Instant.now().plusSeconds(3600));

		HttpHeaders multipartHeaders = new HttpHeaders();
		multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

		String uri = "/api/v1/commands/category/" + existingId;
		ResponseEntity<String> response = testRestTemplate.exchange(
				uri,
				HttpMethod.PUT,
				requestEntity,
				String.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
