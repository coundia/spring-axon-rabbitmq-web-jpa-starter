package com.groupe2cs.bizyhub.chats.application.usecase;

import com.groupe2cs.bizyhub.chats.application.mapper.*;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.chats.application.command.*;
import com.groupe2cs.bizyhub.chats.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatCreateApplicationService {
private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;

public ChatResponse createChat(
List<MultipartFile> files,
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

    ChatRequest request = new ChatRequest(
        messages,
        responsesJson,
        responses,
        state,
        syncAt,
        remoteId,
        localId,
        account,
        dateTransaction
    );

CreateChatCommand command = ChatMapper.toCommand(
request
);

command.setCreatedBy(ChatCreatedBy.create(metaRequest.getUserId()));
command.setTenant(ChatTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
metaRequest.setObjectId(command.getId().value());
metaRequest.setObjectName("chat");
ChatFiles.create(
    fileStorageService.storeFile(files, metaRequest)
    );
return ChatMapper.toResponse(command);
}



}
