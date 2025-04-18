package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.transactions.application.dto.TransactionPagedResponse;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindAllTransactionQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllTransactionQueryHandler {

    private final TransactionRepository repository;

    public FindAllTransactionQueryHandler(TransactionRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public TransactionPagedResponse handle(FindAllTransactionQuery query) {
        int limit = query.getLimit();
        int offset = query.getPage() * limit;

        long totalElements = repository.count();

        PageRequest pageable = PageRequest.of(offset / limit, limit);

        Page<Transaction> pages = repository.findAll(pageable);

        List<TransactionResponse> responses = pages.stream()
                .map(TransactionMapper::toResponse)
                .toList();

        return TransactionPagedResponse.from(
                pages,
                responses
        );
    }
}
