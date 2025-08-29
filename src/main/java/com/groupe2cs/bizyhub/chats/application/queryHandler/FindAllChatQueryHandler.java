package com.groupe2cs.bizyhub.chats.application.queryHandler;

import com.groupe2cs.bizyhub.chats.application.dto.ChatPagedResponse;
import com.groupe2cs.bizyhub.chats.application.dto.ChatResponse;
import com.groupe2cs.bizyhub.chats.application.mapper.ChatMapper;
import com.groupe2cs.bizyhub.chats.application.query.FindAllChatQuery;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.Chat;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.ChatRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllChatQueryHandler {

	private final ChatRepository repository;

	public FindAllChatQueryHandler(ChatRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public ChatPagedResponse handle(FindAllChatQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Chat> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Chats");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<ChatResponse> responses = pages.stream()
				.map(ChatMapper::toResponse)
				.toList();

		return ChatPagedResponse.from(
				pages,
				responses
		);
	}
}
