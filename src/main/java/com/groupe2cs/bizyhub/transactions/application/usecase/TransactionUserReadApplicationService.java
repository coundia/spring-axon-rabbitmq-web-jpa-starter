package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TransactionUserReadApplicationService {

private final QueryGateway queryGateway;


public TransactionUserPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllTransactionUserQuery query = new FindAllTransactionUserQuery(page, limit,metaRequest);
	CompletableFuture<TransactionUserPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionUserPagedResponse.class));
	return future.join();
}


public TransactionUserResponse findByTransactionUserId(TransactionUserId value, MetaRequest metaRequest) {

	FindByTransactionUserIdQuery query = new FindByTransactionUserIdQuery(value,metaRequest);
	CompletableFuture<TransactionUserResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionUserResponse.class));
	return future.join();
}


public List<TransactionUserResponse> findByTransactionUserName(
	TransactionUserName value,
	MetaRequest metaRequest
	) {

	FindByTransactionUserNameQuery query = new FindByTransactionUserNameQuery(value,metaRequest);
	CompletableFuture<List<TransactionUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionUserResponse.class));
	return future.join();
}
public List<TransactionUserResponse> findByTransactionUserRemoteId(
	TransactionUserRemoteId value,
	MetaRequest metaRequest
	) {

	FindByTransactionUserRemoteIdQuery query = new FindByTransactionUserRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<TransactionUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionUserResponse.class));
	return future.join();
}
public List<TransactionUserResponse> findByTransactionUserTransaction(
	TransactionUserTransaction value,
	MetaRequest metaRequest
	) {

	FindByTransactionUserTransactionQuery query = new FindByTransactionUserTransactionQuery(value,metaRequest);
	CompletableFuture<List<TransactionUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionUserResponse.class));
	return future.join();
}
public List<TransactionUserResponse> findByTransactionUserUser(
	TransactionUserUser value,
	MetaRequest metaRequest
	) {

	FindByTransactionUserUserQuery query = new FindByTransactionUserUserQuery(value,metaRequest);
	CompletableFuture<List<TransactionUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionUserResponse.class));
	return future.join();
}
public List<TransactionUserResponse> findByTransactionUserSyncAt(
	TransactionUserSyncAt value,
	MetaRequest metaRequest
	) {

	FindByTransactionUserSyncAtQuery query = new FindByTransactionUserSyncAtQuery(value,metaRequest);
	CompletableFuture<List<TransactionUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionUserResponse.class));
	return future.join();
}
public List<TransactionUserResponse> findByTransactionUserUsername(
	TransactionUserUsername value,
	MetaRequest metaRequest
	) {

	FindByTransactionUserUsernameQuery query = new FindByTransactionUserUsernameQuery(value,metaRequest);
	CompletableFuture<List<TransactionUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionUserResponse.class));
	return future.join();
}
public List<TransactionUserResponse> findByTransactionUserDetails(
	TransactionUserDetails value,
	MetaRequest metaRequest
	) {

	FindByTransactionUserDetailsQuery query = new FindByTransactionUserDetailsQuery(value,metaRequest);
	CompletableFuture<List<TransactionUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionUserResponse.class));
	return future.join();
}
public List<TransactionUserResponse> findByTransactionUserIsActive(
	TransactionUserIsActive value,
	MetaRequest metaRequest
	) {

	FindByTransactionUserIsActiveQuery query = new FindByTransactionUserIsActiveQuery(value,metaRequest);
	CompletableFuture<List<TransactionUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionUserResponse.class));
	return future.join();
}
public List<TransactionUserResponse> findByTransactionUserCreatedBy(
	TransactionUserCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByTransactionUserCreatedByQuery query = new FindByTransactionUserCreatedByQuery(value,metaRequest);
	CompletableFuture<List<TransactionUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionUserResponse.class));
	return future.join();
}
public List<TransactionUserResponse> findByTransactionUserTenant(
	TransactionUserTenant value,
	MetaRequest metaRequest
	) {

	FindByTransactionUserTenantQuery query = new FindByTransactionUserTenantQuery(value,metaRequest);
	CompletableFuture<List<TransactionUserResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionUserResponse.class));
	return future.join();
}

}
