package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.dto.RolePagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleName;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class RoleReadApplicationService {

	private final QueryGateway queryGateway;


	public RolePagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

		FindAllRoleQuery query = new FindAllRoleQuery(page, limit, metaRequest);
		CompletableFuture<RolePagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RolePagedResponse.class));
		return future.join();
	}


	public RoleResponse findByRoleId(RoleId value, MetaRequest metaRequest) {

		FindByRoleIdQuery query = new FindByRoleIdQuery(value, metaRequest);
		CompletableFuture<RoleResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RoleResponse.class));
		return future.join();
	}


	public List<RoleResponse> findByRoleName(
			RoleName value,
			MetaRequest metaRequest
	) {

		FindByRoleNameQuery query = new FindByRoleNameQuery(value, metaRequest);
		CompletableFuture<List<RoleResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RoleResponse.class));
		return future.join();
	}

	public List<RoleResponse> findByRoleCreatedBy(
			RoleCreatedBy value,
			MetaRequest metaRequest
	) {

		FindByRoleCreatedByQuery query = new FindByRoleCreatedByQuery(value, metaRequest);
		CompletableFuture<List<RoleResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RoleResponse.class));
		return future.join();
	}

	public List<RoleResponse> findByRoleTenant(
			RoleTenant value,
			MetaRequest metaRequest
	) {

		FindByRoleTenantQuery query = new FindByRoleTenantQuery(value, metaRequest);
		CompletableFuture<List<RoleResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RoleResponse.class));
		return future.join();
	}

}
