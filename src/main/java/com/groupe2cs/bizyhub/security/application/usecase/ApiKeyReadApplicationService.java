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
public class ApiKeyReadApplicationService {

private final QueryGateway queryGateway;


public ApiKeyPagedResponse findAll(int page, int limit) {

	FindAllApiKeyQuery query = new FindAllApiKeyQuery(page, limit);
	CompletableFuture<ApiKeyPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ApiKeyPagedResponse.class));
	return future.join();
}


public ApiKeyResponse findByApiKeyId(ApiKeyId value) {

	FindByApiKeyIdQuery query = new FindByApiKeyIdQuery(value);
	CompletableFuture<ApiKeyResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ApiKeyResponse.class));
	return future.join();
}


public List<ApiKeyResponse> findByApiKeyAppKey(ApiKeyAppKey value) {

	FindByApiKeyAppKeyQuery query = new FindByApiKeyAppKeyQuery(value);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}
public List<ApiKeyResponse> findByApiKeyUsername(ApiKeyUsername value) {

	FindByApiKeyUsernameQuery query = new FindByApiKeyUsernameQuery(value);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}
public List<ApiKeyResponse> findByApiKeyCreatedAt(ApiKeyCreatedAt value) {

	FindByApiKeyCreatedAtQuery query = new FindByApiKeyCreatedAtQuery(value);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}
public List<ApiKeyResponse> findByApiKeyExpiration(ApiKeyExpiration value) {

	FindByApiKeyExpirationQuery query = new FindByApiKeyExpirationQuery(value);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}
public List<ApiKeyResponse> findByApiKeyCreatedBy(ApiKeyCreatedBy value) {

	FindByApiKeyCreatedByQuery query = new FindByApiKeyCreatedByQuery(value);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}
public List<ApiKeyResponse> findByApiKeyTenant(ApiKeyTenant value) {

	FindByApiKeyTenantQuery query = new FindByApiKeyTenantQuery(value);
	CompletableFuture<List<ApiKeyResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ApiKeyResponse.class));
	return future.join();
}

}
