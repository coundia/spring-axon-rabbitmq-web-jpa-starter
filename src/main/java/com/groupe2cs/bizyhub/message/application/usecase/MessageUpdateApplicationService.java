package com.groupe2cs.bizyhub.message.application.usecase;

import com.groupe2cs.bizyhub.message.domain.valueObject.*;
import com.groupe2cs.bizyhub.message.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.message.application.command.*;
import com.groupe2cs.bizyhub.message.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.message.application.mapper.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public MessageResponse updateMessage(MessageId id,MessageRequest request,
MetaRequest metaRequest
){

UpdateMessageCommand command = MessageMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(MessageCreatedBy.create(metaRequest.getUserId()));
command.setTenant(MessageTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return MessageMapper.toResponse(command);
}

}
