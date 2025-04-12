package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sales.application.query.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class SaleReadApplicationService {

private final QueryGateway queryGateway;


public SalePagedResponse findAll(int page, int limit) {

	FindAllSaleQuery query = new FindAllSaleQuery(page, limit);
	CompletableFuture<SalePagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SalePagedResponse.class));
	return future.join();
}


public SaleResponse findBySaleId(SaleId value) {

	FindBySaleIdQuery query = new FindBySaleIdQuery(value);
	CompletableFuture<SaleResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(SaleResponse.class));
	return future.join();
}


public List<SaleResponse> findBySaleQuantity(SaleQuantity value) {

	FindBySaleQuantityQuery query = new FindBySaleQuantityQuery(value);
	CompletableFuture<List<SaleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleResponse.class));
	return future.join();
}
public List<SaleResponse> findBySaleTotal_price(SaleTotal_price value) {

	FindBySaleTotal_priceQuery query = new FindBySaleTotal_priceQuery(value);
	CompletableFuture<List<SaleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleResponse.class));
	return future.join();
}
public List<SaleResponse> findBySaleFacture(SaleFacture value) {

	FindBySaleFactureQuery query = new FindBySaleFactureQuery(value);
	CompletableFuture<List<SaleResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(SaleResponse.class));
	return future.join();
}

}
