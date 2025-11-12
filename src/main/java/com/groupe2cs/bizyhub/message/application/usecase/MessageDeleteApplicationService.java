package com.groupe2cs.bizyhub.message.application.usecase;

import com.groupe2cs.bizyhub.message.domain.valueObject.*;
import com.groupe2cs.bizyhub.message.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.message.application.command.*;
import com.groupe2cs.bizyhub.message.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.message.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteMessage(MessageId idVo, MetaRequest metaRequest) {

DeleteMessageCommand command = new DeleteMessageCommand(idVo);
commandGateway.sendAndWait(command);
}
}
