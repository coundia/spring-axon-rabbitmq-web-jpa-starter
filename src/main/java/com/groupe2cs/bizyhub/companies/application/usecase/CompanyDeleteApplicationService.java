package com.groupe2cs.bizyhub.companies.application.usecase;

import com.groupe2cs.bizyhub.companies.application.command.DeleteCompanyCommand;
import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyId;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

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
