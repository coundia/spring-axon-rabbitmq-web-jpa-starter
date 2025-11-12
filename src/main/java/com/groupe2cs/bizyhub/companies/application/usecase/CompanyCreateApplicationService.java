package com.groupe2cs.bizyhub.companies.application.usecase;

import com.groupe2cs.bizyhub.companies.application.command.CreateCompanyCommand;
import com.groupe2cs.bizyhub.companies.application.dto.CompanyRequest;
import com.groupe2cs.bizyhub.companies.application.dto.CompanyResponse;
import com.groupe2cs.bizyhub.companies.application.mapper.CompanyMapper;
import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyCreatedBy;
import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyTenant;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyCreateApplicationService {
	private final CommandGateway commandGateway;
	private final UserValidationService userValidationService;

	public CompanyResponse createCompany(CompanyRequest request,
										 MetaRequest metaRequest
	) {
		userValidationService.shouldBePremiumUser(metaRequest.getUserId());
		CreateCompanyCommand command = CompanyMapper.toCommand(
				request
		);

		command.setCreatedBy(CompanyCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(CompanyTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return CompanyMapper.toResponse(command);
	}


}
