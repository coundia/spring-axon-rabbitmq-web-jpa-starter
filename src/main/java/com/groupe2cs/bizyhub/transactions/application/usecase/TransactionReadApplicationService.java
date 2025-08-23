package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TransactionReadApplicationService {

private final QueryGateway queryGateway;


public TransactionPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllTransactionQuery query = new FindAllTransactionQuery(page, limit,metaRequest);
	CompletableFuture<TransactionPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionPagedResponse.class));
	return future.join();
}


public TransactionResponse findByTransactionId(TransactionId value, MetaRequest metaRequest) {

	FindByTransactionIdQuery query = new FindByTransactionIdQuery(value,metaRequest);
	CompletableFuture<TransactionResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionResponse.class));
	return future.join();
}


public List<TransactionResponse> findByTransactionName(
	TransactionName value,
	MetaRequest metaRequest
	) {

	FindByTransactionNameQuery query = new FindByTransactionNameQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionAmount(
	TransactionAmount value,
	MetaRequest metaRequest
	) {

	FindByTransactionAmountQuery query = new FindByTransactionAmountQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionDetails(
	TransactionDetails value,
	MetaRequest metaRequest
	) {

	FindByTransactionDetailsQuery query = new FindByTransactionDetailsQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionIsActive(
	TransactionIsActive value,
	MetaRequest metaRequest
	) {

	FindByTransactionIsActiveQuery query = new FindByTransactionIsActiveQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionSyncAt(
	TransactionSyncAt value,
	MetaRequest metaRequest
	) {

	FindByTransactionSyncAtQuery query = new FindByTransactionSyncAtQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionAccount(
	TransactionAccount value,
	MetaRequest metaRequest
	) {

	FindByTransactionAccountQuery query = new FindByTransactionAccountQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionCategory(
	TransactionCategory value,
	MetaRequest metaRequest
	) {

	FindByTransactionCategoryQuery query = new FindByTransactionCategoryQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionTypeTransactionRaw(
	TransactionTypeTransactionRaw value,
	MetaRequest metaRequest
	) {

	FindByTransactionTypeTransactionRawQuery query = new FindByTransactionTypeTransactionRawQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionDateTransaction(
	TransactionDateTransaction value,
	MetaRequest metaRequest
	) {

	FindByTransactionDateTransactionQuery query = new FindByTransactionDateTransactionQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionCreatedBy(
	TransactionCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByTransactionCreatedByQuery query = new FindByTransactionCreatedByQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionTenant(
	TransactionTenant value,
	MetaRequest metaRequest
	) {

	FindByTransactionTenantQuery query = new FindByTransactionTenantQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}

}
