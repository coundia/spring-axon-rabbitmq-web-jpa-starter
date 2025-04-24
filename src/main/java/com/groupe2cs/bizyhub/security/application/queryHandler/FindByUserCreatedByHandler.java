package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserCreatedByQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByUserCreatedByHandler {

	private final UserRepository repository;

	@QueryHandler
	public List<UserResponse> handle(FindByUserCreatedByQuery query) {
		String value = query.getCreatedBy().value();
		List<User> entities = repository.findByCreatedBy(value);
		return entities.stream()
				.map(UserMapper::toResponse)
				.toList();
	}


}
