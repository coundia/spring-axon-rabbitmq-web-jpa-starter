package com.groupe2cs.bizyhub.notifications.application.queryHandler;

import com.groupe2cs.bizyhub.notifications.application.mapper.*;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import com.groupe2cs.bizyhub.notifications.infrastructure.entity.*;
import com.groupe2cs.bizyhub.notifications.application.dto.*;
import com.groupe2cs.bizyhub.notifications.infrastructure.repository.*;
import com.groupe2cs.bizyhub.notifications.application.query.*;
import com.groupe2cs.bizyhub.notifications.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByNotificationRemoteIdHandler {

private final NotificationRepository repository;

@QueryHandler
public List<NotificationResponse> handle(FindByNotificationRemoteIdQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Notification> entities = null;
	 String value = query.getRemoteId().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByRemoteIdAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByRemoteIdAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(NotificationMapper::toResponse)
	.toList();
	}


}
