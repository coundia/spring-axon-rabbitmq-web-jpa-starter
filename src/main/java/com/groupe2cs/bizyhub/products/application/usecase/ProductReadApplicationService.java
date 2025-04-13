package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.query.*;
import com.groupe2cs.bizyhub.products.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ProductReadApplicationService {

private final QueryGateway queryGateway;


public ProductPagedResponse findAll(int page, int limit) {

	FindAllProductQuery query = new FindAllProductQuery(page, limit);
	CompletableFuture<ProductPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ProductPagedResponse.class));
	return future.join();
}


public ProductResponse findByProductId(ProductId value) {

	FindByProductIdQuery query = new FindByProductIdQuery(value);
	CompletableFuture<ProductResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(ProductResponse.class));
	return future.join();
}


public List<ProductResponse> findByProductName(ProductName value) {

	FindByProductNameQuery query = new FindByProductNameQuery(value);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}
public List<ProductResponse> findByProductPrice(ProductPrice value) {

	FindByProductPriceQuery query = new FindByProductPriceQuery(value);
	CompletableFuture<List<ProductResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(ProductResponse.class));
	return future.join();
}

}
