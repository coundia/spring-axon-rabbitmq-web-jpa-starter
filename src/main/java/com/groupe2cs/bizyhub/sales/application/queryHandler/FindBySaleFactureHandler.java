package com.groupe2cs.bizyhub.sales.application.queryHandler;

import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import com.groupe2cs.bizyhub.sales.application.query.FindBySaleFactureQuery;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindBySaleFactureHandler {

    private final SaleRepository repository;

    @QueryHandler
    public List<SaleResponse> handle(FindBySaleFactureQuery query) {
        String value = query.getFacture().value();
        List<Sale> entities = repository.findByFacture(value);
        return entities.stream().map(SaleMapper::toResponse).toList();
    }
}
