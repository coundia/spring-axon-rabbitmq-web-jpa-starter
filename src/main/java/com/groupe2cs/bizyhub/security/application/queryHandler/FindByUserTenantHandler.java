package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserTenantQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByUserTenantHandler {

	private final UserRepository repository;

	@QueryHandler
	public List<UserResponse> handle(FindByUserTenantQuery query) {
		String value = query.getTenant().value();
		List<CustomUser> entities = repository.findByTenant(value);
		return entities.stream()
				.map(UserMapper::toResponse)
				.toList();
	}


}
