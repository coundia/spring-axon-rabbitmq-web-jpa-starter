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
public class StockLevelReadApplicationService {

private final QueryGateway queryGateway;


public StockLevelPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllStockLevelQuery query = new FindAllStockLevelQuery(page, limit,metaRequest);
	CompletableFuture<StockLevelPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(StockLevelPagedResponse.class));
	return future.join();
}


public StockLevelResponse findByStockLevelId(StockLevelId value, MetaRequest metaRequest) {

	FindByStockLevelIdQuery query = new FindByStockLevelIdQuery(value,metaRequest);
	CompletableFuture<StockLevelResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(StockLevelResponse.class));
	return future.join();
}


public List<StockLevelResponse> findByStockLevelStockOnHand(
	StockLevelStockOnHand value,
	MetaRequest metaRequest
	) {

	FindByStockLevelStockOnHandQuery query = new FindByStockLevelStockOnHandQuery(value,metaRequest);
	CompletableFuture<List<StockLevelResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockLevelResponse.class));
	return future.join();
}
public List<StockLevelResponse> findByStockLevelStockAllocated(
	StockLevelStockAllocated value,
	MetaRequest metaRequest
	) {

	FindByStockLevelStockAllocatedQuery query = new FindByStockLevelStockAllocatedQuery(value,metaRequest);
	CompletableFuture<List<StockLevelResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockLevelResponse.class));
	return future.join();
}
public List<StockLevelResponse> findByStockLevelProductVariant(
	StockLevelProductVariant value,
	MetaRequest metaRequest
	) {

	FindByStockLevelProductVariantQuery query = new FindByStockLevelProductVariantQuery(value,metaRequest);
	CompletableFuture<List<StockLevelResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockLevelResponse.class));
	return future.join();
}
public List<StockLevelResponse> findByStockLevelSyncAt(
	StockLevelSyncAt value,
	MetaRequest metaRequest
	) {

	FindByStockLevelSyncAtQuery query = new FindByStockLevelSyncAtQuery(value,metaRequest);
	CompletableFuture<List<StockLevelResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockLevelResponse.class));
	return future.join();
}
public List<StockLevelResponse> findByStockLevelCompany(
	StockLevelCompany value,
	MetaRequest metaRequest
	) {

	FindByStockLevelCompanyQuery query = new FindByStockLevelCompanyQuery(value,metaRequest);
	CompletableFuture<List<StockLevelResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockLevelResponse.class));
	return future.join();
}
public List<StockLevelResponse> findByStockLevelCreatedBy(
	StockLevelCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByStockLevelCreatedByQuery query = new FindByStockLevelCreatedByQuery(value,metaRequest);
	CompletableFuture<List<StockLevelResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockLevelResponse.class));
	return future.join();
}
public List<StockLevelResponse> findByStockLevelTenant(
	StockLevelTenant value,
	MetaRequest metaRequest
	) {

	FindByStockLevelTenantQuery query = new FindByStockLevelTenantQuery(value,metaRequest);
	CompletableFuture<List<StockLevelResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(StockLevelResponse.class));
	return future.join();
}

}
