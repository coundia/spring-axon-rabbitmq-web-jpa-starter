package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class VerificationCodeDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private VerificationCodeRepository verificationcodeRepository;

@Autowired
private CommandGateway commandGateway;


@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_delete_verificationcode() {
	String existingId = VerificationCodeFixtures.randomOneViaCommand(commandGateway, verificationcodeRepository,
        createdByDataRepository,
        tenantDataRepository,
	getCurrentUser()).getId().value();

	VerificationCodeFixtures.byIdWaitExist(verificationcodeRepository, existingId);

	String uri = "/v1/commands/verificationCode/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	VerificationCode found = VerificationCodeFixtures.byIdWaitNotExist(verificationcodeRepository, existingId);
	assertThat(found).isNull();
	}
}
