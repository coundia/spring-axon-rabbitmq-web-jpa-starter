package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VerificationCodeUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public VerificationCodeResponse updateVerificationCode(VerificationCodeId id,VerificationCodeRequest request,
MetaRequest metaRequest
){

UpdateVerificationCodeCommand command = VerificationCodeMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(VerificationCodeCreatedBy.create(metaRequest.getUserId()));
command.setTenant(VerificationCodeTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return VerificationCodeMapper.toResponse(command);
}

}
