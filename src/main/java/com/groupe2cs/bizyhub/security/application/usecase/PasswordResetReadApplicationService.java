package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.security.application.dto.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class PasswordResetReadApplicationService {

private final QueryGateway queryGateway;


public PasswordResetPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllPasswordResetQuery query = new FindAllPasswordResetQuery(page, limit,metaRequest);
	CompletableFuture<PasswordResetPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(PasswordResetPagedResponse.class));
	return future.join();
}


public PasswordResetResponse findByPasswordResetId(PasswordResetId value, MetaRequest metaRequest) {

	FindByPasswordResetIdQuery query = new FindByPasswordResetIdQuery(value,metaRequest);
	CompletableFuture<PasswordResetResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(PasswordResetResponse.class));
	return future.join();
}


public List<PasswordResetResponse> findByPasswordResetToken(
	PasswordResetToken value,
	MetaRequest metaRequest
	) {

	FindByPasswordResetTokenQuery query = new FindByPasswordResetTokenQuery(value,metaRequest);
	CompletableFuture<List<PasswordResetResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(PasswordResetResponse.class));
	return future.join();
}
public List<PasswordResetResponse> findByPasswordResetUsername(
	PasswordResetUsername value,
	MetaRequest metaRequest
	) {

	FindByPasswordResetUsernameQuery query = new FindByPasswordResetUsernameQuery(value,metaRequest);
	CompletableFuture<List<PasswordResetResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(PasswordResetResponse.class));
	return future.join();
}
public List<PasswordResetResponse> findByPasswordResetExpiration(
	PasswordResetExpiration value,
	MetaRequest metaRequest
	) {

	FindByPasswordResetExpirationQuery query = new FindByPasswordResetExpirationQuery(value,metaRequest);
	CompletableFuture<List<PasswordResetResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(PasswordResetResponse.class));
	return future.join();
}
public List<PasswordResetResponse> findByPasswordResetCreatedBy(
	PasswordResetCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByPasswordResetCreatedByQuery query = new FindByPasswordResetCreatedByQuery(value,metaRequest);
	CompletableFuture<List<PasswordResetResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(PasswordResetResponse.class));
	return future.join();
}
public List<PasswordResetResponse> findByPasswordResetTenant(
	PasswordResetTenant value,
	MetaRequest metaRequest
	) {

	FindByPasswordResetTenantQuery query = new FindByPasswordResetTenantQuery(value,metaRequest);
	CompletableFuture<List<PasswordResetResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(PasswordResetResponse.class));
	return future.join();
}

}
