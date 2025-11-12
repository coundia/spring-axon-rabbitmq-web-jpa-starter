package com.groupe2cs.bizyhub.companies.application.usecase;

import com.groupe2cs.bizyhub.companies.application.command.UpdateCompanyCommand;
import com.groupe2cs.bizyhub.companies.application.dto.CompanyRequest;
import com.groupe2cs.bizyhub.companies.application.dto.CompanyResponse;
import com.groupe2cs.bizyhub.companies.application.mapper.CompanyMapper;
import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyCreatedBy;
import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyId;
import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyTenant;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;
	private final UserValidationService userValidationService;

	public CompanyResponse updateCompany(CompanyId id, CompanyRequest request,
										 MetaRequest metaRequest
	) {

		userValidationService.shouldBePremiumUser(metaRequest.getUserId());

		UpdateCompanyCommand command = CompanyMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(CompanyCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(CompanyTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return CompanyMapper.toResponse(command);
	}

}
