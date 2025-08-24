package com.groupe2cs.bizyhub.stock.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.stock.application.query.*;
import com.groupe2cs.bizyhub.stock.application.mapper.*;
import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class StockMovementReadApplicationService {

private final QueryGateway queryGateway;


public StockMovementPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllStockMovementQuery query = new FindAllStockMovementQuery(page, limit,metaRequest);
	CompletableFuture<StockMovementPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(StockMovementPagedResponse.class));
	return future.join();
}


public StockMovementResponse findByStockMovementId(StockMovementId value, MetaRequest metaRequest) {

	FindByStockMovementIdQuery query = new FindByStockMovementIdQuery(value,metaRequest);
	CompletableFuture<StockMovementResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(StockMovementResponse.class));
	return future.join();
}


public List<StockMovementResponse> findByStockMovementTypeStockMovement(
	StockMovementTypeStockMovement value,
	MetaRequest metaRequest
	) {

	FindByStockMovementTypeStockMovementQuery query = new FindByStockMovementTypeStockMovementQuery(value,metaRequest);
	CompletableFuture<List<StockMovementResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockMovementResponse.class));
	return future.join();
}
public List<StockMovementResponse> findByStockMovementQuantity(
	StockMovementQuantity value,
	MetaRequest metaRequest
	) {

	FindByStockMovementQuantityQuery query = new FindByStockMovementQuantityQuery(value,metaRequest);
	CompletableFuture<List<StockMovementResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockMovementResponse.class));
	return future.join();
}
public List<StockMovementResponse> findByStockMovementRemoteId(
	StockMovementRemoteId value,
	MetaRequest metaRequest
	) {

	FindByStockMovementRemoteIdQuery query = new FindByStockMovementRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<StockMovementResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockMovementResponse.class));
	return future.join();
}
public List<StockMovementResponse> findByStockMovementLocalId(
	StockMovementLocalId value,
	MetaRequest metaRequest
	) {

	FindByStockMovementLocalIdQuery query = new FindByStockMovementLocalIdQuery(value,metaRequest);
	CompletableFuture<List<StockMovementResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockMovementResponse.class));
	return future.join();
}
public List<StockMovementResponse> findByStockMovementCompany(
	StockMovementCompany value,
	MetaRequest metaRequest
	) {

	FindByStockMovementCompanyQuery query = new FindByStockMovementCompanyQuery(value,metaRequest);
	CompletableFuture<List<StockMovementResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockMovementResponse.class));
	return future.join();
}
public List<StockMovementResponse> findByStockMovementSyncAt(
	StockMovementSyncAt value,
	MetaRequest metaRequest
	) {

	FindByStockMovementSyncAtQuery query = new FindByStockMovementSyncAtQuery(value,metaRequest);
	CompletableFuture<List<StockMovementResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockMovementResponse.class));
	return future.join();
}
public List<StockMovementResponse> findByStockMovementProductVariant(
	StockMovementProductVariant value,
	MetaRequest metaRequest
	) {

	FindByStockMovementProductVariantQuery query = new FindByStockMovementProductVariantQuery(value,metaRequest);
	CompletableFuture<List<StockMovementResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockMovementResponse.class));
	return future.join();
}
public List<StockMovementResponse> findByStockMovementOrderLineId(
	StockMovementOrderLineId value,
	MetaRequest metaRequest
	) {

	FindByStockMovementOrderLineIdQuery query = new FindByStockMovementOrderLineIdQuery(value,metaRequest);
	CompletableFuture<List<StockMovementResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockMovementResponse.class));
	return future.join();
}
public List<StockMovementResponse> findByStockMovementDiscriminator(
	StockMovementDiscriminator value,
	MetaRequest metaRequest
	) {

	FindByStockMovementDiscriminatorQuery query = new FindByStockMovementDiscriminatorQuery(value,metaRequest);
	CompletableFuture<List<StockMovementResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockMovementResponse.class));
	return future.join();
}
public List<StockMovementResponse> findByStockMovementCreatedBy(
	StockMovementCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByStockMovementCreatedByQuery query = new FindByStockMovementCreatedByQuery(value,metaRequest);
	CompletableFuture<List<StockMovementResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockMovementResponse.class));
	return future.join();
}
public List<StockMovementResponse> findByStockMovementTenant(
	StockMovementTenant value,
	MetaRequest metaRequest
	) {

	FindByStockMovementTenantQuery query = new FindByStockMovementTenantQuery(value,metaRequest);
	CompletableFuture<List<StockMovementResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockMovementResponse.class));
	return future.join();
}

}
