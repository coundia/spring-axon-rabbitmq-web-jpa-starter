package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class RolePermissionReadApplicationService {

private final QueryGateway queryGateway;


public RolePermissionPagedResponse findAll(int page, int limit) {

	FindAllRolePermissionQuery query = new FindAllRolePermissionQuery(page, limit);
	CompletableFuture<RolePermissionPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RolePermissionPagedResponse.class));
	return future.join();
}


public RolePermissionResponse findByRolePermissionId(RolePermissionId value) {

	FindByRolePermissionIdQuery query = new FindByRolePermissionIdQuery(value);
	CompletableFuture<RolePermissionResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RolePermissionResponse.class));
	return future.join();
}


public List<RolePermissionResponse> findByRolePermissionRole(RolePermissionRole value) {

	FindByRolePermissionRoleQuery query = new FindByRolePermissionRoleQuery(value);
	CompletableFuture<List<RolePermissionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RolePermissionResponse.class));
	return future.join();
}
public List<RolePermissionResponse> findByRolePermissionPermission(RolePermissionPermission value) {

	FindByRolePermissionPermissionQuery query = new FindByRolePermissionPermissionQuery(value);
	CompletableFuture<List<RolePermissionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RolePermissionResponse.class));
	return future.join();
}
public List<RolePermissionResponse> findByRolePermissionCreatedBy(RolePermissionCreatedBy value) {

	FindByRolePermissionCreatedByQuery query = new FindByRolePermissionCreatedByQuery(value);
	CompletableFuture<List<RolePermissionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RolePermissionResponse.class));
	return future.join();
}
public List<RolePermissionResponse> findByRolePermissionTenant(RolePermissionTenant value) {

	FindByRolePermissionTenantQuery query = new FindByRolePermissionTenantQuery(value);
	CompletableFuture<List<RolePermissionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RolePermissionResponse.class));
	return future.join();
}

}
