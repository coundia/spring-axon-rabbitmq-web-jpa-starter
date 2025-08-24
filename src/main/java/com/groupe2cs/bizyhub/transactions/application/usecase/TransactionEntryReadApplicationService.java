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
public class TransactionEntryReadApplicationService {

private final QueryGateway queryGateway;


public TransactionEntryPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllTransactionEntryQuery query = new FindAllTransactionEntryQuery(page, limit,metaRequest);
	CompletableFuture<TransactionEntryPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionEntryPagedResponse.class));
	return future.join();
}


public TransactionEntryResponse findByTransactionEntryId(TransactionEntryId value, MetaRequest metaRequest) {

	FindByTransactionEntryIdQuery query = new FindByTransactionEntryIdQuery(value,metaRequest);
	CompletableFuture<TransactionEntryResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionEntryResponse.class));
	return future.join();
}


public List<TransactionEntryResponse> findByTransactionEntryRemoteId(
	TransactionEntryRemoteId value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryRemoteIdQuery query = new FindByTransactionEntryRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryCode(
	TransactionEntryCode value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryCodeQuery query = new FindByTransactionEntryCodeQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryDescription(
	TransactionEntryDescription value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryDescriptionQuery query = new FindByTransactionEntryDescriptionQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryAmount(
	TransactionEntryAmount value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryAmountQuery query = new FindByTransactionEntryAmountQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryTypeEntry(
	TransactionEntryTypeEntry value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryTypeEntryQuery query = new FindByTransactionEntryTypeEntryQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryDateTransaction(
	TransactionEntryDateTransaction value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryDateTransactionQuery query = new FindByTransactionEntryDateTransactionQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryStatus(
	TransactionEntryStatus value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryStatusQuery query = new FindByTransactionEntryStatusQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryEntityName(
	TransactionEntryEntityName value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryEntityNameQuery query = new FindByTransactionEntryEntityNameQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryEntityId(
	TransactionEntryEntityId value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryEntityIdQuery query = new FindByTransactionEntryEntityIdQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryAccount(
	TransactionEntryAccount value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryAccountQuery query = new FindByTransactionEntryAccountQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntrySyncAt(
	TransactionEntrySyncAt value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntrySyncAtQuery query = new FindByTransactionEntrySyncAtQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryCategory(
	TransactionEntryCategory value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryCategoryQuery query = new FindByTransactionEntryCategoryQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryCompany(
	TransactionEntryCompany value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryCompanyQuery query = new FindByTransactionEntryCompanyQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryCustomer(
	TransactionEntryCustomer value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryCustomerQuery query = new FindByTransactionEntryCustomerQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryDebt(
	TransactionEntryDebt value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryDebtQuery query = new FindByTransactionEntryDebtQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryCreatedBy(
	TransactionEntryCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryCreatedByQuery query = new FindByTransactionEntryCreatedByQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}
public List<TransactionEntryResponse> findByTransactionEntryTenant(
	TransactionEntryTenant value,
	MetaRequest metaRequest
	) {

	FindByTransactionEntryTenantQuery query = new FindByTransactionEntryTenantQuery(value,metaRequest);
	CompletableFuture<List<TransactionEntryResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionEntryResponse.class));
	return future.join();
}

}
