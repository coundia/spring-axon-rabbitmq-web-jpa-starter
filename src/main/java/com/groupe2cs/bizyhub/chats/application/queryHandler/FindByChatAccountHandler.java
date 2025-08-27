package com.groupe2cs.bizyhub.chats.application.queryHandler;

import com.groupe2cs.bizyhub.chats.application.mapper.*;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.*;
import com.groupe2cs.bizyhub.chats.application.dto.*;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.*;
import com.groupe2cs.bizyhub.chats.application.query.*;
import com.groupe2cs.bizyhub.chats.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByChatAccountHandler {

private final ChatRepository repository;

@QueryHandler
public List<ChatResponse> handle(FindByChatAccountQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Chat> entities = null;
	 String value = query.getAccount().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByAccountAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByAccountAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(ChatMapper::toResponse)
	.toList();
	}


}
