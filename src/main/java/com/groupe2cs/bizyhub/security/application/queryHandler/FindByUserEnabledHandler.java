package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserEnabledQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByUserEnabledHandler {

	private final UserRepository repository;

	@QueryHandler
	public List<UserResponse> handle(FindByUserEnabledQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<User> entities = null;
		Boolean value = query.getEnabled().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByEnabledAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByEnabledAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(UserMapper::toResponse)
				.toList();
	}


}
