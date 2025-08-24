package com.groupe2cs.bizyhub.chats.application.usecase;

import com.groupe2cs.bizyhub.chats.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.chats.application.query.*;
import com.groupe2cs.bizyhub.chats.application.dto.*;
import com.groupe2cs.bizyhub.chats.application.mapper.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;

public ChatResponse updateChat(
ChatId id, List<MultipartFile> filesMultipartFile, 
		String messages,
		String responsesJson,
		String responses,
		String state,
		java.time.Instant syncAt,
		String remoteId,
		String localId,
		String account,
		java.time.Instant dateTransaction
,
MetaRequest metaRequest
) {

UpdateChatCommand command = ChatMapper.toUpdateCommand(
    id,
    new ChatMessages(messages),
     new ChatResponsesJson(responsesJson),
     new ChatResponses(responses),
     new ChatState(state),
     new ChatSyncAt(syncAt),
     new ChatRemoteId(remoteId),
     new ChatLocalId(localId),
     new ChatAccount(account),
     new ChatDateTransaction(dateTransaction)  
);

    command.setCreatedBy(ChatCreatedBy.create(metaRequest.getUserId()));
    command.setTenant(ChatTenant.create(metaRequest.getTenantId()));

    commandGateway.sendAndWait(command);

    metaRequest.setObjectId(command.getId().value());
    metaRequest.setObjectName("chat");
    fileStorageService.storeFile(filesMultipartFile, metaRequest);

    return ChatMapper.toResponse(command);
}


}
