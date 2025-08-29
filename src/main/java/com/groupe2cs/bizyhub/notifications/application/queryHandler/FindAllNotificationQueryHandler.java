package com.groupe2cs.bizyhub.notifications.application.queryHandler;

import com.groupe2cs.bizyhub.notifications.application.dto.NotificationPagedResponse;
import com.groupe2cs.bizyhub.notifications.application.dto.NotificationResponse;
import com.groupe2cs.bizyhub.notifications.application.mapper.NotificationMapper;
import com.groupe2cs.bizyhub.notifications.application.query.FindAllNotificationQuery;
import com.groupe2cs.bizyhub.notifications.infrastructure.entity.Notification;
import com.groupe2cs.bizyhub.notifications.infrastructure.repository.NotificationRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllNotificationQueryHandler {

	private final NotificationRepository repository;

	public FindAllNotificationQueryHandler(NotificationRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public NotificationPagedResponse handle(FindAllNotificationQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Notification> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Notifications");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<NotificationResponse> responses = pages.stream()
				.map(NotificationMapper::toResponse)
				.toList();

		return NotificationPagedResponse.from(
				pages,
				responses
		);
	}
}
