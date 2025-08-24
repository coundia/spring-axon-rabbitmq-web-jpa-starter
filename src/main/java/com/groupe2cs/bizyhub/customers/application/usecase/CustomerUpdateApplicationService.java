package com.groupe2cs.bizyhub.customers.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.customers.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.customers.application.mapper.*;
import com.groupe2cs.bizyhub.customers.application.query.*;
import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
import com.groupe2cs.bizyhub.customers.application.command.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public CustomerResponse updateCustomer(CustomerId id,CustomerRequest request,
MetaRequest metaRequest
){

UpdateCustomerCommand command = CustomerMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(CustomerCreatedBy.create(metaRequest.getUserId()));
command.setTenant(CustomerTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return CustomerMapper.toResponse(command);
}

}
