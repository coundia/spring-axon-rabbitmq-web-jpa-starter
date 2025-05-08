package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.application.query.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class SaleUserReadApplicationService {

private final QueryGateway queryGateway;


public SaleUserPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllSaleUserQuery query = new FindAllSaleUserQuery(page, limit,metaRequest);
	CompletableFuture<SaleUserPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SaleUserPagedResponse.class));
	return future.join();
}


public SaleUserResponse findBySaleUserId(SaleUserId value, MetaRequest metaRequest) {

	FindBySaleUserIdQuery query = new FindBySaleUserIdQuery(value,metaRequest);
	CompletableFuture<SaleUserResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SaleUserResponse.class));
	return future.join();
}


public List<SaleUserResponse> findBySaleUserName(
	SaleUserName value,
	MetaRequest metaRequest
	) {

	FindBySaleUserNameQuery query = new FindBySaleUserNameQuery(value,metaRequest);
	CompletableFuture<List<SaleUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleUserResponse.class));
	return future.join();
}
public List<SaleUserResponse> findBySaleUserSale(
	SaleUserSale value,
	MetaRequest metaRequest
	) {

	FindBySaleUserSaleQuery query = new FindBySaleUserSaleQuery(value,metaRequest);
	CompletableFuture<List<SaleUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleUserResponse.class));
	return future.join();
}
public List<SaleUserResponse> findBySaleUserUser(
	SaleUserUser value,
	MetaRequest metaRequest
	) {

	FindBySaleUserUserQuery query = new FindBySaleUserUserQuery(value,metaRequest);
	CompletableFuture<List<SaleUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleUserResponse.class));
	return future.join();
}
public List<SaleUserResponse> findBySaleUserUsername(
	SaleUserUsername value,
	MetaRequest metaRequest
	) {

	FindBySaleUserUsernameQuery query = new FindBySaleUserUsernameQuery(value,metaRequest);
	CompletableFuture<List<SaleUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleUserResponse.class));
	return future.join();
}
public List<SaleUserResponse> findBySaleUserDetails(
	SaleUserDetails value,
	MetaRequest metaRequest
	) {

	FindBySaleUserDetailsQuery query = new FindBySaleUserDetailsQuery(value,metaRequest);
	CompletableFuture<List<SaleUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleUserResponse.class));
	return future.join();
}
public List<SaleUserResponse> findBySaleUserIsActive(
	SaleUserIsActive value,
	MetaRequest metaRequest
	) {

	FindBySaleUserIsActiveQuery query = new FindBySaleUserIsActiveQuery(value,metaRequest);
	CompletableFuture<List<SaleUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleUserResponse.class));
	return future.join();
}
public List<SaleUserResponse> findBySaleUserUpdatedAt(
	SaleUserUpdatedAt value,
	MetaRequest metaRequest
	) {

	FindBySaleUserUpdatedAtQuery query = new FindBySaleUserUpdatedAtQuery(value,metaRequest);
	CompletableFuture<List<SaleUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleUserResponse.class));
	return future.join();
}
public List<SaleUserResponse> findBySaleUserReference(
	SaleUserReference value,
	MetaRequest metaRequest
	) {

	FindBySaleUserReferenceQuery query = new FindBySaleUserReferenceQuery(value,metaRequest);
	CompletableFuture<List<SaleUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleUserResponse.class));
	return future.join();
}
public List<SaleUserResponse> findBySaleUserCreatedBy(
	SaleUserCreatedBy value,
	MetaRequest metaRequest
	) {

	FindBySaleUserCreatedByQuery query = new FindBySaleUserCreatedByQuery(value,metaRequest);
	CompletableFuture<List<SaleUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleUserResponse.class));
	return future.join();
}
public List<SaleUserResponse> findBySaleUserTenant(
	SaleUserTenant value,
	MetaRequest metaRequest
	) {

	FindBySaleUserTenantQuery query = new FindBySaleUserTenantQuery(value,metaRequest);
	CompletableFuture<List<SaleUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleUserResponse.class));
	return future.join();
}

}
