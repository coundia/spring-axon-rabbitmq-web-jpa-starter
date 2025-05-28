package com.groupe2cs.bizyhub.notifications.application.usecase;

import com.groupe2cs.bizyhub.notifications.application.query.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.notifications.application.command.*;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.notifications.application.dto.*;
import com.groupe2cs.bizyhub.notifications.application.mapper.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public NotificationResponse updateNotification(NotificationId id,NotificationRequest request,
MetaRequest metaRequest
){

UpdateNotificationCommand command = NotificationMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(NotificationCreatedBy.create(metaRequest.getUserId()));
command.setTenant(NotificationTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return NotificationMapper.toResponse(command);
}

}
