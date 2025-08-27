package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ApiKeyReadApplicationService {

private final QueryGateway queryGateway;


public ApiKeyPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllApiKeyQuery query = new FindAllApiKeyQuery(page, limit,metaRequest);
	CompletableFuture<ApiKeyPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ApiKeyPagedResponse.class));
	return future.join();
}


public ApiKeyResponse findByApiKeyId(ApiKeyId value, MetaRequest metaRequest) {

	FindByApiKeyIdQuery query = new FindByApiKeyIdQuery(value,metaRequest);
	CompletableFuture<ApiKeyResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ApiKeyResponse.class));
	return future.join();
}


public List<ApiKeyResponse> findByApiKeyAppKey(
	ApiKeyAppKey value,
	MetaRequest metaRequest
	) {

	FindByApiKeyAppKeyQuery query = new FindByApiKeyAppKeyQuery(value,metaRequest);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}
public List<ApiKeyResponse> findByApiKeyUsername(
	ApiKeyUsername value,
	MetaRequest metaRequest
	) {

	FindByApiKeyUsernameQuery query = new FindByApiKeyUsernameQuery(value,metaRequest);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}
public List<ApiKeyResponse> findByApiKeyActive(
	ApiKeyActive value,
	MetaRequest metaRequest
	) {

	FindByApiKeyActiveQuery query = new FindByApiKeyActiveQuery(value,metaRequest);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}
public List<ApiKeyResponse> findByApiKeyCreatedAt(
	ApiKeyCreatedAt value,
	MetaRequest metaRequest
	) {

	FindByApiKeyCreatedAtQuery query = new FindByApiKeyCreatedAtQuery(value,metaRequest);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}
public List<ApiKeyResponse> findByApiKeyExpiration(
	ApiKeyExpiration value,
	MetaRequest metaRequest
	) {

	FindByApiKeyExpirationQuery query = new FindByApiKeyExpirationQuery(value,metaRequest);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}
public List<ApiKeyResponse> findByApiKeyCreatedBy(
	ApiKeyCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByApiKeyCreatedByQuery query = new FindByApiKeyCreatedByQuery(value,metaRequest);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}
public List<ApiKeyResponse> findByApiKeyTenant(
	ApiKeyTenant value,
	MetaRequest metaRequest
	) {

	FindByApiKeyTenantQuery query = new FindByApiKeyTenantQuery(value,metaRequest);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}

}
