package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionIdQuery;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionNotFoundException;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByTransactionIdHandler {

    private final TransactionRepository repository;

    @QueryHandler
    public TransactionResponse handle(FindByTransactionIdQuery query) {
        String value = query.getId().value();
        Transaction entity = repository.findById(value)
                .orElseThrow(() -> new TransactionNotFoundException(query.getId()));
        return TransactionMapper.toResponse(entity);
    }

}
