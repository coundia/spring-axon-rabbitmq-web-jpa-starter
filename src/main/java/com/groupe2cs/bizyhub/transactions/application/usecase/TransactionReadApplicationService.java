package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
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


public List<TransactionResponse> findByTransactionRemoteId(
	TransactionRemoteId value,
	MetaRequest metaRequest
	) {

	FindByTransactionRemoteIdQuery query = new FindByTransactionRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionLocalId(
	TransactionLocalId value,
	MetaRequest metaRequest
	) {

	FindByTransactionLocalIdQuery query = new FindByTransactionLocalIdQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionCode(
	TransactionCode value,
	MetaRequest metaRequest
	) {

	FindByTransactionCodeQuery query = new FindByTransactionCodeQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionDescription(
	TransactionDescription value,
	MetaRequest metaRequest
	) {

	FindByTransactionDescriptionQuery query = new FindByTransactionDescriptionQuery(value,metaRequest);
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
public List<TransactionResponse> findByTransactionTypeEntry(
	TransactionTypeEntry value,
	MetaRequest metaRequest
	) {

	FindByTransactionTypeEntryQuery query = new FindByTransactionTypeEntryQuery(value,metaRequest);
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
public List<TransactionResponse> findByTransactionStatus(
	TransactionStatus value,
	MetaRequest metaRequest
	) {

	FindByTransactionStatusQuery query = new FindByTransactionStatusQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionEntityName(
	TransactionEntityName value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntityNameQuery query = new FindByTransactionEntityNameQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionEntityId(
	TransactionEntityId value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntityIdQuery query = new FindByTransactionEntityIdQuery(value,metaRequest);
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
public List<TransactionResponse> findByTransactionSyncAt(
	TransactionSyncAt value,
	MetaRequest metaRequest
	) {

	FindByTransactionSyncAtQuery query = new FindByTransactionSyncAtQuery(value,metaRequest);
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
public List<TransactionResponse> findByTransactionCompany(
	TransactionCompany value,
	MetaRequest metaRequest
	) {

	FindByTransactionCompanyQuery query = new FindByTransactionCompanyQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionCustomer(
	TransactionCustomer value,
	MetaRequest metaRequest
	) {

	FindByTransactionCustomerQuery query = new FindByTransactionCustomerQuery(value,metaRequest);
	CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
	return future.join();
}
public List<TransactionResponse> findByTransactionDebt(
	TransactionDebt value,
	MetaRequest metaRequest
	) {

	FindByTransactionDebtQuery query = new FindByTransactionDebtQuery(value,metaRequest);
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
