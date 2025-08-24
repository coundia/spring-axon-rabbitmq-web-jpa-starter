package com.groupe2cs.bizyhub.fileManager.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.fileManager.application.dto.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.fileManager.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_filemanager() {

		FileManagerRequest requestDTO = new FileManagerRequest();

		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setObjectId(UUID.randomUUID().toString());
		requestDTO.setObjectName(UUID.randomUUID().toString());
		requestDTO.setOriginalName(UUID.randomUUID().toString());
		requestDTO.setMimeType(UUID.randomUUID().toString());
		requestDTO.setSize(56820L);
		requestDTO.setPath(UUID.randomUUID().toString());
		requestDTO.setUri(UUID.randomUUID().toString());
		requestDTO.setIsPublic(false);

 		String uri = "/v1/commands/fileManager";
		ResponseEntity<FileManagerResponse> response = this.postForEntity(uri, requestDTO, FileManagerResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getDetails()).isEqualTo(requestDTO.getDetails());
		assertThat(response.getBody().getObjectId()).isEqualTo(requestDTO.getObjectId());
		assertThat(response.getBody().getObjectName()).isEqualTo(requestDTO.getObjectName());
		assertThat(response.getBody().getOriginalName()).isEqualTo(requestDTO.getOriginalName());
		assertThat(response.getBody().getMimeType()).isEqualTo(requestDTO.getMimeType());
		assertThat(response.getBody().getSize()).isEqualTo(requestDTO.getSize());
		assertThat(response.getBody().getPath()).isEqualTo(requestDTO.getPath());
		assertThat(response.getBody().getUri()).isEqualTo(requestDTO.getUri());
		assertThat(response.getBody().getIsPublic()).isEqualTo(requestDTO.getIsPublic());
	}
}
