package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
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


public RolePermissionPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllRolePermissionQuery query = new FindAllRolePermissionQuery(page, limit,metaRequest);
	CompletableFuture<RolePermissionPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RolePermissionPagedResponse.class));
	return future.join();
}


public RolePermissionResponse findByRolePermissionId(RolePermissionId value, MetaRequest metaRequest) {

	FindByRolePermissionIdQuery query = new FindByRolePermissionIdQuery(value,metaRequest);
	CompletableFuture<RolePermissionResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RolePermissionResponse.class));
	return future.join();
}


public List<RolePermissionResponse> findByRolePermissionRole(
	RolePermissionRole value,
	MetaRequest metaRequest
	) {

	FindByRolePermissionRoleQuery query = new FindByRolePermissionRoleQuery(value,metaRequest);
	CompletableFuture<List<RolePermissionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RolePermissionResponse.class));
	return future.join();
}
public List<RolePermissionResponse> findByRolePermissionPermission(
	RolePermissionPermission value,
	MetaRequest metaRequest
	) {

	FindByRolePermissionPermissionQuery query = new FindByRolePermissionPermissionQuery(value,metaRequest);
	CompletableFuture<List<RolePermissionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RolePermissionResponse.class));
	return future.join();
}
public List<RolePermissionResponse> findByRolePermissionCreatedBy(
	RolePermissionCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByRolePermissionCreatedByQuery query = new FindByRolePermissionCreatedByQuery(value,metaRequest);
	CompletableFuture<List<RolePermissionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RolePermissionResponse.class));
	return future.join();
}
public List<RolePermissionResponse> findByRolePermissionTenant(
	RolePermissionTenant value,
	MetaRequest metaRequest
	) {

	FindByRolePermissionTenantQuery query = new FindByRolePermissionTenantQuery(value,metaRequest);
	CompletableFuture<List<RolePermissionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RolePermissionResponse.class));
	return future.join();
}

}
