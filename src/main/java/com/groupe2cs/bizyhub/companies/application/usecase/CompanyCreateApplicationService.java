package com.groupe2cs.bizyhub.companies.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import com.groupe2cs.bizyhub.companies.application.command.*;
import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.companies.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyCreateApplicationService {
private final CommandGateway commandGateway;

public CompanyResponse createCompany(CompanyRequest request,
MetaRequest metaRequest
){

CreateCompanyCommand command = CompanyMapper.toCommand(
request
);

command.setCreatedBy(CompanyCreatedBy.create(metaRequest.getUserId()));
command.setTenant(CompanyTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return CompanyMapper.toResponse(command);
}


}
