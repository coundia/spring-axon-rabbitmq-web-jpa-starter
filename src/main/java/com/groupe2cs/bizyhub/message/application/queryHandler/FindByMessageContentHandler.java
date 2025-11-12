package com.groupe2cs.bizyhub.message.application.queryHandler;

import com.groupe2cs.bizyhub.message.application.mapper.*;
import com.groupe2cs.bizyhub.message.domain.valueObject.*;
import com.groupe2cs.bizyhub.message.infrastructure.entity.*;
import com.groupe2cs.bizyhub.message.application.dto.*;
import com.groupe2cs.bizyhub.message.infrastructure.repository.*;
import com.groupe2cs.bizyhub.message.application.query.*;
import com.groupe2cs.bizyhub.message.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByMessageContentHandler {

private final MessageRepository repository;

@QueryHandler
public List<MessageResponse> handle(FindByMessageContentQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Message> entities = null;
	 String value = query.getContent().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByContentAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByContentAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(MessageMapper::toResponse)
	.toList();
	}


}
