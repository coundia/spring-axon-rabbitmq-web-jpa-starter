package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserUsernameQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByUserUsernameHandler {

	private final UserRepository repository;

	@QueryHandler
	public List<UserResponse> handle(FindByUserUsernameQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

		String value = query.getUsername().value();
		List<CustomUser> entities = repository.findByUsernameAndCreatedById(value, metaRequest.getUserId());
		return entities.stream()
				.map(UserMapper::toResponse)
				.toList();
	}


}
