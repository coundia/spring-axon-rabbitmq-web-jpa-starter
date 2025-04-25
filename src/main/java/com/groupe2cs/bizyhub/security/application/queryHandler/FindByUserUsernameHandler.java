package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserUsernameQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByUserUsernameHandler {

	private final UserRepository repository;

	@QueryHandler

	public UserResponse handle(FindByUserUsernameQuery query) {
		String value = query.getUsername().value();
		User entity = repository.findByUsername(value)
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return UserMapper.toResponse(entity);
	}

}
