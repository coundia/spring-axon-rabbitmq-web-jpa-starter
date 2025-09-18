package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.application.mapper.*;
import com.groupe2cs.bizyhub.products.application.query.*;
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


public List<ProductResponse> findByProductRemoteId(
	ProductRemoteId value,
	MetaRequest metaRequest
	) {

	FindByProductRemoteIdQuery query = new FindByProductRemoteIdQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductLocalId(
	ProductLocalId value,
	MetaRequest metaRequest
	) {

	FindByProductLocalIdQuery query = new FindByProductLocalIdQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductCode(
	ProductCode value,
	MetaRequest metaRequest
	) {

	FindByProductCodeQuery query = new FindByProductCodeQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
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
public List<ProductResponse> findByProductDescription(
	ProductDescription value,
	MetaRequest metaRequest
	) {

	FindByProductDescriptionQuery query = new FindByProductDescriptionQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductStatus(
	ProductStatus value,
	MetaRequest metaRequest
	) {

	FindByProductStatusQuery query = new FindByProductStatusQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductIsPublic(
	ProductIsPublic value,
	MetaRequest metaRequest
	) {

	FindByProductIsPublicQuery query = new FindByProductIsPublicQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductHasSold(
	ProductHasSold value,
	MetaRequest metaRequest
	) {

	FindByProductHasSoldQuery query = new FindByProductHasSoldQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductHasPrice(
	ProductHasPrice value,
	MetaRequest metaRequest
	) {

	FindByProductHasPriceQuery query = new FindByProductHasPriceQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductLevel(
	ProductLevel value,
	MetaRequest metaRequest
	) {

	FindByProductLevelQuery query = new FindByProductLevelQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductQuantity(
	ProductQuantity value,
	MetaRequest metaRequest
	) {

	FindByProductQuantityQuery query = new FindByProductQuantityQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductBarcode(
	ProductBarcode value,
	MetaRequest metaRequest
	) {

	FindByProductBarcodeQuery query = new FindByProductBarcodeQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductCompany(
	ProductCompany value,
	MetaRequest metaRequest
	) {

	FindByProductCompanyQuery query = new FindByProductCompanyQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductUnit(
	ProductUnit value,
	MetaRequest metaRequest
	) {

	FindByProductUnitQuery query = new FindByProductUnitQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductSyncAt(
	ProductSyncAt value,
	MetaRequest metaRequest
	) {

	FindByProductSyncAtQuery query = new FindByProductSyncAtQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductCategory(
	ProductCategory value,
	MetaRequest metaRequest
	) {

	FindByProductCategoryQuery query = new FindByProductCategoryQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductAccount(
	ProductAccount value,
	MetaRequest metaRequest
	) {

	FindByProductAccountQuery query = new FindByProductAccountQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductDefaultPrice(
	ProductDefaultPrice value,
	MetaRequest metaRequest
	) {

	FindByProductDefaultPriceQuery query = new FindByProductDefaultPriceQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductStatuses(
	ProductStatuses value,
	MetaRequest metaRequest
	) {

	FindByProductStatusesQuery query = new FindByProductStatusesQuery(value,metaRequest);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductPurchasePrice(
	ProductPurchasePrice value,
	MetaRequest metaRequest
	) {

	FindByProductPurchasePriceQuery query = new FindByProductPurchasePriceQuery(value,metaRequest);
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
