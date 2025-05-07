package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public SaleResponse updateSale(SaleId id,SaleRequest request,
MetaRequest metaRequest
){

UpdateSaleCommand command = SaleMapper.toUpdateCommand(
id,
request
);

if(metaRequest.getTenantId() != null) {
	//command.setTenant(SaleTenant.create(metaRequest.getTenantId()));
}

commandGateway.sendAndWait(command);

return SaleMapper.toResponse(command);
}

}
