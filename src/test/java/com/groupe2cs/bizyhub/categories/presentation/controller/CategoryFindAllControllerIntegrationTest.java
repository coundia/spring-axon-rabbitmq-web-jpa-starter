package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.categories.application.command.CreateCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryPagedResponse;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class CategoryFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void it_should_return_only_user_categorys_for_normal_user() throws Exception {

		List<CreateCategoryCommand> userCommands =
				CategoryFixtures.randomManyViaCommand(commandGateway, 3, login("user", "user"));
		userCommands.forEach(cmd ->
				CategoryFixtures.byIdWaitExist(categoryRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<CategoryPagedResponse> response = this.getForEntity(
				"/v1/queries/categorys?page=0&limit=1000000",
				CategoryPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<CategoryResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(CategoryResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_categorys_for_admin() throws Exception {

		List<CreateCategoryCommand> userCommands =
				CategoryFixtures.randomManyViaCommand(commandGateway, 5, login("user", "user"));
		userCommands.forEach(cmd ->
				CategoryFixtures.byIdWaitExist(categoryRepository, cmd.getId().value())
		);


		List<CreateCategoryCommand> adminCommands =
				CategoryFixtures.randomManyViaCommand(commandGateway, 5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				CategoryFixtures.byIdWaitExist(categoryRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<CategoryPagedResponse> response = this.getForEntity(
				"/v1/queries/categorys?page=0&limit=1000000",
				CategoryPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<CategoryResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(CategoryResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
