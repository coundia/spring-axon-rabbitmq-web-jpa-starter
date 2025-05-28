package com.groupe2cs.bizyhub.notifications.application.usecase;

import com.groupe2cs.bizyhub.notifications.application.query.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.notifications.application.command.*;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.notifications.application.dto.*;
import com.groupe2cs.bizyhub.notifications.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteNotification(NotificationId idVo, MetaRequest metaRequest) {

DeleteNotificationCommand command = new DeleteNotificationCommand(idVo);
commandGateway.sendAndWait(command);
}
}
