package com.groupe2cs.bizyhub.balances.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.balances.application.command.*;
import com.groupe2cs.bizyhub.balances.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.balances.application.dto.*;
import com.groupe2cs.bizyhub.balances.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BalanceUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public BalanceResponse updateBalance(BalanceId id,BalanceRequest request,
MetaRequest metaRequest
){

UpdateBalanceCommand command = BalanceMapper.toUpdateCommand(
id,
request
);

if(metaRequest.getTenantId() != null) {
	//command.setTenant(BalanceTenant.create(metaRequest.getTenantId()));
}

commandGateway.sendAndWait(command);

return BalanceMapper.toResponse(command);
}

}
