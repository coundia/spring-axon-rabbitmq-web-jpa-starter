package com.groupe2cs.bizyhub.notifications.application.queryHandler;

import com.groupe2cs.bizyhub.notifications.application.dto.NotificationResponse;
import com.groupe2cs.bizyhub.notifications.application.mapper.NotificationMapper;
import com.groupe2cs.bizyhub.notifications.application.query.FindByNotificationErrorMessageQuery;
import com.groupe2cs.bizyhub.notifications.infrastructure.entity.Notification;
import com.groupe2cs.bizyhub.notifications.infrastructure.repository.NotificationRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByNotificationErrorMessageHandler {

	private final NotificationRepository repository;

	@QueryHandler
	public List<NotificationResponse> handle(FindByNotificationErrorMessageQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Notification> entities = null;
		String value = query.getErrorMessage().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByErrorMessageAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByErrorMessageAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(NotificationMapper::toResponse)
				.toList();
	}


}
