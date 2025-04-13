package com.groupe2cs.bizyhub.sales.application.queryHandler;

import com.groupe2cs.bizyhub.sales.application.dto.SalePagedResponse;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import com.groupe2cs.bizyhub.sales.application.query.FindAllSaleQuery;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllSaleQueryHandler {

    private final SaleRepository repository;

    public FindAllSaleQueryHandler(SaleRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public SalePagedResponse handle(FindAllSaleQuery query) {
        int limit = query.getLimit();
        int offset = query.getPage() * limit;

        long totalElements = repository.count();

        PageRequest pageable = PageRequest.of(offset / limit, limit);

        Page<Sale> pages = repository.findAll(pageable);

        List<SaleResponse> responses = pages.stream().map(SaleMapper::toResponse).toList();

        return SalePagedResponse.from(pages, responses);
    }
}
