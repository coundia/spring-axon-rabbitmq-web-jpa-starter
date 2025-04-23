package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

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


public List<ApiKeyResponse> findByApiKeyKey(ApiKeyKey value) {

	FindByApiKeyKeyQuery query = new FindByApiKeyKeyQuery(value);
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

}
