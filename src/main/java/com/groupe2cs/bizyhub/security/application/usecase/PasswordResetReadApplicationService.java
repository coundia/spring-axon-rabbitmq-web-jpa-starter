package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class PasswordResetReadApplicationService {

private final QueryGateway queryGateway;


public PasswordResetPagedResponse findAll(int page, int limit) {

	FindAllPasswordResetQuery query = new FindAllPasswordResetQuery(page, limit);
	CompletableFuture<PasswordResetPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(PasswordResetPagedResponse.class));
	return future.join();
}


public PasswordResetResponse findByPasswordResetId(PasswordResetId value) {

	FindByPasswordResetIdQuery query = new FindByPasswordResetIdQuery(value);
	CompletableFuture<PasswordResetResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(PasswordResetResponse.class));
	return future.join();
}


public List<PasswordResetResponse> findByPasswordResetToken(PasswordResetToken value) {

	FindByPasswordResetTokenQuery query = new FindByPasswordResetTokenQuery(value);
	CompletableFuture<List<PasswordResetResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(PasswordResetResponse.class));
	return future.join();
}
public List<PasswordResetResponse> findByPasswordResetUsername(PasswordResetUsername value) {

	FindByPasswordResetUsernameQuery query = new FindByPasswordResetUsernameQuery(value);
	CompletableFuture<List<PasswordResetResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(PasswordResetResponse.class));
	return future.join();
}
public List<PasswordResetResponse> findByPasswordResetExpiration(PasswordResetExpiration value) {

	FindByPasswordResetExpirationQuery query = new FindByPasswordResetExpirationQuery(value);
	CompletableFuture<List<PasswordResetResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(PasswordResetResponse.class));
	return future.join();
}
public List<PasswordResetResponse> findByPasswordResetCreatedBy(PasswordResetCreatedBy value) {

	FindByPasswordResetCreatedByQuery query = new FindByPasswordResetCreatedByQuery(value);
	CompletableFuture<List<PasswordResetResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(PasswordResetResponse.class));
	return future.join();
}
public List<PasswordResetResponse> findByPasswordResetTenant(PasswordResetTenant value) {

	FindByPasswordResetTenantQuery query = new FindByPasswordResetTenantQuery(value);
	CompletableFuture<List<PasswordResetResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(PasswordResetResponse.class));
	return future.join();
}

}
