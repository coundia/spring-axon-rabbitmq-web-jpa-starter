package com.groupe2cs.bizyhub.notifications.application.queryHandler;

import com.groupe2cs.bizyhub.notifications.application.dto.NotificationResponse;
import com.groupe2cs.bizyhub.notifications.application.mapper.NotificationMapper;
import com.groupe2cs.bizyhub.notifications.application.query.FindByNotificationMessageQuery;
import com.groupe2cs.bizyhub.notifications.infrastructure.entity.Notification;
import com.groupe2cs.bizyhub.notifications.infrastructure.repository.NotificationRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByNotificationMessageHandler {

	private final NotificationRepository repository;

	@QueryHandler
	public List<NotificationResponse> handle(FindByNotificationMessageQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Notification> entities = null;
		String value = query.getMessage().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByMessageAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByMessageAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(NotificationMapper::toResponse)
				.toList();
	}


}
