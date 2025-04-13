package com.groupe2cs.bizyhub.sales.application.queryHandler;

import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import com.groupe2cs.bizyhub.sales.application.query.FindBySaleIdQuery;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleNotFoundException;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindBySaleIdHandler {

    private final SaleRepository repository;

    @QueryHandler
    public SaleResponse handle(FindBySaleIdQuery query) {
        String value = query.getId().value();
        Sale entity =
                repository.findById(value).orElseThrow(() -> new SaleNotFoundException(query.getId()));
        return SaleMapper.toResponse(entity);
    }
}
