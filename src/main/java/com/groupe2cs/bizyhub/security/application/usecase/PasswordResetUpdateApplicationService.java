package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PasswordResetUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public PasswordResetResponse updatePasswordReset(PasswordResetId id,PasswordResetRequest request,
MetaRequest metaRequest
){

UpdatePasswordResetCommand command = PasswordResetMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(PasswordResetCreatedBy.create(metaRequest.getUserId()));
command.setTenant(PasswordResetTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return PasswordResetMapper.toResponse(command);
}

}
