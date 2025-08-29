package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class RefreshTokenReadApplicationService {

private final QueryGateway queryGateway;


public RefreshTokenPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllRefreshTokenQuery query = new FindAllRefreshTokenQuery(page, limit,metaRequest);
	CompletableFuture<RefreshTokenPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RefreshTokenPagedResponse.class));
	return future.join();
}


public RefreshTokenResponse findByRefreshTokenId(RefreshTokenId value, MetaRequest metaRequest) {

	FindByRefreshTokenIdQuery query = new FindByRefreshTokenIdQuery(value,metaRequest);
	CompletableFuture<RefreshTokenResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(RefreshTokenResponse.class));
	return future.join();
}


public List<RefreshTokenResponse> findByRefreshTokenToken(
	RefreshTokenToken value,
	MetaRequest metaRequest
	) {

	FindByRefreshTokenTokenQuery query = new FindByRefreshTokenTokenQuery(value,metaRequest);
	CompletableFuture<List<RefreshTokenResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RefreshTokenResponse.class));
	return future.join();
}
public List<RefreshTokenResponse> findByRefreshTokenUsername(
	RefreshTokenUsername value,
	MetaRequest metaRequest
	) {

	FindByRefreshTokenUsernameQuery query = new FindByRefreshTokenUsernameQuery(value,metaRequest);
	CompletableFuture<List<RefreshTokenResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RefreshTokenResponse.class));
	return future.join();
}
public List<RefreshTokenResponse> findByRefreshTokenExpiration(
	RefreshTokenExpiration value,
	MetaRequest metaRequest
	) {

	FindByRefreshTokenExpirationQuery query = new FindByRefreshTokenExpirationQuery(value,metaRequest);
	CompletableFuture<List<RefreshTokenResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RefreshTokenResponse.class));
	return future.join();
}
public List<RefreshTokenResponse> findByRefreshTokenCreatedBy(
	RefreshTokenCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByRefreshTokenCreatedByQuery query = new FindByRefreshTokenCreatedByQuery(value,metaRequest);
	CompletableFuture<List<RefreshTokenResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RefreshTokenResponse.class));
	return future.join();
}
public List<RefreshTokenResponse> findByRefreshTokenTenant(
	RefreshTokenTenant value,
	MetaRequest metaRequest
	) {

	FindByRefreshTokenTenantQuery query = new FindByRefreshTokenTenantQuery(value,metaRequest);
	CompletableFuture<List<RefreshTokenResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(RefreshTokenResponse.class));
	return future.join();
}

}
