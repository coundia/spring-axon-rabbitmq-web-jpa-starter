package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sales.application.command.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleUserUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public SaleUserResponse updateSaleUser(SaleUserId id,SaleUserRequest request,
MetaRequest metaRequest
){

UpdateSaleUserCommand command = SaleUserMapper.toUpdateCommand(
id,
request
);

if(metaRequest.getTenantId() != null) {
	//command.setTenant(SaleUserTenant.create(metaRequest.getTenantId()));
}

commandGateway.sendAndWait(command);

return SaleUserMapper.toResponse(command);
}

}
