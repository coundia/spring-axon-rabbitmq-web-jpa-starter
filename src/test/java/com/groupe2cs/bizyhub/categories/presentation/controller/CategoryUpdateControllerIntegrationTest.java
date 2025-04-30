package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.categories.application.command.CreateCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryRequest;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
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


	@Test
	void it_should_be_able_to_update_category() {

		String existingId = CategoryFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();
		CreateCategoryCommand updated = CategoryFixtures.randomOneViaCommand(commandGatewayUpdate, getCurrentUser());

		CategoryFixtures.byIdWaitExist(categoryRepository, existingId);
		CategoryFixtures.byIdWaitExist(categoryRepository, updated.getId().value());

		CategoryRequest requestDTO = new CategoryRequest();
		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setTypeCategory(UUID.randomUUID().toString());
		requestDTO.setParentId(UUID.randomUUID().toString());
		requestDTO.setIsDefault(false);
		requestDTO.setIcon(UUID.randomUUID().toString());
		requestDTO.setColorHex(UUID.randomUUID().toString());

		String uri = "/v1/commands/category/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
