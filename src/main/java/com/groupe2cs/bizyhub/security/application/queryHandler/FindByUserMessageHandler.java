package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByUserMessageHandler {

private final UserRepository repository;

@QueryHandler
public List<UserResponse> handle(FindByUserMessageQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<User> entities = null;
	 String value = query.getMessage().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByMessageAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByMessageAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(UserMapper::toResponse)
	.toList();
	}


}
