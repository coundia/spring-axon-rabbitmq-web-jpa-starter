package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindByTransactionCategoryHandler {

private final TransactionRepository repository;
@QueryHandler
public List<TransactionResponse> handle(FindByTransactionCategoryQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();

String value = query.getCategory().value();
	List<Transaction> entities = repository.findByCategoryIdAndCreatedById(value, metaRequest.getUserId());
	return entities.stream()
	.map(TransactionMapper::toResponse)
	.toList();
	}


}
