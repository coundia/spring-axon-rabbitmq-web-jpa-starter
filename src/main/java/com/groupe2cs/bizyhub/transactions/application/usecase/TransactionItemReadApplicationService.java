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
public class TransactionItemReadApplicationService {

private final QueryGateway queryGateway;


public TransactionItemPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllTransactionItemQuery query = new FindAllTransactionItemQuery(page, limit,metaRequest);
	CompletableFuture<TransactionItemPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionItemPagedResponse.class));
	return future.join();
}


public TransactionItemResponse findByTransactionItemId(TransactionItemId value, MetaRequest metaRequest) {

	FindByTransactionItemIdQuery query = new FindByTransactionItemIdQuery(value,metaRequest);
	CompletableFuture<TransactionItemResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionItemResponse.class));
	return future.join();
}


public List<TransactionItemResponse> findByTransactionItemTransaction(
	TransactionItemTransaction value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemTransactionQuery query = new FindByTransactionItemTransactionQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemProduct(
	TransactionItemProduct value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemProductQuery query = new FindByTransactionItemProductQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemLabel(
	TransactionItemLabel value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemLabelQuery query = new FindByTransactionItemLabelQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemQuantity(
	TransactionItemQuantity value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemQuantityQuery query = new FindByTransactionItemQuantityQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemUnit(
	TransactionItemUnit value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemUnitQuery query = new FindByTransactionItemUnitQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemAccount(
	TransactionItemAccount value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemAccountQuery query = new FindByTransactionItemAccountQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemRemoteId(
	TransactionItemRemoteId value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemRemoteIdQuery query = new FindByTransactionItemRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemLocalId(
	TransactionItemLocalId value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemLocalIdQuery query = new FindByTransactionItemLocalIdQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemSyncAt(
	TransactionItemSyncAt value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemSyncAtQuery query = new FindByTransactionItemSyncAtQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemUnitPrice(
	TransactionItemUnitPrice value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemUnitPriceQuery query = new FindByTransactionItemUnitPriceQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemTotal(
	TransactionItemTotal value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemTotalQuery query = new FindByTransactionItemTotalQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemNotes(
	TransactionItemNotes value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemNotesQuery query = new FindByTransactionItemNotesQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemCreatedBy(
	TransactionItemCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemCreatedByQuery query = new FindByTransactionItemCreatedByQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}
public List<TransactionItemResponse> findByTransactionItemTenant(
	TransactionItemTenant value,
	MetaRequest metaRequest
	) {

	FindByTransactionItemTenantQuery query = new FindByTransactionItemTenantQuery(value,metaRequest);
	CompletableFuture<List<TransactionItemResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionItemResponse.class));
	return future.join();
}

}
