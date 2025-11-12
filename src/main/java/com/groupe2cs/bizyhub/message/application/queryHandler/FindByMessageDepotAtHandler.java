package com.groupe2cs.bizyhub.message.application.queryHandler;

import com.groupe2cs.bizyhub.message.application.dto.MessageResponse;
import com.groupe2cs.bizyhub.message.application.mapper.MessageMapper;
import com.groupe2cs.bizyhub.message.application.query.FindByMessageDepotAtQuery;
import com.groupe2cs.bizyhub.message.infrastructure.entity.Message;
import com.groupe2cs.bizyhub.message.infrastructure.repository.MessageRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByMessageDepotAtHandler {

	private final MessageRepository repository;

	@QueryHandler
	public List<MessageResponse> handle(FindByMessageDepotAtQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Message> entities = null;
		java.time.Instant value = query.getDepotAt().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByDepotAtAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByDepotAtAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(MessageMapper::toResponse)
				.toList();
	}


}
