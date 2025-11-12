package com.groupe2cs.bizyhub.message.application.queryHandler;

import com.groupe2cs.bizyhub.message.application.dto.MessagePagedResponse;
import com.groupe2cs.bizyhub.message.application.dto.MessageResponse;
import com.groupe2cs.bizyhub.message.application.mapper.MessageMapper;
import com.groupe2cs.bizyhub.message.application.query.FindAllMessageQuery;
import com.groupe2cs.bizyhub.message.infrastructure.entity.Message;
import com.groupe2cs.bizyhub.message.infrastructure.repository.MessageRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllMessageQueryHandler {

	private final MessageRepository repository;

	public FindAllMessageQueryHandler(MessageRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public MessagePagedResponse handle(FindAllMessageQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Message> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Messages");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<MessageResponse> responses = pages.stream()
				.map(MessageMapper::toResponse)
				.toList();

		return MessagePagedResponse.from(
				pages,
				responses
		);
	}
}
