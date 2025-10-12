package com.groupe2cs.bizyhub.chats.application.queryHandler;

import com.groupe2cs.bizyhub.chats.application.dto.ChatResponse;
import com.groupe2cs.bizyhub.chats.application.mapper.ChatMapper;
import com.groupe2cs.bizyhub.chats.application.query.FindByChatMessagesQuery;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.Chat;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.ChatRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByChatMessagesHandler {

	private final ChatRepository repository;

	@QueryHandler
	public List<ChatResponse> handle(FindByChatMessagesQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Chat> entities = null;
		String value = query.getMessages().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByMessagesAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByMessagesAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(ChatMapper::toResponse)
				.toList();
	}


}
