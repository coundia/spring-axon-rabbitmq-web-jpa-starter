package com.groupe2cs.bizyhub.message.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.message.application.dto.*;
import com.groupe2cs.bizyhub.message.infrastructure.repository.*;
import com.groupe2cs.bizyhub.message.application.query.*;
import com.groupe2cs.bizyhub.message.infrastructure.entity.*;
import com.groupe2cs.bizyhub.message.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


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

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all Messages");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{

log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);


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
