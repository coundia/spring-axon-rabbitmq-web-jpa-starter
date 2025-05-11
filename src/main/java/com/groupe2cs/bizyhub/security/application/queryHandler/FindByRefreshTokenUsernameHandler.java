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
public class FindByRefreshTokenUsernameHandler {

private final RefreshTokenRepository repository;

@QueryHandler
public List<RefreshTokenResponse> handle(FindByRefreshTokenUsernameQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<RefreshToken> entities = null;
	 String value = query.getUsername().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByUsernameAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByUsernameAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(RefreshTokenMapper::toResponse)
	.toList();
	}


}
