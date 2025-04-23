package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.dto.RolePagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.query.FindAllRoleQuery;
import com.groupe2cs.bizyhub.security.application.query.FindByRoleIdQuery;
import com.groupe2cs.bizyhub.security.application.query.FindByRoleNameQuery;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleName;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class RoleReadApplicationService {

	private final QueryGateway queryGateway;


	public RolePagedResponse findAll(int page, int limit) {

		FindAllRoleQuery query = new FindAllRoleQuery(page, limit);
		CompletableFuture<RolePagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RolePagedResponse.class));
		return future.join();
	}


	public RoleResponse findByRoleId(RoleId value) {

		FindByRoleIdQuery query = new FindByRoleIdQuery(value);
		CompletableFuture<RoleResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RoleResponse.class));
		return future.join();
	}


	public List<RoleResponse> findByRoleName(RoleName value) {

		FindByRoleNameQuery query = new FindByRoleNameQuery(value);
		CompletableFuture<List<RoleResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RoleResponse.class));
		return future.join();
	}

}
