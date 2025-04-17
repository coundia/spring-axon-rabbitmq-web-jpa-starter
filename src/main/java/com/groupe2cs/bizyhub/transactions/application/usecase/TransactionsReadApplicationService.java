package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TransactionsReadApplicationService {

private final QueryGateway queryGateway;


public TransactionsPagedResponse findAll(int page, int limit) {

	FindAllTransactionsQuery query = new FindAllTransactionsQuery(page, limit);
	CompletableFuture<TransactionsPagedResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionsPagedResponse.class));
	return future.join();
}


public TransactionsResponse findByTransactionsId(TransactionsId value) {

	FindByTransactionsIdQuery query = new FindByTransactionsIdQuery(value);
	CompletableFuture<TransactionsResponse> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionsResponse.class));
	return future.join();
}


public List<TransactionsResponse> findByTransactionsReference(TransactionsReference value) {

	FindByTransactionsReferenceQuery query = new FindByTransactionsReferenceQuery(value);
	CompletableFuture<List<TransactionsResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionsResponse.class));
	return future.join();
}
public List<TransactionsResponse> findByTransactionsAmount(TransactionsAmount value) {

	FindByTransactionsAmountQuery query = new FindByTransactionsAmountQuery(value);
	CompletableFuture<List<TransactionsResponse>> future = queryGateway.query(query,
	org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionsResponse.class));
	return future.join();
}

}
