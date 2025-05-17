package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.categories.application.command.CreateCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryRequest;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
				getCurrentUser()).getId().value();

		CreateCategoryCommand updated = CategoryFixtures.randomOneViaCommand(commandGatewayUpdate,
				categoryRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser());

		CategoryFixtures.byIdWaitExist(categoryRepository, existingId);
		CategoryFixtures.byIdWaitExist(categoryRepository, updated.getId().value());

		CategoryRequest requestDTO = new CategoryRequest();
		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setTypeCategoryRaw(UUID.randomUUID().toString());
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setIsActive(false);
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setReference(UUID.randomUUID().toString());

		String uri = "/v1/commands/category/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
