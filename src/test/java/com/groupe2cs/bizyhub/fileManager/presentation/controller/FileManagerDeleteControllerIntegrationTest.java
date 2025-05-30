package com.groupe2cs.bizyhub.fileManager.presentation.controller;

import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.FileManager;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.FileManagerFixtures;
import com.groupe2cs.bizyhub.fileManager.infrastructure.repository.FileManagerRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private FileManagerRepository filemanagerRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_filemanager() {
		String existingId = FileManagerFixtures.randomOneViaCommand(commandGateway, filemanagerRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		FileManagerFixtures.byIdWaitExist(filemanagerRepository, existingId);

		String uri = "/v1/commands/fileManager/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		FileManager found = FileManagerFixtures.byIdWaitNotExist(filemanagerRepository, existingId);
		assertThat(found).isNull();
	}
}
