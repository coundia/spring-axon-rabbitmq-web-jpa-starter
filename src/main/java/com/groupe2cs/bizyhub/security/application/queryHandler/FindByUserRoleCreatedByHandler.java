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
public class FindByUserRoleCreatedByHandler {

private final UserRoleRepository repository;
@QueryHandler
public List<UserRoleResponse> handle(FindByUserRoleCreatedByQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();

String value = query.getCreatedBy().value();
	List<UserRole> entities = repository.findByCreatedByIdAndCreatedById(value, metaRequest.getUserId());
	return entities.stream()
	.map(UserRoleMapper::toResponse)
	.toList();
	}


}
