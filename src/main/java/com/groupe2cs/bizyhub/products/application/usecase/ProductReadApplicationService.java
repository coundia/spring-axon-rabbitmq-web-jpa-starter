package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.application.mapper.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ProductReadApplicationService {

private final QueryGateway queryGateway;


public ProductPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

	FindAllProductQuery query = new FindAllProductQuery(page, limit,metaRequest);
	CompletableFuture<ProductPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ProductPagedResponse.class));
	return future.join();
}


public ProductResponse findByProductId(ProductId value, MetaRequest metaRequest) {

	FindByProductIdQuery query = new FindByProductIdQuery(value,metaRequest);
	CompletableFuture<ProductResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ProductResponse.class));
	return future.join();
}


public List<ProductResponse> findByProductName(
	ProductName value,
	MetaRequest metaRequest
	) {

	FindByProductNameQuery query = new FindByProductNameQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductPrice(
	ProductPrice value,
	MetaRequest metaRequest
	) {

	FindByProductPriceQuery query = new FindByProductPriceQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductDetails(
	ProductDetails value,
	MetaRequest metaRequest
	) {

	FindByProductDetailsQuery query = new FindByProductDetailsQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductIsActive(
	ProductIsActive value,
	MetaRequest metaRequest
	) {

	FindByProductIsActiveQuery query = new FindByProductIsActiveQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductUpdatedAt(
	ProductUpdatedAt value,
	MetaRequest metaRequest
	) {

	FindByProductUpdatedAtQuery query = new FindByProductUpdatedAtQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductReference(
	ProductReference value,
	MetaRequest metaRequest
	) {

	FindByProductReferenceQuery query = new FindByProductReferenceQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductCreatedBy(
	ProductCreatedBy value,
	MetaRequest metaRequest
	) {

	FindByProductCreatedByQuery query = new FindByProductCreatedByQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductTenant(
	ProductTenant value,
	MetaRequest metaRequest
	) {

	FindByProductTenantQuery query = new FindByProductTenantQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}

}
