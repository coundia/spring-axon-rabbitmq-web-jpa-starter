package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionPagedResponse;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TransactionReadApplicationService {

	private final QueryGateway queryGateway;


	public TransactionPagedResponse findAll(int page, int limit, MetaRequest metaRequest) {

		FindAllTransactionQuery query = new FindAllTransactionQuery(page, limit, metaRequest);
		CompletableFuture<TransactionPagedResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionPagedResponse.class));
		return future.join();
	}


	public TransactionResponse findByTransactionId(TransactionId value, MetaRequest metaRequest) {

		FindByTransactionIdQuery query = new FindByTransactionIdQuery(value, metaRequest);
		CompletableFuture<TransactionResponse> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionResponse.class));
		return future.join();
	}


	public List<TransactionResponse> findByTransactionReference(
			TransactionReference value,
			MetaRequest metaRequest
	) {

		FindByTransactionReferenceQuery query = new FindByTransactionReferenceQuery(value, metaRequest);
		CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
		return future.join();
	}

	public List<TransactionResponse> findByTransactionAmount(
			TransactionAmount value,
			MetaRequest metaRequest
	) {

		FindByTransactionAmountQuery query = new FindByTransactionAmountQuery(value, metaRequest);
		CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
		return future.join();
	}

	public List<TransactionResponse> findByTransactionCreatedBy(
			TransactionCreatedBy value,
			MetaRequest metaRequest
	) {

		FindByTransactionCreatedByQuery query = new FindByTransactionCreatedByQuery(value, metaRequest);
		CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
		return future.join();
	}

	public List<TransactionResponse> findByTransactionTenant(
			TransactionTenant value,
			MetaRequest metaRequest
	) {

		FindByTransactionTenantQuery query = new FindByTransactionTenantQuery(value, metaRequest);
		CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
				org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
		return future.join();
	}

}
