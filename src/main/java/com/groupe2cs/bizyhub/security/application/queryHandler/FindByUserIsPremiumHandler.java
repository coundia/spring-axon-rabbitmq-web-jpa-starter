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
public class FindByUserIsPremiumHandler {

private final UserRepository repository;

@QueryHandler
public List<UserResponse> handle(FindByUserIsPremiumQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<User> entities = null;
	 Boolean value = query.getIsPremium().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByIsPremiumAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByIsPremiumAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(UserMapper::toResponse)
	.toList();
	}


}
