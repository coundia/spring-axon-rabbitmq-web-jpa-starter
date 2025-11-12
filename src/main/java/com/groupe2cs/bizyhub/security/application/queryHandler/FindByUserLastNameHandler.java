package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserLastNameQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByUserLastNameHandler {

	private final UserRepository repository;

	@QueryHandler
	public List<UserResponse> handle(FindByUserLastNameQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<User> entities = null;
		String value = query.getLastName().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByLastNameAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByLastNameAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(UserMapper::toResponse)
				.toList();
	}


}
