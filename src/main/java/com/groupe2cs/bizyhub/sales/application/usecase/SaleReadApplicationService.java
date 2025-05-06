package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class SaleReadApplicationService {

private final QueryGateway queryGateway;


public SalePagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllSaleQuery query = new FindAllSaleQuery(page, limit,metaRequest);
	CompletableFuture<SalePagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SalePagedResponse.class));
	return future.join();
}


public SaleResponse findBySaleId(SaleId value, MetaRequest metaRequest) {

	FindBySaleIdQuery query = new FindBySaleIdQuery(value,metaRequest);
	CompletableFuture<SaleResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SaleResponse.class));
	return future.join();
}


public List<SaleResponse> findBySaleName(
	SaleName value,
	MetaRequest metaRequest
	) {

	FindBySaleNameQuery query = new FindBySaleNameQuery(value,metaRequest);
	CompletableFuture<List<SaleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleResponse.class));
	return future.join();
}
public List<SaleResponse> findBySaleAmount(
	SaleAmount value,
	MetaRequest metaRequest
	) {

	FindBySaleAmountQuery query = new FindBySaleAmountQuery(value,metaRequest);
	CompletableFuture<List<SaleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleResponse.class));
	return future.join();
}
public List<SaleResponse> findBySaleDetails(
	SaleDetails value,
	MetaRequest metaRequest
	) {

	FindBySaleDetailsQuery query = new FindBySaleDetailsQuery(value,metaRequest);
	CompletableFuture<List<SaleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleResponse.class));
	return future.join();
}
public List<SaleResponse> findBySaleIsActive(
	SaleIsActive value,
	MetaRequest metaRequest
	) {

	FindBySaleIsActiveQuery query = new FindBySaleIsActiveQuery(value,metaRequest);
	CompletableFuture<List<SaleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleResponse.class));
	return future.join();
}
public List<SaleResponse> findBySaleUpdatedAt(
	SaleUpdatedAt value,
	MetaRequest metaRequest
	) {

	FindBySaleUpdatedAtQuery query = new FindBySaleUpdatedAtQuery(value,metaRequest);
	CompletableFuture<List<SaleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleResponse.class));
	return future.join();
}
public List<SaleResponse> findBySaleReference(
	SaleReference value,
	MetaRequest metaRequest
	) {

	FindBySaleReferenceQuery query = new FindBySaleReferenceQuery(value,metaRequest);
	CompletableFuture<List<SaleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleResponse.class));
	return future.join();
}
public List<SaleResponse> findBySaleCreatedBy(
	SaleCreatedBy value,
	MetaRequest metaRequest
	) {

	FindBySaleCreatedByQuery query = new FindBySaleCreatedByQuery(value,metaRequest);
	CompletableFuture<List<SaleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleResponse.class));
	return future.join();
}
public List<SaleResponse> findBySaleTenant(
	SaleTenant value,
	MetaRequest metaRequest
	) {

	FindBySaleTenantQuery query = new FindBySaleTenantQuery(value,metaRequest);
	CompletableFuture<List<SaleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleResponse.class));
	return future.join();
}

}
