package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllUserQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllUserQueryHandler {

	private final UserRepository repository;

	public FindAllUserQueryHandler(UserRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public UserPagedResponse handle(FindAllUserQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		long totalElements = repository.count();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<CustomUser> pages = null;

		if (metaRequest.isAdmin()) {
			pages = repository.findAll(pageable);
			//pages = repository.findAllByTenantId(pageable, metaRequest.getTenantId());
		} else {
			pages = repository.findByCreatedById(pageable, metaRequest.getUserId());
		}

		List<UserResponse> responses = pages.stream()
				.map(UserMapper::toResponse)
				.toList();

		return UserPagedResponse.from(
				pages,
				responses
		);
	}
}
