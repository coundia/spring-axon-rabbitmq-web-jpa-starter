package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.application.query.FindByUserIdQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FindByUserIdHandler {

	private final UserRepository repository;

	@QueryHandler

	public UserResponse handle(FindByUserIdQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		User entity = null;

		String value = query.getId().value();

		if (metaRequest.isAdmin()) {
			entity = repository.findByIdAndTenantId(value, metaRequest.getTenantId())
					.stream()
					.findFirst()
					.orElse(null);
		} else {
			entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
					.stream()
					.findFirst()
					.orElse(null);
		}

		if (entity == null) {
			return null;
		}
		return UserMapper.toResponse(entity);
	}

}
