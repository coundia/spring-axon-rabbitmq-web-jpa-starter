package com.groupe2cs.bizyhub.notifications.application.usecase;

import com.groupe2cs.bizyhub.notifications.application.mapper.*;
import com.groupe2cs.bizyhub.notifications.application.dto.*;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import com.groupe2cs.bizyhub.notifications.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationCreateApplicationService {
private final CommandGateway commandGateway;

public NotificationResponse createNotification(NotificationRequest request,
MetaRequest metaRequest
){

CreateNotificationCommand command = NotificationMapper.toCommand(
request
);

command.setCreatedBy(NotificationCreatedBy.create(metaRequest.getUserId()));
command.setTenant(NotificationTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return NotificationMapper.toResponse(command);
}


}
