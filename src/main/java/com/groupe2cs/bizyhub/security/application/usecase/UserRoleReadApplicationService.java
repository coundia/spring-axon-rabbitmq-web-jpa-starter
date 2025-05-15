package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class UserRoleReadApplicationService {

private final QueryGateway queryGateway;


public UserRolePagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllUserRoleQuery query = new FindAllUserRoleQuery(page, limit,metaRequest);
	CompletableFuture<UserRolePagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(UserRolePagedResponse.class));
	return future.join();
}


public UserRoleResponse findByUserRoleId(UserRoleId value, MetaRequest metaRequest) {

	FindByUserRoleIdQuery query = new FindByUserRoleIdQuery(value,metaRequest);
	CompletableFuture<UserRoleResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(UserRoleResponse.class));
	return future.join();
}


public List<UserRoleResponse> findByUserRoleUser(
	UserRoleUser value,
	MetaRequest metaRequest
	) {

	FindByUserRoleUserQuery query = new FindByUserRoleUserQuery(value,metaRequest);
	CompletableFuture<List<UserRoleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserRoleResponse.class));
	return future.join();
}
public List<UserRoleResponse> findByUserRoleRole(
	UserRoleRole value,
	MetaRequest metaRequest
	) {

	FindByUserRoleRoleQuery query = new FindByUserRoleRoleQuery(value,metaRequest);
	CompletableFuture<List<UserRoleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserRoleResponse.class));
	return future.join();
}
public List<UserRoleResponse> findByUserRoleCreatedBy(
	UserRoleCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByUserRoleCreatedByQuery query = new FindByUserRoleCreatedByQuery(value,metaRequest);
	CompletableFuture<List<UserRoleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserRoleResponse.class));
	return future.join();
}
public List<UserRoleResponse> findByUserRoleTenant(
	UserRoleTenant value,
	MetaRequest metaRequest
	) {

	FindByUserRoleTenantQuery query = new FindByUserRoleTenantQuery(value,metaRequest);
	CompletableFuture<List<UserRoleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(UserRoleResponse.class));
	return future.join();
}

}
