package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserRolePagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserRoleMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllUserRoleQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllUserRoleQueryHandler {

	private final UserRoleRepository repository;

	public FindAllUserRoleQueryHandler(UserRoleRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public UserRolePagedResponse handle(FindAllUserRoleQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;

		long totalElements = repository.count();

		PageRequest pageable = PageRequest.of(offset / limit, limit);

		Page<UserRole> pages = repository.findAll(pageable);

		List<UserRoleResponse> responses = pages.stream()
				.map(UserRoleMapper::toResponse)
				.toList();

		return UserRolePagedResponse.from(
				pages,
				responses
		);
	}
}
