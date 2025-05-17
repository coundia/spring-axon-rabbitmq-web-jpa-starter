package com.groupe2cs.bizyhub.security.application.queryHandler;

import com.groupe2cs.bizyhub.security.application.dto.UserPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserMapper;
import com.groupe2cs.bizyhub.security.application.query.FindAllUserQuery;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
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

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<User> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Users");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {
			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);
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
