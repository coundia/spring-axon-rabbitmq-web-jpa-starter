package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserIdQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByUserIdHandler {

	private final UserRepository repository;

	@QueryHandler

	public UserResponse handle(FindByUserIdQuery query) {
		String value = query.getId().value();
		CustomUser entity = repository.findById(value)
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return UserMapper.toResponse(entity);
	}

}
