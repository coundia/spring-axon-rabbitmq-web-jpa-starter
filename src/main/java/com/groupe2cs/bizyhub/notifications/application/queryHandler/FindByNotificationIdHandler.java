package com.groupe2cs.bizyhub.notifications.application.queryHandler;

import com.groupe2cs.bizyhub.notifications.application.dto.NotificationResponse;
import com.groupe2cs.bizyhub.notifications.application.mapper.NotificationMapper;
import com.groupe2cs.bizyhub.notifications.application.query.FindByNotificationIdQuery;
import com.groupe2cs.bizyhub.notifications.infrastructure.entity.Notification;
import com.groupe2cs.bizyhub.notifications.infrastructure.repository.NotificationRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FindByNotificationIdHandler {

	private final NotificationRepository repository;

	@QueryHandler

	public NotificationResponse handle(FindByNotificationIdQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		Notification entity = null;

		String value = query.getId().value();

		if (metaRequest.isAdmin()) {
			entity = repository.findByIdAndTenantId(value, metaRequest.getTenantId())
					.stream()
					.findFirst()
					.orElse(null);
		} else {
			entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
					.stream()
					.findFirst()
					.orElse(null);
		}

		if (entity == null) {
			return null;
		}
		return NotificationMapper.toResponse(entity);
	}

}
