package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class VerificationCodeReadApplicationService {

private final QueryGateway queryGateway;


public VerificationCodePagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllVerificationCodeQuery query = new FindAllVerificationCodeQuery(page, limit,metaRequest);
	CompletableFuture<VerificationCodePagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(VerificationCodePagedResponse.class));
	return future.join();
}


public VerificationCodeResponse findByVerificationCodeId(VerificationCodeId value, MetaRequest metaRequest) {

	FindByVerificationCodeIdQuery query = new FindByVerificationCodeIdQuery(value,metaRequest);
	CompletableFuture<VerificationCodeResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(VerificationCodeResponse.class));
	return future.join();
}


public List<VerificationCodeResponse> findByVerificationCodeToken(
	VerificationCodeToken value,
	MetaRequest metaRequest
	) {

	FindByVerificationCodeTokenQuery query = new FindByVerificationCodeTokenQuery(value,metaRequest);
	CompletableFuture<List<VerificationCodeResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(VerificationCodeResponse.class));
	return future.join();
}
public List<VerificationCodeResponse> findByVerificationCodeUsername(
	VerificationCodeUsername value,
	MetaRequest metaRequest
	) {

	FindByVerificationCodeUsernameQuery query = new FindByVerificationCodeUsernameQuery(value,metaRequest);
	CompletableFuture<List<VerificationCodeResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(VerificationCodeResponse.class));
	return future.join();
}
public List<VerificationCodeResponse> findByVerificationCodePhone(
	VerificationCodePhone value,
	MetaRequest metaRequest
	) {

	FindByVerificationCodePhoneQuery query = new FindByVerificationCodePhoneQuery(value,metaRequest);
	CompletableFuture<List<VerificationCodeResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(VerificationCodeResponse.class));
	return future.join();
}
public List<VerificationCodeResponse> findByVerificationCodeEmail(
	VerificationCodeEmail value,
	MetaRequest metaRequest
	) {

	FindByVerificationCodeEmailQuery query = new FindByVerificationCodeEmailQuery(value,metaRequest);
	CompletableFuture<List<VerificationCodeResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(VerificationCodeResponse.class));
	return future.join();
}
public List<VerificationCodeResponse> findByVerificationCodeCode(
	VerificationCodeCode value,
	MetaRequest metaRequest
	) {

	FindByVerificationCodeCodeQuery query = new FindByVerificationCodeCodeQuery(value,metaRequest);
	CompletableFuture<List<VerificationCodeResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(VerificationCodeResponse.class));
	return future.join();
}
public List<VerificationCodeResponse> findByVerificationCodeStatus(
	VerificationCodeStatus value,
	MetaRequest metaRequest
	) {

	FindByVerificationCodeStatusQuery query = new FindByVerificationCodeStatusQuery(value,metaRequest);
	CompletableFuture<List<VerificationCodeResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(VerificationCodeResponse.class));
	return future.join();
}
public List<VerificationCodeResponse> findByVerificationCodeSource(
	VerificationCodeSource value,
	MetaRequest metaRequest
	) {

	FindByVerificationCodeSourceQuery query = new FindByVerificationCodeSourceQuery(value,metaRequest);
	CompletableFuture<List<VerificationCodeResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(VerificationCodeResponse.class));
	return future.join();
}
public List<VerificationCodeResponse> findByVerificationCodeExpiration(
	VerificationCodeExpiration value,
	MetaRequest metaRequest
	) {

	FindByVerificationCodeExpirationQuery query = new FindByVerificationCodeExpirationQuery(value,metaRequest);
	CompletableFuture<List<VerificationCodeResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(VerificationCodeResponse.class));
	return future.join();
}
public List<VerificationCodeResponse> findByVerificationCodeCreatedBy(
	VerificationCodeCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByVerificationCodeCreatedByQuery query = new FindByVerificationCodeCreatedByQuery(value,metaRequest);
	CompletableFuture<List<VerificationCodeResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(VerificationCodeResponse.class));
	return future.join();
}
public List<VerificationCodeResponse> findByVerificationCodeTenant(
	VerificationCodeTenant value,
	MetaRequest metaRequest
	) {

	FindByVerificationCodeTenantQuery query = new FindByVerificationCodeTenantQuery(value,metaRequest);
	CompletableFuture<List<VerificationCodeResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(VerificationCodeResponse.class));
	return future.join();
}

}
