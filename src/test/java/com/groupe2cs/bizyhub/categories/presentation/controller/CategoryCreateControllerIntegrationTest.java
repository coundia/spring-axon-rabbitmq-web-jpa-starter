package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.categories.application.dto.CategoryRequest;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_add_category() {

		CategoryRequest requestDTO = new CategoryRequest();

		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setTypeCategory(UUID.randomUUID().toString());
		requestDTO.setParentId(UUID.randomUUID().toString());
		requestDTO.setIsDefault(false);
		requestDTO.setIcon(UUID.randomUUID().toString());
		requestDTO.setColorHex(UUID.randomUUID().toString());

		String uri = "/v1/commands/category";
		ResponseEntity<CategoryResponse> response = this.postForEntity(uri, requestDTO, CategoryResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getTypeCategory()).isEqualTo(requestDTO.getTypeCategory());
		assertThat(response.getBody().getParentId()).isEqualTo(requestDTO.getParentId());
		assertThat(response.getBody().getIsDefault()).isEqualTo(requestDTO.getIsDefault());
		assertThat(response.getBody().getIcon()).isEqualTo(requestDTO.getIcon());
		assertThat(response.getBody().getColorHex()).isEqualTo(requestDTO.getColorHex());
	}
}
