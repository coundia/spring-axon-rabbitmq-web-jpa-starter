package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemPagedResponse;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionItemMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindAllTransactionItemQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionItem;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllTransactionItemQueryHandler {

	private final TransactionItemRepository repository;

	public FindAllTransactionItemQueryHandler(TransactionItemRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public TransactionItemPagedResponse handle(FindAllTransactionItemQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<TransactionItem> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all TransactionItems");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<TransactionItemResponse> responses = pages.stream()
				.map(TransactionItemMapper::toResponse)
				.toList();

		return TransactionItemPagedResponse.from(
				pages,
				responses
		);
	}
}
