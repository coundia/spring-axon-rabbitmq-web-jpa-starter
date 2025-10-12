package com.groupe2cs.bizyhub.companies.application.usecase;

import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import com.groupe2cs.bizyhub.companies.application.command.*;
import com.groupe2cs.bizyhub.companies.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.companies.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyDeleteApplicationService {
	private final UserValidationService userValidationService;
	private final CommandGateway commandGateway;

	public void deleteCompany(CompanyId idVo, MetaRequest metaRequest) {
		userValidationService.shouldBePremiumUser(metaRequest.getUserId());
		DeleteCompanyCommand command = new DeleteCompanyCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
