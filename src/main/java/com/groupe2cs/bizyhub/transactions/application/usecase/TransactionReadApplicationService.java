package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.application.dto.TransactionPagedResponse;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.query.FindAllTransactionQuery;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionAmountQuery;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionIdQuery;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionReferenceQuery;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionAmount;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionReference;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TransactionReadApplicationService {

    private final QueryGateway queryGateway;


    public TransactionPagedResponse findAll(int page, int limit) {

        FindAllTransactionQuery query = new FindAllTransactionQuery(page, limit);
        CompletableFuture<TransactionPagedResponse> future = queryGateway.query(query,
                org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionPagedResponse.class));
        return future.join();
    }


    public TransactionResponse findByTransactionId(TransactionId value) {

        FindByTransactionIdQuery query = new FindByTransactionIdQuery(value);
        CompletableFuture<TransactionResponse> future = queryGateway.query(query,
                org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf(TransactionResponse.class));
        return future.join();
    }


    public List<TransactionResponse> findByTransactionReference(TransactionReference value) {

        FindByTransactionReferenceQuery query = new FindByTransactionReferenceQuery(value);
        CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
                org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
        return future.join();
    }

    public List<TransactionResponse> findByTransactionAmount(TransactionAmount value) {

        FindByTransactionAmountQuery query = new FindByTransactionAmountQuery(value);
        CompletableFuture<List<TransactionResponse>> future = queryGateway.query(query,
                org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf(TransactionResponse.class));
        return future.join();
    }

}
