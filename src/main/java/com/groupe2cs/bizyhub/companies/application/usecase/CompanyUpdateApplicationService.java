package com.groupe2cs.bizyhub.companies.application.usecase;

import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import com.groupe2cs.bizyhub.companies.application.command.*;
import com.groupe2cs.bizyhub.companies.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.companies.application.mapper.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;
	private final UserValidationService userValidationService;

public CompanyResponse updateCompany(CompanyId id,CompanyRequest request,
MetaRequest metaRequest
){

	userValidationService.shouldBePremiumUser(metaRequest.getUserId()) ;

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
