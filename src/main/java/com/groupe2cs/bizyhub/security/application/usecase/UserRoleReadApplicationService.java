package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.dto.UserRolePagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.application.query.FindAllUserRoleQuery;
import com.groupe2cs.bizyhub.security.application.query.FindByUserRoleIdQuery;
import com.groupe2cs.bizyhub.security.application.query.FindByUserRoleRoleQuery;
import com.groupe2cs.bizyhub.security.application.query.FindByUserRoleUserQuery;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleRole;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleUser;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class UserRoleReadApplicationService {

	private final QueryGateway queryGateway;


	public UserRolePagedResponse findAll(int page, int limit) {

		FindAllUserRoleQuery query = new FindAllUserRoleQuery(page, limit);
		CompletableFuture<UserRolePagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(UserRolePagedResponse.class));
		return future.join();
	}


	public UserRoleResponse findByUserRoleId(UserRoleId value) {

		FindByUserRoleIdQuery query = new FindByUserRoleIdQuery(value);
		CompletableFuture<UserRoleResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(UserRoleResponse.class));
		return future.join();
	}


	public List<UserRoleResponse> findByUserRoleUser(UserRoleUser value) {

		FindByUserRoleUserQuery query = new FindByUserRoleUserQuery(value);
		CompletableFuture<List<UserRoleResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserRoleResponse.class));
		return future.join();
	}

	public List<UserRoleResponse> findByUserRoleRole(UserRoleRole value) {

		FindByUserRoleRoleQuery query = new FindByUserRoleRoleQuery(value);
		CompletableFuture<List<UserRoleResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserRoleResponse.class));
		return future.join();
	}

}
